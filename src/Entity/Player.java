package Entity;

import Main.ImageLoader;
import Worlds.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

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

    private final BufferedImage playerChestFront = ImageLoader.loadImage("/Player/playerChestFront.png");
    private final BufferedImage playerChestBack = ImageLoader.loadImage("/Player/playerChestBack.png");

    private final BufferedImage playerHeadFront = ImageLoader.loadImage("/Player/playerHeadFront.png");

    private int playerLegFrontWidth = 78, playerLegFrontHeight = 84;
    private int playerChestFrontWidth = 56 * 3, playerChestFrontHeight = 45 * 3;
    private int playerHeadFrontWidth = 50 * 2, playerHeadFrontHeight = 50 * 2;

    int walkAnimationFront = 1;
    int waitForAnimationWalkFront = 0;

    int walkAnimationBack = 1;
    int waitForAnimationWalkBack = 0;

    int upDownCounter = 0;

    boolean walkFront = false, walkBack = false, standFront = false, standBack = false;

    double speed = 4;


    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    -> X-Coordinate
     * @param y    -> Y-Coordinate
     */
    public Player(Game game, double x, double y){
        super(game, x, y);
        width = 100;
        height = 80;
    }

    /**
     * updates the player
     */
    public void tick(){
        input();
    }

    /**
     * renders the Player
     *
     * @param g Graphics g
     */
    public void render(Graphics g){
        if(walkFront){
            animationWalkFront(g);
        } else if(walkBack){
            animationWalkBack(g);
        } else{
            standAnimation(g);
        }

        g.drawImage(playerHeadFront, (int)x - 10, (int)y - 200, playerHeadFrontWidth, playerHeadFrontHeight, null);
    }

    /**
     * keyboard input
     */
    private void input(){
        if((game.getKeyHandler().w) && (game.getKeyHandler().a) ||
                (game.getKeyHandler().w) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().a)){
            speed = speed / 1.5;
        }

        if(game.getKeyHandler().w){
            walkBack = true;
            y = y - speed;
        } else{
            walkBack = false;
        }
        if(game.getKeyHandler().a){
            x = x - speed;
        }
        if(game.getKeyHandler().s){
            walkFront = true;
            y = y + speed;
        } else{
            walkFront = false;
        }
        if(game.getKeyHandler().d){
            x = x + speed;
        }
        speed = 4;
    }

    public void standAnimation(Graphics g){
        g.drawImage(playerLegFront, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);

        if(upDownCounter < 5000){
            g.drawImage(playerChestFront, (int) x - 45, (int) y - 105, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 5000 && upDownCounter < 6000){
            g.drawImage(playerChestFront, (int) x - 45, (int) y - 100, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else{
            upDownCounter = 0;
        }
    }

    /**
     * WalkAnimationFront
     *
     * @param g
     */
    public void animationWalkFront(Graphics g){

        waitForAnimationWalkFront++;

        switch(walkAnimationFront){
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
        if(waitForAnimationWalkFront == 350){
            waitForAnimationWalkFront = 0;
            walkAnimationFront++;
        }
        if(walkAnimationFront > 6){
            walkAnimationFront = 1;
        }

        if(upDownCounter < 3000){
            g.drawImage(playerChestFront, (int) x - 45, (int) y - 105, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 3000 && upDownCounter < 3500){
            g.drawImage(playerChestFront, (int) x - 45, (int) y - 100, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else{
            upDownCounter = 0;
        }

    }

    /**
     * WalkAnimationBack
     *
     * @param g
     */
    public void animationWalkBack(Graphics g){
        waitForAnimationWalkBack++;

        switch(walkAnimationBack){
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
        if(waitForAnimationWalkBack == 350){
            waitForAnimationWalkBack = 0;
            walkAnimationBack++;
        }
        if(walkAnimationBack > 6){
            walkAnimationBack = 1;
        }

        if(upDownCounter < 3000){
            g.drawImage(playerChestBack, (int) x - 45, (int) y - 105, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 3000 && upDownCounter < 3500){
            g.drawImage(playerChestBack, (int) x - 45, (int) y - 100, playerChestFrontWidth, playerChestFrontHeight, null);
            upDownCounter++;
        } else{
            upDownCounter = 0;
        }

    }

}
