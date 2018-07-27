package down;

import down.CIKDatabase;
import down.CIKRequest;

class CIKList {
    public static final String[] mSp500 = [];
    private CIKDatabase mCikDb;

    public CIKList() {
        mCikDb = CIKDatabase.getCikDatabase();
    }

    private HashMap<String, Integer> loadCikFromDb(ArrayList<String> tickers) {
        HashMap<String, Integer> cikLoaded = new HashMap<String, String>();

        for (int i = 0; i < tickers.size(); i++) {
            int q = mCikDb.queryCik(tickers.get(i));
            if (q < 0) continue;
            else {
                cikLoaded.put(tickers.get(i), q);
            }
        }

        return cikLoaded;
    }

    private HashMap<String, String> requestAndUpdate(ArrayList<String> tickers) {
        HashMap<String, Integer> cikRequested = new HashMap<String, Integer>();
        for (int i = 0; i < tickers.size(); i++) {
            int result = CIKRequest.getCIK(tickers.get(i));
            if (result > 0) {
                
            }
        }
    }
}