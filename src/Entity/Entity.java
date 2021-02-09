package Entity;

import Worlds.Game;

import java.awt.*;

public abstract class Entity{

    public double x, y; // Coordinates
    public int width, height; //width and height of the Entity.Entity
    protected Game game; //Main.Worlds.Game Object

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     * @param x    X-Coordinate
     * @param y    Y-Coordinate
     */
    public Entity(Game game, double x, double y){
        this.x = x;
        this.y = y;
        this.game = game;
    }

    /**
     * updates the entity
     */
    public abstract void tick();

    /**
     * render the entity
     *
     * @param g Graphics g
     */
    public abstract void render(Graphics g);

    /**
     * returns a Rectangle that has the size of the Entity.Entity
     */
    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, width, height);
    }

    /**
     * @return x-Coordinate
     */
    public double getX(){
        return x;
    }

    /**
     * @return Y-Coordinate
     */
    public double getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
