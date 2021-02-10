package Entity;

import Main.ImageLoader;
import Worlds.Game;
import Worlds.Worlds;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

    private final int playerLegFrontWidth = (int)(26 * 2), playerLegFrontHeight = (int)(28 * 2);
    private final int playerChestFrontWidth =(int)(56 * 2), playerChestFrontHeight = (int)(45 * 2);
    private final int playerHeadFrontWidth = (int)(50 * 1.5), playerHeadFrontHeight = (int)(50 * 1.5);

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
        width = playerLegFrontWidth;
        height = playerLegFrontHeight;
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
        renderBounds(g);
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
            if(checkCollisions("up")){
                walkBack = true;
                y = y - speed;
            }
        } else{
            walkBack = false;
        }

        if(game.getKeyHandler().a){
            if(checkCollisions("left")){
            x = x - speed;
            }
        }

        if(game.getKeyHandler().s){
            if(checkCollisions("down")){
                walkFront = true;
                y = y + speed;
            }
        } else{
            walkFront = false;
        }

        if(game.getKeyHandler().d){
            if(checkCollisions("right")){
                x = x + speed;
            }
        }
        speed = 4;
    }

    public Rectangle getBounds(String dir){
        if(dir.equals("up")){
            return new Rectangle((int) x + 6, (int) y + 30, width - 12, 1);
        } else if(dir.equals("down")){
            return new Rectangle((int) x + 6, (int) y + height, width - 12, 1);
        } else if(dir.equals("left")){
            return new Rectangle((int) x, (int) y + 35, 1, height - 40);
        } else if(dir.equals("right")){
            return new Rectangle((int) x + width, (int) y + 35, 1, height - 40);
        } else{
            return new Rectangle((int) x, (int) y + 40, width, height - 40);
        }
    }

    public void renderBounds(Graphics g){
        g.setColor(Color.GREEN);
        g.drawRect(getBounds("up").x , getBounds("up").y, getBounds("up").width, getBounds("up").height);
        g.drawRect(getBounds("down").x, getBounds("down").y, getBounds("down").width, getBounds("down").height);
        g.drawRect(getBounds("left").x, getBounds("left").y, getBounds("left").width, getBounds("left").height);
        g.drawRect(getBounds("right").x, getBounds("right").y, getBounds("right").width, getBounds("right").height);
        g.setColor(Color.RED);
       // g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
    }

    private boolean checkCollisions(String dir){
        ArrayList<Entity> entities = Worlds.entities;
        for(Object entity : entities){
            Entity m = (Entity) entity;
            if(!(m == this)){
                if(dir.equals("up") && getBounds("up").intersects(m.getBounds())){
                    return false;
                }
                if(dir.equals("down") && getBounds("down").intersects(m.getBounds())){
                    return false;
                }
                if(dir.equals("left") && getBounds("left").intersects(m.getBounds())){
                    return false;
                }
                if(dir.equals("right") && getBounds("right").intersects(m.getBounds())){
                    return false;
                }
            }
        }
        return true;
    }

    public void standAnimation(Graphics g){
        g.drawImage(playerLegFront, (int) x, (int) y, playerLegFrontWidth, playerLegFrontHeight, null);

        if(upDownCounter < 5000){
            g.drawImage(playerChestFront, (int) x - 30, (int) y - 70, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 138, playerHeadFrontWidth, playerHeadFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 5000 && upDownCounter < 6000){
            g.drawImage(playerChestFront, (int) x - 30, (int) y - 65, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 133, playerHeadFrontWidth, playerHeadFrontHeight, null);
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
            g.drawImage(playerChestFront, (int) x - 30, (int) y - 70, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 138, playerHeadFrontWidth, playerHeadFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 3000 && upDownCounter < 3500){
            g.drawImage(playerChestFront, (int) x - 30, (int) y - 65, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 133, playerHeadFrontWidth, playerHeadFrontHeight, null);
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
            g.drawImage(playerChestBack, (int) x - 30, (int) y - 70, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 138, playerHeadFrontWidth, playerHeadFrontHeight, null);
            upDownCounter++;
        } else if(upDownCounter >= 3000 && upDownCounter < 3500){
            g.drawImage(playerChestBack, (int) x - 30, (int) y - 65, playerChestFrontWidth, playerChestFrontHeight, null);
            g.drawImage(playerHeadFront, (int) x - 13, (int) y - 133, playerHeadFrontWidth, playerHeadFrontHeight, null);
            upDownCounter++;
        } else{
            upDownCounter = 0;
        }

    }

}
