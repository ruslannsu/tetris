package Model;


import UI.View;

import java.util.ArrayList;

public class Model {
    View view_;
    int[][] blocks_;
    int width_;
    int height_;
    public Model(int width, int height, View view) {
        view_ = view;
        blocks_ = new int[width][height];

    }

}

