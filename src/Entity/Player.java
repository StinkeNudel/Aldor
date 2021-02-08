package Entity;

import Worlds.Game;

import java.awt.*;

public class Player extends Entity {

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
        g.fillRect((int)x, (int)y, 64, 128);
    }

    /**
     * keyboard input
     */
    private void input() {
        if((game.getKeyHandler().w) && (game.getKeyHandler().a) ||
                (game.getKeyHandler().w) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().d) ||
                (game.getKeyHandler().s) && (game.getKeyHandler().a)) {
            speed = speed/1.5;
        }

        if(game.getKeyHandler().w){
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

}
