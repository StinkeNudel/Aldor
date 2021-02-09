package Worlds;

import Entity.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Worlds {

    protected Game game;
    private static Worlds currentWorld = null;
    public static ArrayList<Entity> entities;
    public Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b){
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    /**
     * Constructor
     *
     * @param game
     */
    public Worlds(Game game) {
        this.game = game;
        entities = new ArrayList();
    }

    /**
     * sets a new world
     *
     * @param world -> new world
     */
    public static void setWorld(Worlds world) {
        currentWorld = world;
    }

    /**
     * @return current world
     */
    public static Worlds getWorld() {
        return currentWorld;
    }

    /**
     * updates the world
     */
    public abstract void tick();



    /**
     * renders the world
     *
     * @param g Graphics g
     */
    public abstract void render(Graphics g);
}
