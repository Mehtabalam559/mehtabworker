package Assignment1;
class TaskQueue {
    private final int[] tasks;
    private int numTasks;
    private int completedTasks;

    public TaskQueue(int numTasks) {
        this.tasks = new int[numTasks];
        this.numTasks = numTasks;
        this.completedTasks = 0;
        for (int i = 0; i < numTasks; i++) {
            tasks[i] = i + 1;
        }
    }

    public synchronized int getTask() {
        if (numTasks > 0) {
            int task = tasks[--numTasks];
            return task;
        } else {
            return -1; 
        }
    }

    public synchronized void completeTask() {
        completedTasks++;
        if (completedTasks == tasks.length) {
            notifyAll(); 
        }
    }

    public synchronized void waitForCompletion() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

