
import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    protected List<Thread> threads;

    public ThreadManager() {
        threads = new ArrayList<Thread>();
    }

    public ThreadManager(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    public void createThreads(int number) {
        for (int i = 0; i < number; i++) {
            MyRunnable runnable = new MyRunnable("thread", i);
            threads.add(new Thread(runnable));
        }
        runThreads();
    }

    public void addThread(Thread thread) {
        threads.add(thread);
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public void runThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
