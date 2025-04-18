package game;

import Model.Model;
import UI.View;
import UI.game_src.BlockData;
import UI.game_src.figures.Figure;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DataExchanger {
    Model model_;
    View view_;
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
    void sendDataFromModel() {
    }
    public ArrayList<BlockData> getModelList() {
        return model_.getBlocksList();
    }
}
