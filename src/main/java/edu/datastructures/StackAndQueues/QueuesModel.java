package edu.datastructures.StackAndQueues;


public class QueuesModel {
    static private ArrayQueueApp queue1, queue2, queue3, queue4, queue5;

    QueuesModel(int size) {
        queue1 = new ArrayQueueApp(size);
        queue2 = new ArrayQueueApp(size);
        queue3 = new ArrayQueueApp(size);
        queue4 = new ArrayQueueApp(size);
        queue5 = new ArrayQueueApp(size);
    }

    public void queueChoose(long num) {
        try {
            long[] sums = new long[5];
            int minIndex = 0;
            queue1.display("1");
            queue2.display("2");
            queue3.display("3");
            queue4.display("4");
            queue5.display("5");

            sums[0] = queue1.getSum();
            sums[1] = queue2.getSum();
            sums[2] = queue3.getSum();
            sums[3] = queue4.getSum();
            sums[4] = queue5.getSum();

            for (int i = 0; i < sums.length; i++) {
                if (sums[i] == -1 && minIndex == i)
                    minIndex++;
                if (minIndex != sums.length && sums[i] < sums[minIndex] && sums[i] != -1)
                    minIndex = i;
            }
            System.out.println("min: " + minIndex);
            switch (minIndex) {
                case 0:
                    queue1.insert(num);
                    break;
                case 1:
                    queue2.insert(num);
                    break;
                case 2:
                    queue3.insert(num);
                    break;
                case 3:
                    queue4.insert(num);
                    break;
                case 4:
                    queue5.insert(num);
                    break;
            }
        } catch (StackException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeOne(int queueNum) {
        long sleepTime;
        try {
            switch (queueNum) {
                case 0:
                    if (!queue1.isEmpty()) {
                        sleepTime = queue1.peek();
                        Thread.sleep(sleepTime * 200);
                        queue1.remove();
                    }
                    break;
                case 1:
                    if (!queue2.isEmpty()) {
                        sleepTime = queue2.peek();
                        Thread.sleep(sleepTime * 200);
                        queue2.remove();
                    }
                    break;
                case 2:
                    if (!queue3.isEmpty()) {
                        sleepTime = queue3.peek();
                        Thread.sleep(sleepTime * 200);
                        queue3.remove();
                    }
                    break;
                case 3:
                    if (!queue4.isEmpty()) {
                        sleepTime = queue4.peek();
                        Thread.sleep(sleepTime * 200);
                        queue4.remove();
                    }
                    break;
                case 4:
                    if (!queue5.isEmpty()) {
                        sleepTime = queue5.peek();
                        Thread.sleep(sleepTime * 200);
                        queue5.remove();
                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class QueueThread implements Runnable {
    private Thread thread;

    QueueThread(String name) {
        thread = new Thread(this);
        thread.setName(name);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            QueuesModel.removeOne((int) Thread.currentThread().getName().charAt(0) - '0');
        }
    }
}

class QueuesModelUser {
    public static void main(String[] args) throws Exception {
        QueuesModel queuesModel = new QueuesModel(10);

        for (int i = 0; i < 5; i++) {
            new QueueThread(Integer.toString(i));
        }

        while (true) {
            long newCustomer = (long) (Math.random() * 29 + 1);
            queuesModel.queueChoose(newCustomer);
            Thread.sleep(500);
            System.out.println();

        }
    }
}