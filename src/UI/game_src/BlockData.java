package UI.game_src;

import java.awt.*;

public class BlockData {
    public int x_;
    public int y_;
    public Color color_;
    public BlockData(int x, int y, Color color) {
        x_ = x;
        y_ = y;
        color_ = color;

    }
    public int getX() {
        return x_;
    }
    public int getY() {
        return y_;
    }
}
