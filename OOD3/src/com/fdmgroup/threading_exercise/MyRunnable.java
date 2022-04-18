

public class MyRunnable implements Runnable {
    String name;

    MyRunnable(String name) {
        this.name = name;
    }
    MyRunnable(String name, int count) {
        this.name = name + count;
    }

    @Override
    public void run() {
        System.out.println(name + " is running...");
    }

}
