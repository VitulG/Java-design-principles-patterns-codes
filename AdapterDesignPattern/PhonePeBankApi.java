package AdapterDesignPattern;

public interface PhonePeBankApi {
    double checkBalance(Long accountId, Long txnPIN);
    void sendMoney(Long from, Long to, double amount);
}
