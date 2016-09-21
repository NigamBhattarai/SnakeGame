/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gadgets;

import component.GameObject;
import core.Type;
import game.Game;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author nigam
 */
public class ShowLevel extends GameObject{
    Game game;
    public ShowLevel(Point location, int width, int height, Type type) {
        super(location, width, height, type);
    }
    
    @Override
    public void move() {
        
    }

    @Override
    public void design(Graphics g) {
        g.setFont(new Font("",3,12));
        g.drawString("Level : "+game.lvl, location.x, location.y);
    }
}