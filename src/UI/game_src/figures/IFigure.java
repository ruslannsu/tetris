package UI.game_src.figures;

import java.awt.*;

public class IFigure extends Figure {
    public IFigure(int x, int y, int block_width, int block_height) {
        super(x, y, block_width, block_height);
        color_ = Color.GREEN;
        for (int i = 0; i != 4; ++i) {
            Rectangle rect = new Rectangle(x_, y_ + i * block_height, block_width_, block_height_);
            blocks_.add(rect);
        }
    }


}
