package UI;

import UI.game_src.Environment;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import Model.Model;
import game.DataExchanger;

public class GameScreen extends JFrame {
    int width_;
    int height_;
    int angle = 0;
    int step = 90;
    DataExchanger data_exchanger_;
    Environment environment_;
    Graphics2D fig;
    public GameScreen(String winTitle, int w, int h, DataExchanger exchanger) throws Exception {
        super(winTitle);
        width_ = w;
        height_ = h;
        data_exchanger_ = exchanger;
        setSize(width_, height_);
        environment_ = new Environment(0, 0, 0, 0, 10, 20, exchanger);
        getContentPane().add(BorderLayout.CENTER, environment_);
        environment_.setSizes(w - 14, h - 37);
        environment_.figuresMotion(0);
    }
    public void initKeyListener(KeyListener key_listener) {

    }
    public void rotateFigure(String side) {
        if (side == "left") {
            angle-=45;
        }
        if (side == "right") {
            angle+=45;
        }
        repaint();
    }
}
