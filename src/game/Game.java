package game;

import Controller.*;
import Model.*;
import UI.View;

public class Game {
    Controller controller_;
    Model model_;
    View view_;
    public Game() {
        view_ = new View();
        controller_ = new Controller(view_);
        model_ = new Model();
    }

    void sendDataToModel() {

    }
}
