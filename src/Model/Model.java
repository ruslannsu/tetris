package Model;


import UI.game_src.BlockData;
import game.DataExchanger;

import java.util.ArrayList;

public class Model {
    DataExchanger data_exchanger_;
    ArrayList<BlockData> blocks_coordinates_list_;
    public Model() {
        blocks_coordinates_list_ = new ArrayList<>();
    }
    public void addExchanger(DataExchanger de) {
        data_exchanger_ = de;
    }
    public ArrayList<BlockData> getBlocksList() {
        return blocks_coordinates_list_;
    }


}

