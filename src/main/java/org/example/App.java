package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class App implements Runnable, ActionListener {
    JFrame frame = new JFrame();
    JButton[] btn = new JButton[9];
    JPanel aPanel = new JPanel(new BorderLayout());
    JPanel bPanel = new JPanel(new GridLayout(3, 3));
    JLabel title = new JLabel();
    boolean playerOneTurn;
    boolean playerTwoTurn;
    Object playerOneName;
    Object playerTwoName;


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
        title.setFont(new Font("TlwgTypewriter", Font.PLAIN, 40));
        title.setHorizontalAlignment(JLabel.CENTER);

        bPanel.setBackground(Color.black);

        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            bPanel.add(btn[i]);
            btn[i].setFont(new Font("TlwgTypewriter", Font.PLAIN, 100));
            btn[i].setFocusable(false);
            btn[i].setForeground(Color.white);
            btn[i].setBackground(Color.black);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.white));
            btn[i].addActionListener(this);
        }

        startGame();
    }

    public void startGame() {

        playerOneName = JOptionPane.showInputDialog(frame, "Player 1 Name:");
        playerTwoName = JOptionPane.showInputDialog(frame, "PLayer 2 Name:");

        Random rand = new Random();
        int upperBound = 20;
        int intRandom = rand.nextInt(upperBound);

        if (intRandom % 2 == 0) {
            playerOneTurn = true;
        } else {
            playerTwoTurn = true;
        }

        if (playerOneTurn) {
            title.setText(playerOneName + " Goes First!");
        } else {
            title.setText(playerTwoName + " Goes First!");
        }
    }

    public boolean checkWin() {

        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btn[i]) {
                if (playerOneTurn) {
                    if (btn[i].getText().equals("")) {
                        btn[i].setText("X");
                        playerOneTurn = false;
                        playerTwoTurn = true;
                        title.setText();
                    }
                }

                if (playerTwoTurn) {
                    if (btn[i].getText().equals("")) {
                        btn[i].setText("O");
                        playerTwoTurn = false;
                        playerOneTurn = true;
                    }
                }
            }
        }
    }

    public static void main (String[] args) throws Exception {

        SwingUtilities.invokeLater(new App());

    }
}
