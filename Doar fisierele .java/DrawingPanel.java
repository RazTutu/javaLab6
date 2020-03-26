package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.awt.Color.BLACK;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Random randNumber = new Random();
        // generate radius as random number from 0 to 100
        int rand_nr = randNumber.nextInt(100);
        int radius = rand_nr;
        //get number of sides from configPanel
        int sides = (int) frame.configPanel.sidesField.getValue();

        //create random colors
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r, g, b, 0.5f); //TO DO; //create a transparent random Color.

        if (frame.configPanel.colorCombo.getSelectedItem().equals("Black")) {
            graphics.setColor(BLACK);

        } else {
            graphics.setColor(color);
        }
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that? - se apeleaza inainte de a apela metoda paint

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
