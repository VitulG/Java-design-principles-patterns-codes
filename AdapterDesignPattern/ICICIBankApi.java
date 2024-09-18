package AdapterDesignPattern;

public class ICICIBankApi {
    public double showBalance(Long txnId, Long accountId) {
        return 974537.67d;
    }

    public void sendMoneyToUser(double amount, Long from, Long to) {
        System.out.println("Sending money to user via ICICI bank api...");
    }
}
