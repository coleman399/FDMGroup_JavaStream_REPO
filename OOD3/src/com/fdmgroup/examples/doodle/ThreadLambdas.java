

public class ThreadLambdas {
    public static void main(String[] args) {
        // Thread t = new Thread(new Runnable() {
        //     public void run() {
        //         doSomething();
        //     }
        // });
        // t.start();

        Runnable target = () -> doSomething();
        Thread t = new Thread(target);
        t.start();

    }

    private static void doSomething() {
        System.out.println("In doSomething()");
    }
}
