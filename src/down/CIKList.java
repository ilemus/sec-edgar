package down;

import down.CIKDatabase;
import down.CIKRequest;

class CIKList {
    public static final String[] mSp500 = [];
    private CIKDatabase mCikDb;

    public CIKList() {
        mCikDb = CIKDatabase.getCikDatabase();
    }

    private HashMap<String, String> loadCikFromDb(String[] tickers) {
        HashMap<String, String> cikLoaded = new HashMap<String, String>();

        for (int i = 0; i < tickers.length; i++) {
            String q = mCikDb.queryCik(tickers[i]);
            if (q == null) continue;
            else {
                cikLoaded.put(tickers[i], q);
            }
        }

        return cikLoaded;
    }
    
}
