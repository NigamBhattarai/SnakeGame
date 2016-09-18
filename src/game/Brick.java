package game;

import component.GameObject;
import component.Screen;
import core.Type;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nigam
 */
public class Brick extends GameObject{
    Screen screen;
    Bunny bunny;
    /**
     * 
     * @param location Sets the location of the brick
     * @param width Sets the width of the brick
     * @param height Sets the height of the brick
     * @param type Gives the type of the Brick
     */
    public Brick(Point location, int width, int height, Type type,Bunny bunny) {
        super(location, width, height, type);
        this.bunny=bunny;
    }
    @Override
    public void move() {
        if(bunny.didCollide(this))
        {
            bunny.life--;
            bunny.setLocation(new Point(0,100));
            
        }
    }
    @Override
    public void design(Graphics g) {
    }
}