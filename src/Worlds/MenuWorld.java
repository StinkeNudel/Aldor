package Worlds;

import Entity.Player;
import Main.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;


public class MenuWorld extends Worlds{
    private final BufferedImage newWorldButton = ImageLoader.loadImage("/Menu/newWorldButton.png");
    private final BufferedImage loadWorldButton = ImageLoader.loadImage("/Menu/loadWorldButton.png");
    private final BufferedImage newWorldButtonSelected = ImageLoader.loadImage("/Menu/newWorldButtonSelected.png");
    private final BufferedImage loadWorldButtonSelected = ImageLoader.loadImage("/Menu/loadWorldButtonSelected.png");
    private final BufferedImage optionsButton = ImageLoader.loadImage("/Menu/optionsButton.png");
    private final BufferedImage optionsButtonSelected = ImageLoader.loadImage("/Menu/optionsButtonSelected.png");
    private BufferedImage cursor = ImageLoader.loadImage("/Menu/Cursor1.png");

    Player player;


    /**
     * Constructor
     */
    public MenuWorld(Game game){
        super(game);

        player = new Player(game, 300, 300);
    }

    /**
     * World tick
     */
    @Override
    public void tick(){
        input();

        player.tick();
    }

    /**
     * World render
     */
    @Override
    public void render(Graphics g){
        renderMenu(g);
        player.render(g);
    }


    private void renderMenu(Graphics g){
        g.drawImage(newWorldButton, 100, 100, 396, 92, null);
    }

    /**
     * KeyInput
     */
    public void input(){

    }


/**
 public void cursorAnimation(Graphics g) {
 switch (cursorAnimation) {
 case 0:
 cursor = ImageLoader.loadImage("/Menu/Cursor1.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation++;
 }
 break;
 case 1:
 cursor = ImageLoader.loadImage("/Menu/Cursor2.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation++;
 }
 break;
 case 2:
 case 6:
 cursor = ImageLoader.loadImage("/Menu/Cursor3.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation++;
 }
 break;
 case 3:
 case 5:
 cursor = ImageLoader.loadImage("/Menu/Cursor4.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation++;
 }
 break;
 case 4:
 cursor = ImageLoader.loadImage("/Menu/Cursor5.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation++;
 }
 break;
 case 7:
 cursor = ImageLoader.loadImage("/Menu/Cursor2.png");
 g.drawImage(cursor, 19 * Game.blockSize, (int) (3.5 * Game.blockSize) + menuPosition * (int) (2.3 * Game.blockSize), (int) (Game.blockSize * 1.3), (int) (Game.blockSize / 1.2), null);
 if (cursorAnimationCounter >= 5) {
 cursorAnimation = 0;
 }
 break;


 }
 }
 */
}



