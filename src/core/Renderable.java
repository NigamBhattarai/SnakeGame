/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Graphics;

/**
 *
 * @author vikram
 */
public interface Renderable {
    public void move();
    public void castOnScreen(Graphics g);
}
