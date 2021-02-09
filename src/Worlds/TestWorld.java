package Worlds;

import Entity.Entity;
import Entity.Player;
import Entity.Rock;
import Main.ImageLoader;
import Main.TextPrinter;
import Entity.Tree;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TestWorld extends Worlds{

    Player player;
    Tree tree;
    Rock rock;
    int count = 0;
    boolean once = true;

    private final BufferedImage dialogBackground = ImageLoader.loadImage("/UI/dialogBackground.png");
    private final BufferedImage grassBackground = ImageLoader.loadImage("/Backgrounds/grassBackground.png");

    /**
     * Constructor
     *
     * @param game Main.Worlds.Game Object
     */
    public TestWorld(Game game){
        super(game);
        rock = new Rock(game,800, 300);
        entities.add(rock);
        player = new Player(game, 1000, 300);
        entities.add(player);
        tree = new Tree(game, 300, 300);
        entities.add(tree);
    }

    /**
     * updates the world
     */
    public void tick(){
        player.tick();
        if(game.getKeyHandler().e && once){
            count++;
            if(count >= 3)
                count = 0;
            TextPrinter.clearText();
            once = false;
        } else if(!game.getKeyHandler().e){
            once = true;
        }
    }

    /**
     * renders the world
     *
     * @param g -> Graphics g
     */
    public void render(Graphics g){
        g.drawImage(grassBackground, 0, 0, 2000, 2000, null);
        entities.sort(getWorld().renderSorter);
        ArrayList entities = Worlds.entities;
        for (int i = 0; i < entities.size(); i++){
            Entity e = (Entity) entities.get(i);
            e.render(g);
        }
        text(g);
    }

    public void text(Graphics g){
        switch(count){
            case 1:
                System.out.println("1");
                g.drawImage(dialogBackground, 50, 550, 1800, 450, null);
                TextPrinter.addText("Hello There", 100, 700, g);
                break;
            case 2:
                g.drawImage(dialogBackground, 50, 550, 1800, 450, null);
                TextPrinter.addText("General Kenobi", 100, 700, g);

        }
    }

    public Player getPlayer(){
        return player;
    }

}
