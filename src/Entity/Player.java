package Entity;

import Main.Game;

import java.awt.*;

public class Player extends Entity {


    /**
     * Constructor
     *
     * @param game Main.Main.Game Object
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
        if (game.getKeyHandler().h) {
        }
        if (game.getKeyHandler().a) {
        }
        if (game.getKeyHandler().s) {
        }
        if (game.getKeyHandler().d) {
        }
    }

}
