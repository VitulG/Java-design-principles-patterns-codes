package AdapterDesignPattern;

public class HDFCBankAdapter implements PhonePeBankApi {
    private final HDFCBankApi hdfcBank;

    public HDFCBankAdapter() {
        this.hdfcBank = new HDFCBankApi();
    }

    @Override
    public double checkBalance(Long accountId, Long txnPIN) {
        return this.hdfcBank.getBankBalance(txnPIN);
    }

    @Override
    public void sendMoney(Long from, Long to, double amount) {
        this.hdfcBank.sendMoneyToPeople(to, from, amount);
    }
}
