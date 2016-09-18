package component;

import core.Type;
import game.Brick;
import game.Bunny;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author anmol
 */
public class Screen extends JPanel implements Runnable{
    Thread game;
    Bunny bunny;
    Brick brick;
ArrayList<GameObject> gameObjects=new ArrayList<GameObject>();

    public Screen(int width,int height,Color backgroundColor)
    {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(backgroundColor);
        
    }
    public void add(GameObject gameObject)
    {
        gameObjects.add(gameObject);
    }
    private void setBackGroundColor(Color color)
    {
        
        this.setBackground(color);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        render(g);
    }
    private void render(Graphics g)
    {
        /*gameObjects.stream().forEach((go) -> {
            go.castOnScreen(g);
        });*/
        for(int i=0;i<gameObjects.size();i++)
        {
            gameObjects.get(i).castOnScreen(g);
        }
       
    }
    private void move()
    {
        for(int i=0;i<gameObjects.size();i++)
        {
            gameObjects.get(i).move();
        }
    }
    public void play()
    {   
        game = new Thread(this);
        game.start();
        
    }

    @Override
    public void run() {
        
        if(!gameObjects.isEmpty())
        {
            while(true)
            {
                if(bunny.life==0)break;
                try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Brick.class.getName()).log(Level.SEVERE, null, ex);
                    }
                this.move();
                this.repaint();
            }
        }
        else
        {
            System.out.println("Nothing on screen to cast");
        }
    }
}