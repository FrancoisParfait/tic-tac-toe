package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements Runnable, ActionListener {
    JFrame frame = new JFrame();
    JButton[] btn = new JButton[9];
    JPanel aPanel = new JPanel(new BorderLayout());
    JPanel bPanel = new JPanel(new GridLayout(3, 3));
    JLabel title = new JLabel();

    @Override
    public void run() {

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(640, 640);
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(aPanel, BorderLayout.NORTH);
        frame.add(bPanel);

        aPanel.setBackground(Color.black);
        aPanel.add(title);
        aPanel.setBounds(0, 0, 640, 160);

        title.setText("Tic Tac Toe");
        title.setForeground(Color.white);
        title.setFont(new Font("TlwgTypewriter", Font.PLAIN, 75));
        title.setHorizontalAlignment(JLabel.CENTER);

        bPanel.setBackground(Color.black);

        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            bPanel.add(btn[i]);
            btn[i].setFont(new Font("TlwgTypewriter", Font.PLAIN, 75));
            btn[i].setFocusable(false);
            btn[i].setBackground(Color.black);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.white));
        }

        startGame();
    }

    public void startGame() {


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main (String[] args) throws Exception {

        SwingUtilities.invokeLater(new App());

    }
}
