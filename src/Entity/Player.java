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

    private final BufferedImage playerLegBack = ImageLoader.loadImage("/Player/playerLegBack.png");
    private final BufferedImage playerLegBackWalk1 = ImageLoader.loadImage("/Player/playerLegBackWalk1.png");
    private final BufferedImage playerLegBackWalk2 = ImageLoader.loadImage("/Player/playerLegBackWalk2.png");
    private final BufferedImage playerLegBackWalk3 = ImageLoader.loadImage("/Player/playerLegBackWalk3.png");
    private final BufferedImage playerLegBackWalk4 = ImageLoader.loadImage("/Player/playerLegBackWalk4.png");

    private int playerLegFrontWidth = 78, playerLegFrontHeight = 84;

    int walkAnimationFront = 1;
    int waitForAnimationWalkFront = 0;

    int walkAnimationBack = 1;
    int waitForAnimationWalkBack = 0;

    boolean walkFront = false, walkBack = false, standFront = false, standBack = false;

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
        if (walkFront) {
            animationWalkFront(g);
        } else if (walkBack) {
            animationWalkBack(g);
        } else {
            g.drawImage(playerLegFront, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
        }
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
            walkBack = true;
            y = y - speed;
        } else {
            walkBack = false;
        }
        if (game.getKeyHandler().a) {
            x = x - speed;
        }
        if (game.getKeyHandler().s) {
            walkFront = true;
            y = y + speed;
        } else {
            walkFront = false;
        }
        if (game.getKeyHandler().d) {
            x = x + speed;
        }
        speed = 4;
    }

    /**
     * WalkAnimationFront
     *
     * @param g
     */
    public void animationWalkFront(Graphics g) {
        waitForAnimationWalkFront++;

        switch (walkAnimationFront) {
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
        if (waitForAnimationWalkFront == 350) {
            waitForAnimationWalkFront = 0;
            walkAnimationFront++;
        }
        if (walkAnimationFront > 6) {
            walkAnimationFront = 1;
        }

    }

    /**
     * WalkAnimationFront
     *
     * @param g
     */
    public void animationWalkBack(Graphics g) {
        waitForAnimationWalkBack++;

        switch (walkAnimationBack) {
            case 1:
            case 4:
                g.drawImage(playerLegBack, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 2:
                g.drawImage(playerLegBackWalk1, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 3:
                g.drawImage(playerLegBackWalk2, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 5:
                g.drawImage(playerLegBackWalk3, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
            case 6:
                g.drawImage(playerLegBackWalk4, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);
                break;
        }
        if (waitForAnimationWalkBack == 350) {
            waitForAnimationWalkBack = 0;
            walkAnimationBack++;
        }
        if (walkAnimationBack > 6) {
            walkAnimationBack = 1;
        }

    }

}
