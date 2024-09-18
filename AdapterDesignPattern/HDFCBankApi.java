package AdapterDesignPattern;

public class HDFCBankApi {
    public double getBankBalance(Long txnPIN) {
        return 80000.78d;
    }

    public void sendMoneyToPeople(Long to, Long from, double amount) {
        System.out.println("sending money to people via HDFCBankApi...");
    }
}
