package UI;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import Model.*;

import Controller.Controller;
import game.DataExchanger;

public class View extends JFrame {
    StartScreen start_screen_;
    GameScreen game_screen_;
    Model model_;
    DataExchanger data_exchanger_;
    public void addExchanger(DataExchanger de) {
        data_exchanger_ = de;
    }
    public View() throws Exception {
        start_screen_ = new StartScreen("Tetris", " ", 500, 750);
        start_screen_.setVisible(true);
        start_screen_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start_screen_.setResizable(false);
        start_screen_.setLocationRelativeTo(null);
        start_screen_.setVisible(true);
        game_screen_ = new GameScreen("Tetris", 300, 600, data_exchanger_);
        game_screen_.setResizable(false);
        System.out.println(game_screen_.getWidth());
        setVisible(false);
    }
    public StartScreen getStartScreen() {
        return start_screen_;
    }
    public GameScreen getGameScreen() {
        return game_screen_;
    }
}