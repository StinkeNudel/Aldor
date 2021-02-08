package Entity;

import Worlds.Game;

import java.awt.*;

public class Player extends Entity {


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
    }

    /**
     * keyboard input
     */
    private void input() {
        if (game.getKeyHandler().w) {
        }
        if (game.getKeyHandler().a) {
        }
        if (game.getKeyHandler().s) {
        }
        if (game.getKeyHandler().d) {
        }
    }

}
