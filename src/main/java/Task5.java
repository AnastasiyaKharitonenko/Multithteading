public class Task5 {

    public static void main(String[] args) throws InterruptedException {
        Task5 task5 = new Task5();

        Thread thread0 = new Thread(() -> {
            Thread thread1 = new Thread(() -> task5.printThread());
            thread1.start();
            task5.printThread();

            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread0.start();
        thread0.join();
    }

    public void printThread() {
        synchronized (this) {
            for (int i = 1; i < 11; i++) {
                System.out.println("Строка № " + i + " " + Thread.currentThread().getName());
                notify();
                if (i != 10) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}


