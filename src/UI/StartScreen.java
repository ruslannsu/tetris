package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame{
    private String iconpath;
    private ImageIcon icon;
    private JPanel button_panel;
    private JButton start_button, exit_button;
    private final int width, height;
    public StartScreen(String winTitle, String path, int w, int h) {
        super(winTitle);
        iconpath = path;
        width = w;
        height = h;
        setSize(width, height);
        button_panel = new JPanel();
        start_button = new JButton("Start");
        exit_button = new JButton("Exit");
        button_panel.add(start_button);
        button_panel.add(exit_button);
        start_button.setActionCommand("Start");
        exit_button.setActionCommand("Exit");
        getContentPane().add(BorderLayout.NORTH, button_panel);
    }
    public void initButtonListener(ActionListener listener) {
        start_button.addActionListener(listener);
        exit_button.addActionListener(listener);
    }
    public void startChange() {
        start_button.setText("IS RUNNING");
    }
    public void endChange() {
        start_button.setText("Start");
    }
}
