package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Drawing shapes");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);

        //invoke the layout manager
        pack();
    }
}

