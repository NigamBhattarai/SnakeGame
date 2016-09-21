package game;

import component.GameObject;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author nigam
 */
public class Background extends GameObject{
    public Background(Point location, String imageSrc) {
        super(location, imageSrc);
    }

    @Override
    public void move()
    {
    }

    @Override
    public void design(Graphics g) {

    }
    
}