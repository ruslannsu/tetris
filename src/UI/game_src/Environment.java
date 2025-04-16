package UI.game_src;

import UI.game_src.figures.IFigure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import Model.Model;


public class Environment extends JPanel {
    int width_shift_;
    int height_shift_;
    int x_;
    int y_;
    int block_width_num_;
    int block_height_num_;
    FigureUtils figure_utils;
    Figures figures;
    IFigure i_figure_;
    int block_size_w;
    int block_size_h;
    int fig_number;
    int w_;
    int h_;


    public Environment(int x, int y, int height_shift, int width_shift, int block_width_num, int block_height_num) {
        width_shift_ = width_shift;
        height_shift_ = height_shift;
        x_ = x;
        y_ = y;
        block_height_num_ = block_height_num;
        block_width_num_ = block_width_num;
    }
    public void setSizes(int w, int h) {
        block_size_w = w / block_width_num_;
        block_size_h = h / block_height_num_;
        figure_utils = new FigureUtils(block_size_h, block_size_w);
        figures = new Figures(w, h, block_size_h, block_size_w);
        i_figure_ = new IFigure(figure_utils.CreateFigureBlocks(figures.createIFigure(w / 2)));
        int w_ = w;
        int h_ = h;
    }

    @Override
    protected void paintComponent(Graphics g) {
        switch (fig_number) {
            case 0:

        }
        figure_utils.updateGraphics(g);
        super.paintComponent(g);
        ((Graphics2D) g).setColor(Color.GRAY);
        g.fillRect(x_, y_, getWidth() - width_shift_, getHeight() - height_shift_);
        ((Graphics2D)(g)).setColor(Color.RED);
        switch (fig_number) {
            case 0:
                figure_utils.drawFigure(i_figure_.getBlocks());
                break;
        }
    }
    public void figuresMotion(int k) {
        fig_number = 0;
        System.out.println("is here");
        System.out.println(getHeight());
        Timer timer = new Timer();
        if (k != 0) {
            i_figure_.changeYCoordinate(k);
        }
        TimerTask motion = new TimerTask() {
            @Override
            public void run() {
                Dimension dim = getSize();
                int bottom = dim.height;
                System.out.println(bottom);
                switch (fig_number) {
                    case 0:
                        if (i_figure_.checkMaxY(bottom)) {
                            i_figure_.changeYCoordinate(1);
                            repaint();
                        } else {
                            i_figure_.changeYCoordinate(-bottom);
                            repaint();
                        }
                }

            }
        };
        timer.schedule(motion, 2, 3);
    }
    int getFigNum() {
        return fig_number;
    }


}
