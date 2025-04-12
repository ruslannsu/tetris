package UI.game_src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Environment extends JPanel {
    FigureCreator figure_creator_;
    int width_shift_;
    int height_shift_;
    int x_;
    int y_;
    int block_width_num_;
    int block_height_num_;
    ArrayList<Integer> widths_;
    ArrayList<Integer> heights_;
    int height_ratio_;
    int width_ratio;

    public Environment(int x, int y, int height_shift, int width_shift, int block_width_num, int block_height_num) {
        width_shift_ = width_shift;
        height_shift_ = height_shift;
        x_ = x;
        y_ = y;
        block_height_num_ = block_height_num;
        block_width_num_ = block_width_num;
        widths_ = new ArrayList<>();
        heights_ = new ArrayList<>();

    }
    @Override
    protected void paintComponent(Graphics g) {
        heights_.add(getHeight());
        widths_.add(getWidth());
        super.paintComponent(g);
        ((Graphics2D) g).setColor(Color.GRAY);
        g.fillRect(x_, y_, getWidth() - width_shift_, getHeight() - height_shift_);
        figure_creator_ = new FigureCreator(getWidth() / block_width_num_, getHeight() / block_height_num_);
        figure_creator_.drawLFigure(g, 10, 30);
        figure_creator_.drawJFigure(g, 200, 30);
        figure_creator_.drawOFigure(g, 10, 200);
        figure_creator_.drawTFigure(g, 200, 250);
    }

}
