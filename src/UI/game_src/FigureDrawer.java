package UI.game_src;

import java.awt.*;
import java.util.ArrayList;

public class FigureDrawer {
    Graphics2D g_;
    int block_width_;
    int block_height_;
    public FigureDrawer(Graphics g, int block_height, int block_width) {
        g_ = (Graphics2D)(g);
        block_height_ = block_height;
        block_width_ = block_width;
    }
    public void drawFigure(ArrayList<Coordinates> blocks) {
        for (int i = 0; i != blocks.size(); ++i) {
            Rectangle rectangle = new Rectangle(blocks.get(i).x_, blocks.get(i).y_, block_width_, block_height_);
            g_.setColor(Color.RED);
            g_.draw(rectangle);
            g_.fill(rectangle);
            g_.setColor(Color.BLACK);
            g_.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

}
