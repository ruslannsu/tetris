package UI.game_src;

import java.awt.*;

public class FigureCreator {
    int block_width_;
    int block_height_;
    public FigureCreator(int block_width, int block_height) {
        block_width_ = block_width;
        block_height_ = block_height;
    }
    public void drawLFigure(Graphics g, int x, int y) {
        Graphics2D fig = (Graphics2D)g;
        fig.setColor(Color.BLUE);
        fig.fillRect(x, y, block_width_, block_height_ * 3);
        fig.fillRect(x, y + block_height_ * 3, block_width_ * 3, block_height_);
    }
    public void drawJFigure(Graphics g, int x, int y) {
        Graphics2D fig = (Graphics2D)g;
        fig.setColor(Color.RED);
        fig.fillRect(x, y, block_width_, block_height_ * 3);
        fig.fillRect(x - 2*block_width_, y + 3*block_height_, block_width_ * 3, block_height_);
    }
    public void drawOFigure(Graphics g, int x, int y) {
        Graphics2D fig = (Graphics2D)g;
        fig.setColor(Color.BLUE);
        fig.fillRect(x, y, block_width_ * 2, block_height_ * 2);
    }
    public void drawTFigure(Graphics g, int x, int y) {
        Graphics2D fig = (Graphics2D)g;
        fig.setColor(Color.PINK);
        fig.fillRect(x, y, block_width_ * 3, block_height_);
        fig.fillRect(x + block_width_, y, block_width_, block_height_);
    }
}
