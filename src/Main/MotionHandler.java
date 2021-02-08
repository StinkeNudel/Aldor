package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MotionHandler implements MouseMotionListener{

    private static int mouseX, mouseY;

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
    }


    public static int getMouseX(){
        return mouseX;
    }

    public static int getMouseY(){
        return mouseY;
    }
}
