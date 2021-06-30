package Homework7;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CountdownTimer countdown = new CountdownTimer();
            countdown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            countdown.setVisible(true);
        });
    }
}
