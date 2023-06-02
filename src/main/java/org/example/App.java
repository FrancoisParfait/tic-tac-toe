package org.example;
import javax.swing.*;

public class App implements Runnable {
    @Override
    public void run() {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(640, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String[] args) throws Exception {
        SwingUtilities.invokeLater(new App());
    }
}
