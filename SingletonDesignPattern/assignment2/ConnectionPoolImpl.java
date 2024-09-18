package SingletonDesignPattern.assignment2;

import java.util.concurrent.Semaphore;

public class ConnectionPoolImpl implements ConnectionPool{
    private volatile static ConnectionPoolImpl instance;
    private static final Object lock = new Object();

    private final int maxConnections;
    private final Semaphore availableConnections;

    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        this.availableConnections = new Semaphore(maxConnections);
    }

    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        synchronized (lock) {
            instance = null;
        }
    }

    @Override
    public void initializePool() {
        // No initialization needed with Semaphore
    }

    @Override
    public DatabaseConnection getConnection() {
        try{
            availableConnections.acquire();
            return new DatabaseConnection();
        } catch(InterruptedException e){
            return null;
        }
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        availableConnections.release();
    }

    @Override
    public int getAvailableConnectionsCount() {
        return availableConnections.availablePermits();
    }

    @Override
    public int getTotalConnectionsCount() {
        return maxConnections;
    }
}
