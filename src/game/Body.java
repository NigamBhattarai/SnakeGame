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
public class Body extends GameObject{
Direction direction;
Bunny bunny;
    public Body(Point location, int width, int height, Type type,Bunny bunny) {
        super(location, width, height, type);
        this.bunny=bunny;
        direction=Direction.right;
    }

    @Override
    public void move() {
        switch(direction)
        {
            case right:
                location.x=bunny.location.x-10;
                location.y=bunny.location.y;
                break;
            case left:
                location.x=bunny.location.x+10;
                location.y=bunny.location.y;
                break;
            case up:
                location.y=bunny.location.y+10;
                location.x=bunny.location.x;
                break;
            case down:
                location.y=bunny.location.y-10;
                location.x=bunny.location.x;
                break;
        }
    }

    @Override
    public void design(Graphics g) {
        g.setColor(Color.YELLOW);
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
