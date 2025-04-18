package UI.game_src;

import UI.game_src.figures.Figure;

import java.awt.*;
import java.util.ArrayList;

public class FigureUtils {
    Graphics2D g_;
    int block_width_;
    int block_height_;
    public FigureUtils(int block_height, int block_width) {
        block_height_ = block_height;
        block_width_ = block_width;
    }
    public void updateGraphics(Graphics g) {
        g_ = (Graphics2D)(g);
    }

    public void drawFigure(Figure figure) {
        ArrayList<Rectangle> blocks = figure.getBlocks();
        Color color = figure.getColor();
        for (int i = 0; i != blocks.size(); ++i) {
            g_.setColor(color);
            g_.draw(blocks.get(i));
            g_.fill(blocks.get(i));
            g_.setColor(Color.BLACK);
            g_.drawRect(blocks.get(i).x, blocks.get(i).y, blocks.get(i).width, blocks.get(i).height);
        }
    }

}
