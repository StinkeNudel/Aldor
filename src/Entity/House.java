package Entity;

import Main.ImageLoader;
import Worlds.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class House extends Entity{

    private final BufferedImage tree = ImageLoader.loadImage("/Environment/house.png");

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    X-Coordinate
     * @param y    Y-Coordinate
     */
    public House(Game game, double x, double y){
        super(game, x, y);
        width = 190 * 4;
        height = 224 * 4;
    }

    @Override
    public void tick(){
    }

    @Override
    public void render(Graphics g){
        g.drawImage(tree, (int) x, (int) y, width, height, null);
        g.drawRect((int) x, (int) y + 350, width, height - 350);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y + 350, width, height - 350);
    }
}
