package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KListener implements KeyListener {
    Controller controller_;
    public KListener(Controller controller) {
        controller_ = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        String command = "NULL";
        switch (e.getKeyCode()) {
            case (37):
                command = "LEFT-ROTATE";
                break;
            case (39):
                command = "RIGHT-ROTATE";
                break;
            case (38):
                command = "ROTATE";
        }
        controller_.execute(command);
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
