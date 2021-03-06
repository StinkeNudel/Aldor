package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Display {

    private JFrame frame; //JFrame
    private Canvas canvas; //Canvas

    private String title; //Title of the game
    private int width, height; //Size of the game
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    /**
     * Constructor
     *
     * @param title  Title of the game
     * @param width  Width of the game
     * @param height Height of the game
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    /**
     * creates the Window
     */
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

        canvas.addMouseMotionListener(new MotionHandler());
        canvas.addMouseListener(new MouseHandler());
    }

    /**
     * @return canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * @return JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * closes the JFrame
     */
    public void closeFrame() {
        frame.dispose();
    }
}
