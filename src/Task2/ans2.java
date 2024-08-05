package Task2;

import java.util.HashMap;
import java.util.Map;

public class ans2 {
    public static void main(String[] args) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",0);
        InfiniteJob timer1 = new InfiniteJob(1000,TimerAction.PRINT_NUMBERS_SERIES,params);
        timer1.start();


        params = new HashMap<>();
        params.put("message","Hello World!");
        InfiniteJob timer2 = new InfiniteJob(1000,TimerAction.PRINT_MESSAGE,params);
        timer2.start();


        InfiniteJob timer3 = new InfiniteJob(1000,TimerAction.PRINT_RANDOM_NUMBER,params);
        timer3.start();

        params = new HashMap<>();
        params.put("num1",3);
        params.put("num2",5);
        InfiniteJob timer4 = new InfiniteJob(1000,TimerAction.PRINT_LOWEST,params);
        timer4.start();
    }
}
