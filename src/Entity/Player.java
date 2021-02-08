package Entity;

import Main.ImageLoader;
import Worlds.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private final BufferedImage playerLegFront = ImageLoader.loadImage("/Player/playerLegFront.png");
    private final BufferedImage playerLegFrontWalk1 = ImageLoader.loadImage("/Player/playerLegFrontWalk1.png");
    private final BufferedImage playerLegFrontWalk2 = ImageLoader.loadImage("/Player/playerLegFrontWalk2.png");
    private final BufferedImage playerLegFrontWalk3 = ImageLoader.loadImage("/Player/playerLegFrontWalk3.png");
    private final BufferedImage playerLegFrontWalk4 = ImageLoader.loadImage("/Player/playerLegFrontWalk4.png");

    private int playerLegFrontWidth = 78, playerLegFrontHeight = 84;

    int walkAnimation = 1;
    int waitForAnimationWalk = 0;
    double speed = 4;


    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    -> X-Coordinate
     * @param y    -> Y-Coordinate
     */
    public Player(Game game, double x, double y) {
        super(game, x, y);

    }

    /**
     * updates the player
     */
    public void tick() {
        input();
    }

    /**
     * renders the Player
     *
     * @param g Graphics g
     */
    public void render(Graphics g) {
        animationWalkFront(g);
    }

    /**
     * keyboard input
     */
    private void input() {
        if ((game.getKeyHandler().w) && (game.getKeyHandler().a) ||
                (game.getKeyHandler().w) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().a)) {
            speed = speed / 1.5;
        }

        if (game.getKeyHandler().w) {
            y = y - speed;
        }
        if (game.getKeyHandler().a) {
            x = x - speed;
        }
        if (game.getKeyHandler().s) {
            y = y + speed;
        }
        if (game.getKeyHandler().d) {
            x = x + speed;
        }
        speed = 4;
    }

    /**
     * WalkAnimationFront
     * @param g
     */
    public void animationWalkFront(Graphics g) {
        waitForAnimationWalk++;

        switch (walkAnimation) {
            case 1:
            case 4:
                g.drawImage(playerLegFront, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 2:
                g.drawImage(playerLegFrontWalk1, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 3:
                g.drawImage(playerLegFrontWalk2, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 5:
                g.drawImage(playerLegFrontWalk3, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 6:
                g.drawImage(playerLegFrontWalk4, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
        }
        if (waitForAnimationWalk == 350) {
            waitForAnimationWalk = 0;
            walkAnimation++;
        }
        if (walkAnimation > 6) {
            walkAnimation = 1;
        }

    }

}
