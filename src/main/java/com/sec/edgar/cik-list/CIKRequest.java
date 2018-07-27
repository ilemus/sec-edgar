package down;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The SEC's Edgar provides poor API to easily search for CIK based on ticker.
 * It requires a manual process of inputing a ticker into a search.
 * The CIK is then provided in the HTML response.
 * 
 * CIK or Central Index Key is used by Edgar in its file structure of company filings.
 * 
 * This class is responsible for loosely following the HTML pattern of the response for CIK search given a HTTPS query.
 * 
 * The main API is getCIK from ticker symbol.
 * 
 * @author yitzchak
 *
 */
public class CIKRequest {
    // Use count of 10 to limit data to process
    // https://www.sec.gov/cgi-bin/browse-edgar?CIK=nvda&count=10
    public static final String REQUEST_FORMAT = "https://www.sec.gov/cgi-bin/browse-edgar?CIK=%s&count=10";
    
    public static int getCIK(String ticker) {
        String response;
        try {
            String request = String.format(REQUEST_FORMAT, ticker);
            System.out.println("request: " + request);
            response = executeGet(request);
        } catch (Exception e) {
            return -3;
        }
        return parsePageForCik(response);
    }
    
    private static String executeGet(String targetUrl) throws Exception {
        HttpURLConnection conn = null;
        URL url = new URL(targetUrl);
        conn = (HttpURLConnection) url.openConnection();
        
        int code = conn.getResponseCode();
        // only 200 code is good, ignore all other codes
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
     * [0-9].10
     * 0001045810
     * 
     * CIK is 10 digits long starting with 0's.
     * It is repeated multiple times in the response and any of them are fine.
     * 
     * @param response
     * @return
     */
    private static int parsePageForCik(String response) {
        if (response == null) return -1;
        
        Pattern p = Pattern.compile("[0-9]{10}");
        Matcher m = p.matcher(response);
        
        if (!m.find()) {
            return -2;
        }
        
        int startIndex = m.start();
        
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < startIndex + 10; i++) {
            sb.append(response.charAt(i));
        }
                
        return Integer.parseInt(sb.toString());
    }
}
