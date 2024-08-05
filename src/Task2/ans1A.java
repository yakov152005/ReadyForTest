package Task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ans1A {
    private static int seconds = 5;
    private static List<Integer> numbers = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("Start t1 | while 1"); // debug
            while (numbers.isEmpty()) {
                sleep(1000);
            }
            System.out.println("Done 1!");
            System.out.println("Start t1 | while 2"); //debug
            while (true) {
                if (seconds > 0) {
                    seconds--;
                }
                sleep(1000);
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Start t2 | while 1"); //debug
            while (seconds > 0) {
                sleep(1000);
            }
            System.out.println("Start t2 | while 2"); //debug
            while (true) {
                if (numbers.size() < 10) {
                    numbers.add(new Random().nextInt());
                    sleep(1000);
                } else {
                    break;
                }
            }
            System.out.println("Done 2!");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Done 3!");
    }

    public static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

