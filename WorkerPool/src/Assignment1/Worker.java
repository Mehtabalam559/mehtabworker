package Assignment1;

class Worker implements Runnable {
    private final int id;
    private final TaskQueue taskQueue;

    public Worker(int id, TaskQueue taskQueue) {
        this.id = id;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            int task = taskQueue.getTask();
            if (task == -1) break;
            System.out.println("Worker " + id + " started task " + task);
            // task exe time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker " + id + " finished task " + task);
            taskQueue.completeTask();
        }
    }
}

