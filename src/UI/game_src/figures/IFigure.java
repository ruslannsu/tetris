package UI.game_src.figures;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class IFigure {
    public IFigure(ArrayList<Rectangle> blocks) {
        blocks_ = blocks;
    }
    ArrayList<Rectangle> blocks_;
    public void changeYCoordinate(int shift) {
        for (int i = 0; i != blocks_.size(); ++i) {
            blocks_.get(i).y += shift;
        }
    }
    public ArrayList<Rectangle> getBlocks() {
        return blocks_;
    }
    public boolean checkMaxY(int bottom_y) {
        int m = 0;
        for (int i = 0; i != blocks_.size(); ++i) {
            if (blocks_.get(i).y >= m) {
                m = blocks_.get(i).y;
            }

        }
        System.out.println(m);
        if (m == bottom_y - getBlocks().get(0).getHeight()) {
            return false;
        }
        return true;
    }
}
