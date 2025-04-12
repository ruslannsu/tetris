package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonListener implements ActionListener {
    Controller controller_;
    ButtonListener(Controller controller) {
        controller_ = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        controller_.execute(command);
    }
}
