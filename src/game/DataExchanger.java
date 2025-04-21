package game;

import Model.Model;
import UI.View;
import UI.game_src.BlockData;
import UI.game_src.figures.Figure;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class DataExchanger {
    Model model_;
    View view_;
    final int WIDTH = 10;
    public DataExchanger(Model model, View view) {
        model_ = model;
        view_ = view;
    }
    public void sendDataFromView(Figure figure) {
        for (int i = 0; i != figure.getBlocks().size(); ++i) {
            BlockData block_data = new BlockData(figure.getBlocks().get(i).x, figure.getBlocks().get(i).y, figure.getColor());
            model_.getBlocksList().add(block_data);
        }

    }
    public boolean checkBadCoordinates(Figure figure) {
        ArrayList<Rectangle> blocks = figure.getBlocks();
        for (int i = 0; i != blocks.size(); ++i) {
            int x = blocks.get(i).x;
            int y = blocks.get(i).y;
            for (int j = 0; j != model_.getBlocksList().size(); ++j) {
                if ((x == model_.getBlocksList().get(j).x_) && (y + figure.getBlockHeight() == model_.getBlocksList().get(j).y_)) {
                    return true;
                }
            }
        }
        return false;
    }
    public ArrayList<BlockData> getModelList() {
        return model_.getBlocksList();
    }
    public boolean isThereLeftNeighborsFigures(Figure figure) {
        ArrayList<Rectangle> blocks = figure.getBlocks();
        for (int i = 0; i != blocks.size(); ++i) {
            int x = blocks.get(i).x;
            int y = blocks.get(i).y;
            for (int j = 0; j != model_.getBlocksList().size(); ++j) {
                if ((x - figure.getBlockWidth() == model_.getBlocksList().get(j).x_) && (y == model_.getBlocksList().get(j).y_)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isThereRightNeighborsFigures(Figure figure) {
        ArrayList<Rectangle> blocks = figure.getBlocks();
        for (int i = 0; i != blocks.size(); ++i) {
            int x = blocks.get(i).x;
            int y = blocks.get(i).y;
            for (int j = 0; j != model_.getBlocksList().size(); ++j) {
                if ((x + 1 * figure.getBlockWidth() == model_.getBlocksList().get(j).x_) && (y == model_.getBlocksList().get(j).y_)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void clearFullLines() {
        Map<Integer,Integer> countPerRow = new HashMap<>();
        for (BlockData b : model_.getBlocksList()) {
            int y = b.getY();
            countPerRow.put(y, countPerRow.getOrDefault(y, 0) + 1);
        }
        List<Integer> fullRows = new ArrayList<>();
        for (Map.Entry<Integer,Integer> e : countPerRow.entrySet()) {
            if (e.getValue() == WIDTH) {
                fullRows.add(e.getKey());
            }
        }
        if (fullRows.isEmpty()) {
            return;
        }
        fullRows.sort(Comparator.reverseOrder());

        model_.getBlocksList().removeIf(b -> fullRows.contains(b.getY()));

        for (BlockData b : model_.getBlocksList()) {
            int yOld = b.y_;
            int shift = 0;
            for (int removedY : fullRows) {
                if (yOld < removedY) {
                    shift++;
                }
            }
            if (shift > 0) {
                b.y_ = (yOld + shift * view_.getGameScreen().getEnvironment().getBlockHeight());  // или yOld - shift, см. комментарий выше
            }
        }
    }
}