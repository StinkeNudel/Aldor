package Worlds;

import Main.ImageLoader;
import Main.MotionHandler;
import Main.MouseHandler;

import java.awt.*;
import java.awt.image.BufferedImage;


public class MenuWorld extends Worlds{
    private final BufferedImage newWorldButton = ImageLoader.loadImage("/Menu/newWorldButton.png");
    private final BufferedImage loadWorldButton = ImageLoader.loadImage("/Menu/loadWorldButton.png");
    private final BufferedImage newWorldButtonSelected = ImageLoader.loadImage("/Menu/newWorldButtonSelected.png");
    private final BufferedImage loadWorldButtonSelected = ImageLoader.loadImage("/Menu/loadWorldButtonSelected.png");
    private final BufferedImage optionsButton = ImageLoader.loadImage("/Menu/optionsButton.png");
    private final BufferedImage optionsButtonSelected = ImageLoader.loadImage("/Menu/optionsButtonSelected.png");

private int buttonsX = 1000, buttonsY = 300, buttonsHeight = 96, buttonsWidth = 396, buttonsDistance = 100;

    /**
     * Constructor
     */
    public MenuWorld(Game game){
        super(game);
    }

    /**
     * World tick
     */
    @Override
    public void tick(){
        input();
    }

    /**
     * World render
     */
    @Override
    public void render(Graphics g){
        renderMenu(g);
    }


    private void renderMenu(Graphics g){
        if(MotionHandler.getMouseX() > buttonsX && MotionHandler.getMouseX() < buttonsX + buttonsWidth && MotionHandler.getMouseY() > buttonsY && MotionHandler.getMouseY() < buttonsY + buttonsHeight){
            g.drawImage(newWorldButtonSelected, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }else{
            g.drawImage(newWorldButton, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }
        buttonsY = buttonsY + buttonsDistance;

        if(MotionHandler.getMouseX() > buttonsX && MotionHandler.getMouseX() < buttonsX + buttonsWidth && MotionHandler.getMouseY() > buttonsY && MotionHandler.getMouseY() < buttonsY + buttonsHeight){
            g.drawImage(loadWorldButtonSelected, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }else{
            g.drawImage(loadWorldButton, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }
        buttonsY = buttonsY + buttonsDistance;

        if(MotionHandler.getMouseX() > buttonsX && MotionHandler.getMouseX() < buttonsX + buttonsWidth && MotionHandler.getMouseY() > buttonsY && MotionHandler.getMouseY() < buttonsY + buttonsHeight){
            g.drawImage(optionsButtonSelected, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }else{
            g.drawImage(optionsButton, buttonsX, buttonsY, buttonsWidth, buttonsHeight, null);
        }

        buttonsY = 300;
    }

    /**
     * KeyInput
     */
    public void input(){
        mouseInput();
    }

    public void mouseInput(){
        if(MouseHandler.getClickX() > buttonsX && MouseHandler.getClickX() < buttonsX + buttonsWidth &&
                MouseHandler.getClickY() > buttonsY && MouseHandler.getClickY() < buttonsY + buttonsHeight){
            System.out.println("NewWorld");
        }
        buttonsY = buttonsY + buttonsDistance;
        if(MouseHandler.getClickX() > buttonsX && MouseHandler.getClickX() < buttonsX + buttonsWidth &&
                MouseHandler.getClickY() > buttonsY && MouseHandler.getClickY() < buttonsY + buttonsHeight){
            System.out.println("LoadGame");
        }
        buttonsY = buttonsY + buttonsDistance;
        if(MouseHandler.getClickX() > buttonsX && MouseHandler.getClickX() < buttonsX + buttonsWidth &&
                MouseHandler.getClickY() > buttonsY && MouseHandler.getClickY() < buttonsY + buttonsHeight){
            TestWorld testWorld = new TestWorld(game);
            Worlds.setWorld(testWorld);
        }
        buttonsY = 300;
        MouseHandler.reset();
    }
}



