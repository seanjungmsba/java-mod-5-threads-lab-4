import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // This time the first thread completely executes the statements in the inc() method before the second thread can run the method.
        // It is impossible for multiple threads to run the code inside the inc() method at the same time.
        Thread t1 = new Thread(() -> IntStream.range(0, 10_000_000).forEach((i) -> counter.inc()));
        Thread t2 = new Thread(() -> IntStream.range(0, 30_000_000).forEach((i) -> counter.inc()));
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}