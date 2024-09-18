package AdapterDesignPattern;

public class ICICIBankAdapter implements PhonePeBankApi {
    private final ICICIBankApi iciciBankApi;

    public ICICIBankAdapter() {
        this.iciciBankApi = new ICICIBankApi();
    }

    @Override
    public double checkBalance(Long accountId, Long txnPIN) {
        return this.iciciBankApi.showBalance(txnPIN, accountId);
    }

    @Override
    public void sendMoney(Long from, Long to, double amount) {
        this.iciciBankApi.sendMoneyToUser(amount, from, to);
    }
}
