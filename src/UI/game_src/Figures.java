package UI.game_src;

import java.util.ArrayList;

public class Figures {
    int width_;
    int height_;
    int block_height_;
    int block_width_;

    public Figures(int width, int height, int block_height, int block_width) {
        width_ = width;
        height_ = height;
        block_height_ = block_height;
        block_width_ = block_width;
    }
    ArrayList<Coordinates> createIFigure(int x) {
        ArrayList<Coordinates> blocks = new ArrayList<>();
        for (int y = 0; y != 4 * block_height_ ; y+=block_height_) {
            Coordinates coordinates = new Coordinates(x, y);
            System.out.println(y);
            blocks.add(coordinates);
        }
        return blocks;
    }
}
