package Controller;

import UI.View;

public class Controller {
    View view_;
    ButtonListener button_listener;
    public Controller(View view) {
        view_ = view;
        button_listener = new ButtonListener(this);
        view_.getStartScreen().initButtonListener(button_listener);
    }

    void execute(String command) {
        if (command == "Start") {
            view_.getStartScreen().startChange();
        }
        if (command == "Exit") {
            view_.getStartScreen().setVisible(false);
        }
    }
}
