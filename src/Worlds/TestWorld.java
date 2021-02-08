package Worlds;

import Entity.Player;

import java.awt.*;

public class TestWorld extends Worlds {

    Player player;

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     */
    public TestWorld(Game game) {
        super(game);
        player = new Player(game, 300, 300);
    }

    /**
     * updates the world
     */
    public void tick() {
        player.tick();
    }

    /**
     * renders the world
     *
     * @param g -> Graphics g
     */
    public void render(Graphics g) {
        player.render(g);
    }

}
