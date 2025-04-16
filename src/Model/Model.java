package Model;


import UI.View;
import UI.game_src.Coordinates;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    Color[][] blocks_;
    int width_;
    int height_;
    public Model() {
    }
    public void initModel(int w, int h) {
        blocks_ = new Color[w][h];
        for (int i = 0; i != w; ++i) {
            for (int j = 0; j != h; ++j) {
                blocks_[i][j] = Color.PINK;
            }
        }
        width_ = w;
        height_ = h;
    }
    Color[][] getBlocks() {
        return blocks_;
    }
    void initBlocksByFigure(ArrayList<Coordinates> blocks_array, Color color) {
        for (int i = 0; i != blocks_array.size(); ++i) {
            blocks_[blocks_array.get(i).x_][blocks_array.get(i).y_] = color;
        }
    }


}

