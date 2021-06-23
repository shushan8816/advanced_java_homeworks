package Homework3;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws ParseException {
        System.out.println("Timer ran ");
        Thread t = new Thread( new MyTimer());
        t.start();
    }
}
