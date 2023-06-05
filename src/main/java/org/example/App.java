package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements Runnable, ActionListener {
    JFrame frame = new JFrame();
    JButton[] btn = new JButton[9];
    JPanel aPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel title = new JLabel();

    @Override
    public void run() {

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(640, 640);
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(aPanel);
        frame.add(bPanel);

        aPanel.setBackground(Color.red);
        aPanel.add(title);
        aPanel.setBounds(0, 0, 640, 160);
        aPanel.setLayout(new GridBagLayout());

        bPanel.setBackground(Color.blue);
        bPanel.setBounds(0, 160, 640, 480);

        title.setText("Tic Tac Toe");
        title.setFont(new Font("Z003", Font.PLAIN, 75));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main (String[] args) throws Exception {
        SwingUtilities.invokeLater(new App());
    }
}
