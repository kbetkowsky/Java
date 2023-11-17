package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton startButton = new JButton("START");
    private JButton resetButton = new JButton("RESET");
    private JLabel timeLabel = new JLabel();
    private int elapsedTime = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private Timer timer;

    Stopwatch() {
        initializeUI();

        startButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    private void initializeUI() {
        timeLabel.setText(formatTime());
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        startButton.setFocusable(false);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        resetButton.setFocusable(false);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        timer = new Timer(1000, e -> updateElapsedTime());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            handleStartButtonClick();
        } else if (e.getSource() == resetButton) {
            handleResetButtonClick();
        }
    }

    private void handleStartButtonClick() {
        if (!timer.isRunning()) {
            startButton.setText("STOP");
            timer.start();
        } else {
            startButton.setText("START");
            timer.stop();
        }
    }

    private void handleResetButtonClick() {
        startButton.setText("START");
        timer.stop();
        resetTime();
    }

    private void updateElapsedTime() {
        elapsedTime += 1000;
        hours = elapsedTime / 3600000;
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;
        timeLabel.setText(formatTime());
    }

    private void resetTime() {
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        timeLabel.setText(formatTime());
    }

    private String formatTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}
