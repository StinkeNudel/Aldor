package Worlds;

import Entity.Player;
import Main.Display;
import Main.KeyHandler;
import Main.MotionHandler;
import Worlds.Worlds;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game{

    //General
    public int width, height; //with and height of the game
    public String title; //title of the Window
    boolean running = true;

    //Input
    private KeyHandler keyHandler;
    private MotionHandler motionHandler;

    //Graphics
    private BufferStrategy bs;
    private Graphics g;
    private Display display;


    //Player
    public Player player;

    /**
     * Constructor
     */
    public Game(){
        title = "Aldor";
        width = 1920;
        height = 1080;
        init();
    }

    /**
     * initializes:
     * KeyHandler
     * JFrame
     * first World
     */
    private void init(){
        player = new Player(this, 500, 100);
        keyHandler = new KeyHandler();
        motionHandler = new MotionHandler();
        display = new Display(title, width, height); //creates Main.Main.Display
        display.getFrame().addKeyListener(keyHandler); //adds KeyListener
        MenuWorld menuWorld = new MenuWorld(this);
        Worlds.setWorld(menuWorld);
    }

    /**
     * GAME LOOP
     * frames -> fps
     * ticks -> tps
     */
    public void run(){
        int tps = 60; //ticks per second
        double timePerTick = 1000000000 / tps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        //tps counter
        int ticks = 0;

        //fps counter
        int frames = 0;
        long fpsTpsTimer = System.currentTimeMillis();

        while(running){
            //tick
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                timer = 0;
            }

            //render
            render();
            frames++;

            if(System.currentTimeMillis() - fpsTpsTimer > 1000){
                fpsTpsTimer = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "  TPS: " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    /**
     * updates the game
     */
    private void tick(){
        keyHandler.tick();
        if(Worlds.getWorld() != null){
            Worlds.getWorld().tick();
        }
    }

    /**
     * renders the game
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);

        //Draw Here!
        if(Worlds.getWorld() != null){
            Worlds.getWorld().render(g); //render current world
        }
        //EndDrawing

        bs.show();
        g.dispose();
    }

    public KeyHandler getKeyHandler(){
        return keyHandler;
    }

    public MotionHandler getMotionHandler(){
        return motionHandler;
    }
}
