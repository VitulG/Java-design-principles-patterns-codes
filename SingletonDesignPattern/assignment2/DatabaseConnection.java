package SingletonDesignPattern.assignment2;

public class DatabaseConnection {
    private static int counter;
    private int id;

    public DatabaseConnection() {
        this.id = counter++;
    }

    public int getId() {
        return this.id;
    }

    public void connect() {
        System.out.println("Connection " + id + " established.");
    }

    public void disconnect() {
        System.out.println("Connection " + id + " closed.");
    }
}
