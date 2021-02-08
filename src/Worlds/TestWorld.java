package Worlds;

import Entity.Player;
import Main.KeyHandler;
import Main.TextPrinter;

import java.awt.*;

public class TestWorld extends Worlds{

    Player player;
    int count = 0;
    boolean once = true;

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     */
    public TestWorld(Game game){
        super(game);
        player = new Player(game, 300, 300);
    }

    /**
     * updates the world
     */
    public void tick(){
        player.tick();
        if(game.getKeyHandler().a && once){
            count++;
            TextPrinter.clearText();
            once = false;
        }else if(!game.getKeyHandler().a){
            once = true;
        }
    }

    /**
     * renders the world
     *
     * @param g -> Graphics g
     */
    public void render(Graphics g){
        player.render(g);
        text(g);
    }

    public void text(Graphics g){
        switch(count){
            case 1:
                TextPrinter.addText("Hello There", 500, 500, g);
                break;
            case 2:
                TextPrinter.addText("General Kenobi", 500, 500, g);

        }
    }

}
