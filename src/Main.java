public class Main {

    private static int value = 0;
    private static boolean ready = false;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        value = 42;
        ready = true;
    }
}