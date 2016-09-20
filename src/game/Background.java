package game;

import component.GameObject;
import game.Bush;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

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