package task1;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static int seconds = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("Від запуску програми пройшло: " + seconds + " секунд");
                try{
                    Thread.sleep(1000);
                    seconds++;
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.println("Минуло 5 секунд");
        }
    }, 5000, 5000);

    thread.start();
        }
}
