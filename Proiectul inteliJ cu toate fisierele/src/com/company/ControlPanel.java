package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    DrawingPanel newPanel;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        //add bottom buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(e -> System.exit(0));
        //nu stiu de ce dar load merge doar daca apas click oriunde pe canvas dupa ce am apasat pe buton
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);

    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("b:/zJava/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("b:/zJava/tux.jpg"));
            frame.canvas.graphics.drawImage(img, 0, 0, this);
            frame.repaint();
        } catch (IOException c) {
            System.err.println("loading image exception");
        }

    }

    private void reset(ActionEvent e) {
        try {
            frame.canvas.graphics.setColor(new Color(255, 255, 255));
            frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
            frame.repaint();
        } catch (Exception b) {
            System.out.println("Reset button error");
        }
    }


}