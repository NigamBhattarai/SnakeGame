/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gadgets;

import component.GameObject;
import core.Type;
import game.Bunny;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author nigam
 */
public class Life extends GameObject{
    Bunny bunny;
    public Life(Point location, int width, int height, Type type) {
        super(location, width, height, type);
    }
    
    @Override
    public void move() {
        
    }

    @Override
    public void design(Graphics g) {
        g.setFont(new Font("",3,12));
        g.drawString("Lifes : "+bunny.life, location.x, location.y);
    }
}