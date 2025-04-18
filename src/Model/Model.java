package Model;


import UI.View;
import UI.game_src.Coordinates;
import game.DataExchanger;

import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

public class Model {
    DataExchanger data_exchanger_;
    public Model() {
    }
    public void addExchanger(DataExchanger de) {
        data_exchanger_ = de;
    }




}

