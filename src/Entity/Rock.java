package Entity;

import Main.ImageLoader;
import Worlds.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends Entity{

    private final BufferedImage rock = ImageLoader.loadImage("/Environment/rock.png");

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    X-Coordinate
     * @param y    Y-Coordinate
     */
    public Rock(Game game, double x, double y){
        super(game, x, y);
        width = 59 * 3;
        height = 57 * 3;
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.drawImage(rock, (int) x, (int) y, width, height, null);
        //g.drawRect((int) x, (int) y + height/2 + 20, width, height/4);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y + height/2 + 20, width, height/4 + 10);
    }
}