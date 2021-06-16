package Homework3;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class MyTimer implements Runnable {

    @Override
    public void run() {
        String s = "01:03";
        LocalTime time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");

        try {
            time = LocalTime.parse(s, formatter);
        } catch (Exception e) {
            time = LocalTime.parse("00:".concat(s), formatter);
        }

        time = time.with(ChronoField.HOUR_OF_DAY, 0);

        while (!time.equals(LocalTime.of(0, 0, 0).minusSeconds(1))) {

            System.out.println(time.format(DateTimeFormatter.ofPattern("mm:ss")));
            time = time.minusSeconds(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}




