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
    Object playerOneName = "Player 1";
    Object playerTwoName;
    boolean playerOneWin;
    boolean playerTwoWin;


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

        if (playerOneName == null || playerOneName.equals("")) {
            playerOneName = "Player 1";
        }

        if (playerTwoName == null || playerTwoName.equals("")) {
            playerTwoName = "Player 2";
        }

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
        if (btn[0].getText().equals("X") && btn[1].getText().equals("X") && btn[2].getText().equals("X")) {
            colorChange(0);
            colorChange(1);
            colorChange(2);
            playerOneWin = true;
            return true;
        } else if (btn[0].getText().equals("X") && btn[4].getText().equals("X") && btn[8].getText().equals("X")) {
            colorChange(0);
            colorChange(4);
            colorChange(8);
            playerOneWin = true;
            return true;
        } else if (btn[0].getText().equals("X") && btn[3].getText().equals("X") && btn[6].getText().equals("X")) {
            colorChange(0);
            colorChange(3);
            colorChange(6);
            playerOneWin = true;
            return true;
        } else if (btn[1].getText().equals("X") && btn[4].getText().equals("X") && btn[7].getText().equals("X")) {
            colorChange(1);
            colorChange(4);
            colorChange(7);
            playerOneWin = true;
            return true;
        } else if (btn[2].getText().equals("X") && btn[5].getText().equals("X") && btn[8].getText().equals("X")) {
            colorChange(2);
            colorChange(5);
            colorChange(8);
            playerOneWin = true;
            return true;
        } else if (btn[6].getText().equals("X") && btn[4].getText().equals("X") && btn[2].getText().equals("X")) {
            colorChange(6);
            colorChange(4);
            colorChange(2);
            playerOneWin = true;
            return true;
        } else if (btn[3].getText().equals("X") && btn[4].getText().equals("X") && btn[5].getText().equals("X")) {
            colorChange(3);
            colorChange(4);
            colorChange(5);
            playerOneWin = true;
            return true;
        } else if (btn[6].getText().equals("X") && btn[7].getText().equals("X") && btn[8].getText().equals("X")) {
            colorChange(6);
            colorChange(7);
            colorChange(8);
            playerOneWin = true;
            return true;
        } else if (btn[0].getText().equals("O") && btn[4].getText().equals("O") && btn[8].getText().equals("O")) {
            colorChange(0);
            colorChange(4);
            colorChange(8);
            playerTwoWin = true;
            return true;
        } else if (btn[0].getText().equals("O") && btn[3].getText().equals("O") && btn[6].getText().equals("O")) {
            colorChange(0);
            colorChange(3);
            colorChange(6);
            playerTwoWin = true;
            return true;
        } else if (btn[1].getText().equals("O") && btn[4].getText().equals("O") && btn[7].getText().equals("O")) {
            colorChange(1);
            colorChange(4);
            colorChange(7);
            playerTwoWin = true;
            return true;
        } else if (btn[2].getText().equals("O") && btn[5].getText().equals("O") && btn[8].getText().equals("O")) {
            colorChange(2);
            colorChange(5);
            colorChange(8);
            playerTwoWin = true;
            return true;
        } else if (btn[6].getText().equals("O") && btn[4].getText().equals("O") && btn[2].getText().equals("O")) {
            colorChange(6);
            colorChange(4);
            colorChange(2);
            playerTwoWin = true;
            return true;
        } else if (btn[3].getText().equals("O") && btn[4].getText().equals("X") && btn[5].getText().equals("O")) {
            colorChange(3);
            colorChange(4);
            colorChange(5);
            playerTwoWin = true;
            return true;
        } else if (btn[6].getText().equals("O") && btn[7].getText().equals("O") && btn[8].getText().equals("O")) {
            colorChange(6);
            colorChange(7);
            colorChange(8);
            playerTwoWin = true;
            return true;
        } else if (btn[0].getText().equals("O") && btn[1].getText().equals("O") && btn[2].getText().equals("O")) {
            colorChange(0);
            colorChange(1);
            colorChange(2);
            playerTwoWin = true;
            return true;
        }
        return false;
    }

    public boolean isDraw() {

        int noDraw = 0;

        for (int i = 0; i < 9; i++) {
            if (btn[i].getText().equals("")) {
                noDraw++;
            }
        }

        if (noDraw == 0) {
            return true;
        }
        return false;
    }

    public void colorChange(int num1) {
        btn[num1].setForeground(Color.BLACK);
        btn[num1].setBackground(Color.WHITE);
    }

    public void disableButtons() {
        for (int i = 0; i < 9; i++) {
            btn[i].setEnabled(false);
        }
    }

    public void resetGame() {
        int input = JOptionPane.showConfirmDialog(null, "Start new game?", "", JOptionPane.YES_NO_OPTION);
        // 0 = yes, 1 = no

        if (input == 0) {
            frame.dispose();
            SwingUtilities.invokeLater(new App());
        } else if (input == 1) {
            frame.dispose();
        }
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
                        title.setText(playerTwoName + "'s turn");
                    }
                }

                if (playerTwoTurn) {
                    if (btn[i].getText().equals("")) {
                        btn[i].setText("O");
                        playerTwoTurn = false;
                        playerOneTurn = true;
                        title.setText(playerOneName + "'s turn");
                    }
                }

                if (checkWin()) {
                    disableButtons();
                    if (playerOneWin) {
                        title.setText(playerOneName + " wins!");
                        resetGame();
                    } else {
                        title.setText(playerTwoName + "wins!");
                        resetGame();
                    }
                }

                if (isDraw()) {
                    title.setText("Draw!");
                    resetGame();
                }
            }
        }
    }

    public static void main (String[] args) throws Exception {

        SwingUtilities.invokeLater(new App());

    }
}
