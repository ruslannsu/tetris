package Model;


import UI.View;
import UI.game_src.Coordinates;
import game.DataExchanger;

import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

public class Model {
    Color[][] blocks_matrix_;

    int width_;
    int height_;
    int block_size_h_;
    int block_size_w_;
    DataExchanger data_exchanger_;
    public Model() {
    }
    public void addExchanger(DataExchanger de) {
        data_exchanger_ = de;
    }
    public void initModel(int w, int h, int block_size_h, int block_size_w) {
        block_size_h_ = block_size_h;
        block_size_w_ = block_size_w;
        blocks_matrix_ = new Color[w][h];
        for (int i = 0; i != w; ++i) {
            for (int j = 0; j != h; ++j) {
                blocks_matrix_[i][j] = Color.PINK;
            }
        }
        width_ = w;
        height_ = h;
    }
    Color[][] getBlocks() {
        return blocks_matrix_;
    }
    void initBlocksByFigure(ArrayList<Coordinates> blocks_array, Color color) {
        for (int i = 0; i != blocks_array.size(); ++i) {
            blocks_matrix_[blocks_array.get(i).x_][blocks_array.get(i).y_] = color;
        }
    }


}

