package Gadgets;

import component.GameObject;
import core.Type;
import game.Game;
import game.Level;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author nigam
 */
public class Score extends GameObject{
    Level level;
    public Score(Point location, int width, int height, Type type) {
        super(location, width, height, type);
    }
    
    @Override
    public void move() {
        
    }

    @Override
    public void design(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("",3,12));
        g.drawString("Score : "+level.score, location.x, location.y);
    }
    
}
