package game;

import Controller.*;
import Model.*;
import UI.View;

public class Game {
    Controller controller_;
    Model model_;
    View view_;
    DataExchanger data_exchanger_;
    public Game() throws Exception {
        view_ = new View();
        controller_ = new Controller(view_);
        model_ = new Model();
        data_exchanger_ = new DataExchanger(model_, view_);
        model_.addExchanger(data_exchanger_);
        view_.addExchanger(data_exchanger_);
    }

}


//идея в том чтобы создать класс прослойку который будет хранить два нужны класса в полях, потом создать метод(например для передачи данных из модели
//во вью, который будет отдавать самой модели этот класс и сама модель будет использовать этот метод)
