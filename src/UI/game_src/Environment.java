package UI.game_src;

import UI.game_src.figures.Figure;
import UI.game_src.figures.FigureCreator;
import UI.game_src.figures.IFigure;
import UI.game_src.figures.LFigure;
import game.DataExchanger;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;


public class Environment extends JPanel {
    int width_shift_;
    int height_shift_;
    int x_;
    int y_;
    int block_width_num_;
    int block_height_num_;
    FigureUtils figure_utils;
    DataExchanger exchanger_;
    FigureCreator figure_creator_;
    int block_size_w;
    int block_size_h;
    int fig_number;
    int w_;
    int h_;
    Figure actual_figure_;


    public Environment(int x, int y, int height_shift, int width_shift, int block_width_num, int block_height_num, DataExchanger exchanger) throws Exception {
        width_shift_ = width_shift;
        height_shift_ = height_shift;
        x_ = x;
        y_ = y;
        block_height_num_ = block_height_num;
        block_width_num_ = block_width_num;
        exchanger_ = exchanger;
        figure_creator_ = new FigureCreator();
    }
    public void setSizes(int w, int h) throws Exception {
        block_size_w = w / block_width_num_;
        block_size_h = h / block_height_num_;
        figure_utils = new FigureUtils(block_size_h, block_size_w);
        int w_ = w;
        int h_ = h;
        actual_figure_ = figure_creator_.create("1", x_ / 2, y_, block_size_w, block_size_h);
    }

    @Override
    protected void paintComponent(Graphics g) {
        figure_utils.updateGraphics(g);
        super.paintComponent(g);
        ((Graphics2D) g).setColor(Color.GRAY);
        g.fillRect(x_, y_, getWidth() - width_shift_, getHeight() - height_shift_);
        figure_utils.drawFigure(actual_figure_);
    }
    public void figuresMotion(int k) {
        fig_number = 0;
        System.out.println(getHeight());
        Timer timer = new Timer();
        TimerTask motion = new TimerTask() {
            @Override
            public void run() {
                actual_figure_.updateLimitCoordinates();
                Dimension dim = getSize();
                int bottom = dim.height;
                System.out.println(actual_figure_.getBottomLimitY());
                System.out.println(bottom);
                if (bottom == actual_figure_.getBottomLimitY() + block_size_h + 3) {
                    int min = 1;
                    int max = 2;
                    int random_num = ThreadLocalRandom.current().nextInt(min, max + 1);
                    try {
                        actual_figure_ = figure_creator_.create(Integer.toString(random_num), x_, y_, block_size_w, block_size_h);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    actual_figure_.changeY(block_size_h);
                }
                repaint();
            }
        };
        timer.schedule(motion, 500, 500);
    }
    int getFigNum() {
        return fig_number;
    }
}
