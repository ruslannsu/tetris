package UI.game_src;

import UI.game_src.figures.Figure;
import UI.game_src.figures.FigureCreator;
import UI.game_src.figures.IFigure;
import UI.game_src.figures.LFigure;
import game.DataExchanger;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;


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
    ArrayList<Integer> acceptableX;
    ArrayList<Integer> acceptableY;


    public Environment(int x, int y, int height_shift, int width_shift, int block_width_num, int block_height_num) throws Exception {
        width_shift_ = width_shift;
        height_shift_ = height_shift;
        x_ = x;
        y_ = y;
        block_height_num_ = block_height_num;
        block_width_num_ = block_width_num;
        figure_creator_ = new FigureCreator();
        setDoubleBuffered(true);
    }
    public void setSizes(int w, int h) throws Exception {
        block_size_w = w / block_width_num_;
        block_size_h = h / block_height_num_;
        figure_utils = new FigureUtils(block_size_h, block_size_w);
        int w_ = w;
        int h_ = h;
        actual_figure_ = figure_creator_.create("1", x_ + 5 * block_size_w, y_, block_size_w, block_size_h);
        acceptableX = new ArrayList<>();
        acceptableY = new ArrayList<>();

        System.out.println(h_);
        System.out.println(block_height_num_);
        for (int i = 0; i <= block_width_num_; ++i) {
            acceptableX.add(w_ - block_size_w * i - 6);
        }
        for (int i = 0; i <= block_height_num_; ++i) {
            acceptableY.add(h_ - block_size_h * i - 3);
        }
        for (int i = 0; i != acceptableX.size(); ++i) {
            System.out.println(acceptableX.get(i));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        figure_utils.updateGraphics(g);
        super.paintComponent(g);
        ((Graphics2D) g).setColor(Color.GRAY);
        g.fillRect(x_, y_, getWidth() - width_shift_, getHeight() - height_shift_);
        figure_utils.drawField(exchanger_.getModelList());
        figure_utils.drawFigure(actual_figure_);
    }
    public void figuresMotion(int k) {
        fig_number = 0;
        Timer timer = new Timer();
        TimerTask motion = new TimerTask() {
            @Override
            public void run() {
                actual_figure_.updateLimitCoordinates();
                Dimension dim = getSize();
                int bottom = dim.height;
                if ((bottom == actual_figure_.getBottomLimitY() + block_size_h + 3) || (exchanger_.checkBadCoordinates(actual_figure_))) {
                    exchanger_.sendDataFromView(actual_figure_);
                    int min = 1;
                    int max = 2;
                    int random_num = ThreadLocalRandom.current().nextInt(min, max + 1);
                    try {
                        actual_figure_ = figure_creator_.create(Integer.toString(random_num), x_ + 5 * block_size_w, y_, block_size_w, block_size_h);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    actual_figure_.changeY(block_size_h);
                    System.out.println(actual_figure_.getBlocks().get(0).x);
                }
                repaint();
            }
        };
        timer.schedule(motion, 500, 500);
    }
    public void addExchanger(DataExchanger de) {
        exchanger_ = de;
    }
    int getFigNum() {
        return fig_number;
    }
    public Figure getActualFigure() {
        return actual_figure_;
    }
    public void initKeyListener(KeyListener key_listener) {
        setFocusable(true);
        System.out.println("wow");
        this.addKeyListener(key_listener);
    }
    public int getBlockWidth() {
        return block_size_w;
    }
    public void leftShiftFigure() {
        if (exchanger_.isThereLeftNeighborsFigures(actual_figure_)) {
            return;
        }
        actual_figure_.changeX(-block_size_w);
    }
    public void rightShiftFigure() {
        if (exchanger_.isThereRightNeighborsFigures(actual_figure_)) {
            return;
        }
        actual_figure_.changeX(block_size_w);
    }
    public void rotateActualFigure() {
        actual_figure_.rotate();
        for (int i = 0; i != actual_figure_.getBlocks().size(); ++i) {
            int x_dif_value = Math.abs(actual_figure_.getBlocks().get(i).x - acceptableX.getFirst());
            int acceptable_x = acceptableX.getFirst();
            for (int j = 0; j != acceptableX.size(); ++j) {
                if ((Math.abs(actual_figure_.getBlocks().get(i).x - acceptableX.get(j))) < x_dif_value) {
                    x_dif_value = (Math.abs(actual_figure_.getBlocks().get(i).x - acceptableX.get(j)));
                    acceptable_x = acceptableX.get(j);
                }
            }
            actual_figure_.getBlocks().get(i).x = acceptable_x;
            int y_dif_value = Math.abs(actual_figure_.getBlocks().get(i).y - acceptableY.getFirst());
            int acceptable_y = acceptableY.getFirst();
            for (int j = 0; j != acceptableY.size(); ++j) {
                if ((Math.abs(actual_figure_.getBlocks().get(i).y - acceptableY.get(j))) < y_dif_value) {
                    y_dif_value = (Math.abs(actual_figure_.getBlocks().get(i).y - acceptableY.get(j)));
                    acceptable_y = acceptableY.get(j);
                }
            }
            actual_figure_.getBlocks().get(i).y = acceptable_y;
            System.out.println(acceptable_y);
        }

    }
}
