package UI.game_src;

import java.awt.*;
import java.util.ArrayList;

public class FigureUtils {
    Graphics2D g_;
    int block_width_;
    int block_height_;
    public FigureUtils(int block_height, int block_width) {
        block_height_ = block_height;
        block_width_ = block_width;
    }
    public void updateGraphics(Graphics g) {
        g_ = (Graphics2D)(g);
    }

    public void drawFigure(ArrayList<Rectangle> blocks) {
        for (int i = 0; i != blocks.size(); ++i) {
            g_.setColor(Color.RED);
            g_.draw(blocks.get(i));
            g_.fill(blocks.get(i));
            g_.setColor(Color.BLACK);
            g_.drawRect(blocks.get(i).x, blocks.get(i).y, blocks.get(i).width, blocks.get(i).height);
        }
    }
    public ArrayList<Rectangle> CreateFigureBlocks(ArrayList<Coordinates> blocks_coordinates) {
        ArrayList<Rectangle> blocks = new ArrayList<>();
        for (int i = 0; i != blocks_coordinates.size(); ++i) {
            Rectangle rectangle = new Rectangle(blocks_coordinates.get(i).x_, blocks_coordinates.get(i).y_, block_width_, block_height_);
            blocks.add(rectangle);
        }
        return blocks;
    }
    public void drawMatrixBlocks(int[][] model_matrix, int w, int h) {
        for (int i = 0; i != h; ++i) {
            for (int j = 0; j != w; ++j) {
                if (model_matrix[i][j] == 1) {
                    Rectangle rect = new Rectangle(i, j, block_width_, block_height_);

                }

            }
        }
    }

}
