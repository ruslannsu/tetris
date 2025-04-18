package UI.game_src.figures;

import java.awt.*;

public class LFigure extends Figure {
    public LFigure(int x, int y, int block_width, int block_height) {
        super(x, y, block_width, block_height);
        color_ = Color.RED;
        for (int i = 0; i != 4; ++i) {
            if (i != 3) {
                Rectangle rect = new Rectangle(x_, y_ + i * block_height_, block_width_, block_height_);
                blocks_.add(rect);
            }
            else {
                Rectangle rect = new Rectangle(x_ + block_width_, y_ + (i - 1) * block_height_, block_width_, block_height_);
                blocks_.add(rect);
            }
        }
    }


    @Override
    public void rotate() {

    }
}
