

public class ThreadManagerChild extends ThreadManager {

    @Override
    public void createThreads(int number) {
        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(new MyRunnable("thread", i));
            super.threads.add(thread);
        }
        super.runThreads();
    }
}
