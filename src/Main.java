import down.CompanyIndexRequest;

public class Main {
    public static void main(String[] args) {
        int result = CIKRequest.getCIK("NVDA");
        
        System.out.println("NVDA: " + result);
    }
}
