package SingletonDesignPattern;

class Generator {
    private volatile static Generator instance;

    private Generator() {}

    public static Generator getInstance() {
        // double locking
        if(instance == null) {
            synchronized (Generator.class) {
                if(instance == null) {
                    instance = new Generator();
                }
            }
        }
        return instance;
    }

    public void display(Generator generator) {
        System.out.println(generator);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Generator generator1 = Generator.getInstance();
                generator1.display(generator1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Generator generator2 = Generator.getInstance();
                generator2.display(generator2);
            }
        });

        t1.start();
        t2.start();
    }
}
