package game;

import component.GameObject;
import core.Type;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author nigam
 */
public class Fruit extends GameObject{
    Bunny bunny;
    Level level;
    Game game;
    public Fruit(Point location, int width, int height, Type type,Bunny bunny) {
        super(location, width, height, type);
        this.bunny=bunny;
    }

    @Override
    public void move() {
        if(this.didCollide(bunny))
        {
            level.score++;
                int randomNumx = 5 + (int)(Math.random() * 550); 
                int randomNumy = 5 + (int)(Math.random() * 340); 
                this.setLocation(new Point(randomNumx,randomNumy));
        }
    }

    @Override
    public void design(Graphics g) {
    }    
}