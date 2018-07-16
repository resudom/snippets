package snippet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * Created by IVANMO on 23/7/2017.
 */
public class Semaphores {

    static AtomicInteger count = new AtomicInteger(0);
    int c = 0;

    public static void main(String[] args) {

        Semaphores semaphores = new Semaphores();
        semaphores.runThreadLoop();

    /*    ExecutorService executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);
        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(5000);
                    count.incrementAndGet();
                } else {
                    System.out.println("Could not acquire semaphore");
                }
                System.out.println(count);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));

        executor.shutdown();*/
    }

    private void runThreadLoop() {
        for (int i=0; i<10; i++){

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    c++;
                    System.out.println(c);
                }
            });
            t.start();

        }
    }

    void incrementCount(){
        count.incrementAndGet();
    }
}
