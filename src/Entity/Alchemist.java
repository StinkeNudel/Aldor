package Entity;

import Main.ImageLoader;
import Worlds.Game;
import Worlds.Worlds;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alchemist extends Entity {

    Rectangle speakBox;

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    -> X-Coordinate
     * @param y    -> Y-Coordinate
     */
    public Alchemist(Game game, double x, double y) {
        super(game, x, y);

        speakBox = new Rectangle((int) x, (int) y, 100, 100);
    }

    /**
     * updates the alchemist
     */
    public void tick() {

    }

    /**
     * renders the alchemist
     *
     * @param g Graphics g
     */
    public void render(Graphics g) {
    }

    public void checkPlayerToTalk() {
        //speakBox.intersects(Worlds.getWorld().)

    }
}
