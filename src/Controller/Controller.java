package Controller;

import UI.View;

public class Controller {
    View view_;
    ButtonListener button_listener;
    KListener key_listener;
    public Controller(View view) {
        view_ = view;
        button_listener = new ButtonListener(this);
        view_.getStartScreen().initButtonListener(button_listener);
        key_listener = new KListener(this);
        view_.getGameScreen().initKeyListener(key_listener);

    }

    void execute(String command) {
        if (command == "Start") {
            view_.getStartScreen().setVisible(false);
            view_.getGameScreen().setVisible(true);
        }
        if (command == "Exit") {
            view_.getStartScreen().setVisible(false);
        }
        if (command == "LEFT-ROTATE") {
            view_.getGameScreen().rotateFigure("left");
        }
        if (command == "RIGHT-ROTATE") {
            view_.getGameScreen().rotateFigure("right");
        }


    }
}
