package AdapterDesignPattern;

public class PhonePe {
    private final PhonePeBankApi phonePeBankApi;

    public PhonePe() {
        this.phonePeBankApi = new ICICIBankAdapter();
    }

    public double checkBankBalance() {
        return phonePeBankApi.checkBalance(101L, 7890L);
    }

    public void sendMoney() {
        this.phonePeBankApi.sendMoney(1L,2L,50000);
    }
}
