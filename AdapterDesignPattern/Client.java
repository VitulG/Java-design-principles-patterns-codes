package AdapterDesignPattern;

public class Client {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe();
        System.out.println("Balance: "+phonePe.checkBankBalance());
        phonePe.sendMoney();
    }
}
