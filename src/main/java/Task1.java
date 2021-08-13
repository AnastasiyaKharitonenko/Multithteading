public class Task1 {

    public static void main(String[] args) {
        Signal signal = new Signal("sigh");

        Thread thread = new Thread(signal);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signal.setName("SIGINT");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Signal implements Runnable {
    String name;

    public Signal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    synchronized public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.name == "SIGINT") {
                System.out.println(this.name + " " + Thread.currentThread().getName());
                break;
            }
        }
    }
}