package UI;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import Controller.Controller;
public class View extends JFrame {
    StartScreen start_screen_;
    public View() {
        start_screen_ = new StartScreen("Tetris", " ", 1000, 1000);
        start_screen_.setVisible(true);
        start_screen_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start_screen_.setResizable(false);
        start_screen_.setLocationRelativeTo(null);
        start_screen_.setVisible(true);

    }
    public StartScreen getStartScreen() {
        return start_screen_;
    }
}