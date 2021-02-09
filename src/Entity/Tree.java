package Entity;

import Main.ImageLoader;
import Worlds.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tree extends Entity{

    private final BufferedImage tree = ImageLoader.loadImage("/Environment/tree.png");

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    X-Coordinate
     * @param y    Y-Coordinate
     */
    public Tree(Game game, double x, double y){
        super(game, x, y);
        width = 640;
        height = 640;
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.drawImage(tree, (int) x, (int) y, width, height, null);
    }
}
