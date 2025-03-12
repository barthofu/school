public class Main implements Runnable {

    public static void main(String[] args) {

        Main task = new Main();

        Thread thread= new Thread(task);
        thread.start();

        for(int i= 0 ; i< 100 ; i++) {
            System.out.println("I am the main thread");
            System.out.flush();
        }

    }

    public void run() {
        for(int i= 0 ; i< 100 ; i++) {
            System.out.println("I am the new thread");
        }
    }
}