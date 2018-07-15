package down;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyIndexRequest {
    // Use count of 10 to limit data to process
    // https://www.sec.gov/cgi-bin/browse-edgar?CIK=nvda&count=10
    public static final String REQUEST_FORMAT = "https://www.sec.gov/cgi-bin/browse-edgar?CIK=%s&count=10";
    
    public static int getCIK(String ticker) {
        String response;
        try {
            response = executeGet(REQUEST_FORMAT);
        } catch (Exception e) {
            return 0;
        }
        return parsePageForCik(response);
    }
    
    public static String executeGet(String targetUrl) throws Exception {
        HttpURLConnection conn = null;
        URL url = new URL(targetUrl);
        conn = (HttpURLConnection) url.openConnection();
        
        int code = conn.getResponseCode();
        // only 200 code is good
        if (code != 200) throw new Exception("Response code has an error: " + code);
        
        // Process response from server
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        // Build string response
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
            response.append("\n");
        }
        br.close();
        
        if (conn != null) conn.disconnect();
        
        return response.toString();
    }
    
    /**
     * <div class="companyInfo">
     *   <span class="companyName">
     *       SPRINT Corp 
     *   <acronym title="Central Index Key">
     *       CIK
     *   </acronym>
     *       #: 
     *   <a href="/cgi-bin/browse-edgar?action=getcompany&amp;CIK=0000101830&amp;owner=include&amp;count=10">
     *       0000101830 (see all company filings)
     * @param response
     * @return
     */
    public static int parsePageForCik(String response) {
        if (response == null) return 0;
        
        
        
        
        return 0;
    }
    
    // Lazy solution to get div with class=className
    public static String getDiv(String request, String className) {
        Pattern p = Pattern.compile(className);
        Matcher m = p.matcher(request);
        // Simply finding a string might find content instead of tag
        if (!m.matches()) {
            return "";
        }
        
        
        int startIndex = m.start();
        // find < since div class=className
        int start = -1;
        for (int i = startIndex; i >= 0; i--) {
            if (request.charAt(i) == '<') {
                start = i;
                break;
            }
        }
        
        if (start == -1) return "";
        
        StringBuilder sb = new StringBuilder();
        // There are two ways to open/close a tag:
        // 1. <tag some stuff> </tag>
        // 2. <tag for reason />
        // Strings might be containing '/' characters without > follow-up
        int openTag = 1;
        for (int i = start; i < request.length(); i++) {
            char c = request.charAt(i);
            sb.append(request.charAt(i));
            
            // This should consider tags, not brackets!!
            if (c == '>') {
                if (--openTag <= 0) break;
            } else if (c == '<') {
                openTag++;
            }
        }
        
        return sb.toString();
    }
}
