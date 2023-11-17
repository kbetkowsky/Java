package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyFrame extends JFrame {

    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private DateTimeFormatter timeFormat;
    private DateTimeFormatter dayFormat;
    private DateTimeFormatter dateFormat;

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My Clock Program");
        setLayout(new FlowLayout());
        setSize(350, 200);
        setResizable(false);

        timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
        dayFormat = DateTimeFormatter.ofPattern("EEEE");
        dateFormat = DateTimeFormatter.ofPattern("MMMMM dd, yyyy");

        timeLabel = createLabel(50, new Color(0x00FF00));
        dayLabel = createLabel(35, null);
        dateLabel = createLabel(25, null);

        add(timeLabel);
        add(dayLabel);
        add(dateLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();

        setVisible(true);
    }

    private JLabel createLabel(int fontSize, Color foregroundColor) {
        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, fontSize));
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        if (foregroundColor != null) {
            label.setForeground(foregroundColor);
        }
        return label;
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        timeLabel.setText(now.format(timeFormat));
        dayLabel.setText(now.format(dayFormat));
        dateLabel.setText(now.format(dateFormat));
    }
}
