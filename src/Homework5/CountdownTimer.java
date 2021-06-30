package Homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CountdownTimer extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JSpinner minutesField;
    private JSpinner secondsField;
    private JButton startResetButton;
    private boolean running;
    private int seconds;
    private Timer timer;

    public CountdownTimer() {
        super("My Timer");

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(content);

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx++;
        gc.gridx++;
        gc.weightx = 0;
        content.add(new JLabel("Min:"), gc);
        gc.gridx++;
        gc.weightx = 1;
        gc.insets.left = 7;
        content.add(minutesField = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1)), gc);
        gc.gridx++;
        gc.weightx = 0;
        content.add(new JLabel("Sec:"), gc);
        gc.gridx++;
        gc.weightx = 1;
        content.add(secondsField = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1)), gc);
        gc.gridx++;
        gc.weightx = 0;
        content.add(startResetButton = new JButton("Start"), gc);

        minutesField.setPreferredSize(new Dimension(50, 8));
        secondsField.setPreferredSize(new Dimension(50, 8));

        startResetButton.addActionListener(this);
        running = false;
        seconds = 0;
        timer = new Timer(500, this);
        update();

        pack();
    }

    private void update() {
        minutesField.setEnabled(!running);
        secondsField.setEnabled(!running);

        minutesField.setValue(seconds / 60);
        secondsField.setValue(seconds % 60);

        startResetButton.setText(running ? "Reset" : "Start");
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == startResetButton) {
            startOrReset();
        } else if (ev.getSource() == timer && running) {
            countdownTimer();
        }
    }

    private void startOrReset() {
        running = !running;
        if (running) {
            seconds = ((Integer) minutesField.getValue()) * 60 + ((Integer) secondsField.getValue());
            timer.start();
        } else {
            seconds = 0;
            timer.stop();
        }
        update();
    }

    private void countdownTimer() {
        if (seconds == 0) {
            running = false;
            timer.stop();
        } else {
            seconds--;
        }
        update();
    }
}
