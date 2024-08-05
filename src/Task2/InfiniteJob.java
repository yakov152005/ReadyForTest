package Task2;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class InfiniteJob {
    private int interval;
    private Map<String, Object> extraParams;
    private TimerAction action;
    private volatile boolean running = true;

    public InfiniteJob(int interval, TimerAction action, Map<String, Object> extraParams) {
        this.interval = interval;
        this.extraParams = extraParams;
        this.action = action;
    }

    public void start() {
        new Thread(() -> {
            while (running) {
                performAction();
                sleep(interval);
            }
        }).start();
    }

    private void performAction() {
        switch (action) {
            case PRINT_NUMBERS_SERIES -> {
                int start = (int) extraParams.get("start");
                int end = (int) extraParams.get("end");
                for (int i = start; i <= end; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            case PRINT_MESSAGE -> {
                String message = (String) extraParams.get("message");
                System.out.println(message);
            }
            case PRINT_RANDOM_NUMBER -> {
                System.out.println(new Random().nextInt());
            }
            case PRINT_LOWEST -> {
                List<Integer> numbers = (List<Integer>) extraParams.get("lowest");
                int lowest = numbers.stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
                System.out.println(lowest);
            }
        }
    }

    public synchronized void updateParams(String key, Object value) {
        extraParams.put(key, value);
    }


    public void stopJob() {
        running = false;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
