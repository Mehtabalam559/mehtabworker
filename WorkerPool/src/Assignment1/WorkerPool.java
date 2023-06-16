package Assignment1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerPool {
    public static void main(String[] args) {
        int numTasks = 10;
        int numWorkers = 3;

        TaskQueue taskQueue = new TaskQueue(numTasks);
        ExecutorService executorService = Executors.newFixedThreadPool(numWorkers);

        // Start worker
        for (int i = 1; i <= numWorkers; i++) {
            executorService.execute(new Worker(i, taskQueue));
        }

        // Wait tasks completed
        taskQueue.waitForCompletion();
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}
