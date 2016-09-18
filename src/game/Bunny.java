/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import component.GameObject;
import core.Direction;
import core.Type;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
/**
 *
 * @author anmol
 */
public class Bunny extends GameObject{
    Direction direction;
    Brick brick;
    public static int life=5;
/**
 * 
 * @param location defines the starting location of snake
 * @param width defines the width of snake of type rectangle
 * @param height defines the height of snake of type rectangle  
 * @param type what type it belong to eg:rectangle,circle,other,etc
 */
    public Bunny(Point location, int width, int height, Type type) {
        super(location, width, height, type);
        direction = Direction.right;       
    }
    @Override
    public void move() {
                if(this.location.x<0)
                {
                    this.setLocation(new Point(600,location.y));
                }
                if(this.location.x>600)
                {
                    this.setLocation(new Point(0,location.y));
                }
                if(this.location.y<0)
                {
                    this.setLocation(new Point(location.x,387));
                }
                if(this.location.y>387)
                {
                    this.setLocation(new Point(location.x,0));
                }  
        switch(direction)
        {
            case right:
                location.x++;
                break;
            case left:
                location.x--;
                break;
            case up:
                location.y--;
                break;
            case down:
                location.y++;
                break;
        }
    }
    @Override
    public void design(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(location.x, location.y, width, height);
    }
    public void left()
    {
        if(direction!=Direction.right)
        direction = Direction.left;
    }
    public void right()
    {
        if(direction!=Direction.left)
        direction = Direction.right;
    }
    public void up()
    {
        if(direction!=Direction.down)
        direction = Direction.up;
    }
    public void down()
    {
        if(direction!=Direction.up)
        direction = Direction.down;
    }
}