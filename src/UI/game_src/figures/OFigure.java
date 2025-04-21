package UI.game_src.figures;

import java.awt.*;

public class OFigure extends Figure {
    public OFigure(int x, int y, int block_width, int block_height) {
        super(x, y, block_width, block_height);
        color_ = Color.YELLOW;
        for (int i = 0; i != 2; ++i) {
            Rectangle rect = new Rectangle(x_ + i * block_width_, y_, block_width_, block_height_);
            blocks_.add(rect);
        }
        for (int i = 0; i != 2; ++i) {
            Rectangle rect = new Rectangle(x_ + i * block_width_, y_ + block_height, block_width_, block_height_);
            blocks_.add(rect);
        }


    }

}
