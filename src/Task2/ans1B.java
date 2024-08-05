package Task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static Task2.ans1A.sleep;


public class ans1B {
    private static int seconds = 5;
    private static List<Integer> numbers = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("Start t1 | while 1"); // debug
            new Thread(()->{
                while (numbers.isEmpty()){
                    sleep(1000);
                }
                System.out.println("Done 1!");
            }).start();
            System.out.println("Start t1 | while 2"); // debug
            while (true){
                if (seconds > 0 ){
                    seconds--;
                }
                sleep(1000);
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println("Start t2 | while 1"); // debug
            while (seconds > 0){
                sleep(1000);
            }
            System.out.println("Start t2 | while 2"); // debug
            while (true){
                if (numbers.size() < 10){
                    numbers.add(new Random().nextInt());
                    System.out.println(numbers.size());
                        sleep(1000);
                }else {
                    break;
                }
            }
            System.out.println("Done 2!");
        });
        System.out.println("Debug1");
        t1.start();
        t2.start();
        System.out.println("Debug2");
        t1.join();
        t2.join();
        System.out.println("Done 3!");
    }
}
