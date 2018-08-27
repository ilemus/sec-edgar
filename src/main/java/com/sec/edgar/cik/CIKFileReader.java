package com.sec.edgar.cik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class CIKFileReader {
    public CIKFileReader() {
        System.out.println("why would you instantiate CIKFileReader, it is just a static class");
    }

    public static ArrayList<String> getTickerArray(String fileLocation) {
        ArrayList<String> contents = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            String line;
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return processContents(contents);
    }

    private static ArrayList<String> processContents(ArrayList<String> c) {
        ArrayList<String> tickers = new ArrayList<String>();
        // Ignore the first index
        for (int i = 1; i < c.size(); i++) {
            tickers.add(readTicker(c.get(i)));
        }

        return tickers;
    }

    private static String readTicker(String line) {
        String[] cells = line.split(",");
        if (cells.length > 0)
            // BRK.B -> BRKB
            return cells[0].replace(".", "");
        else return "";
    }
}
