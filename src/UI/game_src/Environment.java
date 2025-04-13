package UI.game_src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Environment extends JPanel {
    FigureCreator figure_creator_;
    int width_shift_;
    int height_shift_;
    int x_ = 50;
    int y_ = 50;
    int block_width_num_;
    int block_height_num_;
    ArrayList<Integer> widths_;
    ArrayList<Integer> heights_;
    int height_ratio_ = 5;
    int width_ratio_ = 5;
    Rectangle[] figures;

    public Environment(int x, int y, int height_shift, int width_shift, int block_width_num, int block_height_num) {
        width_shift_ = width_shift;
        height_shift_ = height_shift;
        x_ = x;
        y_ = y;
        block_height_num_ = block_height_num;
        block_width_num_ = block_width_num;
        widths_ = new ArrayList<>();
        heights_ = new ArrayList<>();
        //figureJ = new Rectangle(0, 0, (getWidth() / block_width_num_) * 3, (getHeight() / block_height_num_) * 3);
        figure_creator_ = new FigureCreator(getWidth() / block_width_num_, getHeight() / block_height_num_);
    }
    @Override
    protected void paintComponent(Graphics g) {
        heights_.add(getHeight());
        int block_size_w = getWidth() / block_width_num_;
        int block_size_h = getHeight() / block_height_num_;
        widths_.add(getWidth());
        super.paintComponent(g);
        ((Graphics2D) g).setColor(Color.GRAY);
        g.fillRect(x_, y_, getWidth() - width_shift_, getHeight() - height_shift_);
        ((Graphics2D)(g)).setColor(Color.RED);
        Figures figures = new Figures(getWidth(), getHeight(), block_size_h, block_size_w);
        FigureDrawer figureDrawer = new FigureDrawer(g, block_size_h, block_size_w);
        figureDrawer.drawFigure(figures.createIFigure(30));

    }

}
