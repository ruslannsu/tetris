package UI.game_src.figures;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Figure {
    ArrayList<Rectangle> blocks_;
    Color color_;
    int block_width_;
    int block_height_;
    int x_;
    int y_;
    int left_limit_x;
    int right_limit_x;
    int bottom_limit_y;

    public Figure(int x, int y, int block_width, int block_height) {
        x_ = x;
        y_ = y;
        block_width_ = block_width;
        block_height_ = block_height;
        blocks_ = new ArrayList<>();
    }
    public void updateLimitCoordinates() {
        int l_limit_x = Integer.MAX_VALUE;
        for (int i = 0; i != blocks_.size(); ++i) {
            if (blocks_.get(i).x <= l_limit_x) {
                l_limit_x = blocks_.get(i).x;
            }
        }
        left_limit_x = l_limit_x;
        int r_limit_x =  Integer.MIN_VALUE;
        for (int i = 0; i != blocks_.size(); ++i) {
            if (blocks_.get(i).x >= r_limit_x) {
                r_limit_x = blocks_.get(i).x;
            }
        }
        right_limit_x = r_limit_x;
        int b_limit_y = Integer.MIN_VALUE;
        for (int i = 0; i != blocks_.size(); ++i) {
            if (blocks_.get(i).y >= b_limit_y) {
                b_limit_y = blocks_.get(i).y;
            }
        }
        bottom_limit_y = b_limit_y;
    }


    public void changeX(int shift) {
        x_ += shift;
        for (int i = 0; i != blocks_.size(); ++i) {
            blocks_.get(i).x += shift;
        }
    }
    public void changeY(int shift) {
        y_ += shift;
        for (int i = 0; i != blocks_.size(); ++i) {
            blocks_.get(i).y += shift;
        }
    }

    public void rotate() {
        int XCenter = 0;
        int YCenter = 0;
        for (Rectangle block : blocks_) {
            XCenter += block.x;
            YCenter += block.y;
        }
        XCenter /= 4;
        YCenter /= 4;
        for (Rectangle block : blocks_) {
            double xOffset = block.x - XCenter;
            double yOffset = block.y - YCenter;
            double newX = -yOffset + XCenter;
            double newY = xOffset + YCenter;
            block.x = (int)Math.round(newX);
            block.y = (int)Math.round(newY);
        }
    }
    public ArrayList<Rectangle> getBlocks() {
        return blocks_;
    }
    public Color getColor() {
        return color_;
    }
    public int getBottomLimitY() {
        return bottom_limit_y;
    }
    public int getBlockHeight() {
        return block_height_;
    }
    public int getBlockWidth() {
        return block_width_;
    }

}
