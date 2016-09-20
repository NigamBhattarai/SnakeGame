package game;

import component.GameObject;
import core.Type;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author nigam
 */
public class Fruit extends GameObject{
    Bunny bunny;
    Level level;
    int scr;
    static int count=1;
    Game game;
    int randomNumx,randomNumy,c=0;
    Bush[] bushes;
    public Fruit(Point location,int width, int height, Type type,Bunny bunny,Game game,Bush[] bushes) {
        super(location, width, height, type);
        this.bunny=bunny;
        this.game=game;
        this.bushes=bushes;
    }
    @Override
    public void move() {
        if(level.score==count*2)
        {
            scr=level.score;
            count++;
        }
        if(this.didCollide(bunny))
        {
            ifCollide();
        }
        if(game.lvl!=5)
        {
            if(level.score==scr)
            {
                game.lvl++;
                for(int i=0; i<game.bushes.length; i++)
                {
                    game.bushes[i].clearbush();
                }
                game.bunny.setLocation(new Point(0,100));
                game.addBush();
            }
        }
    }
    private void ifCollide()
    {
            java.awt.Toolkit.getDefaultToolkit().beep();
            level.score++;
            randomNumx = 5 + (int)(Math.random() * 550);
            randomNumy = 5 + (int)(Math.random() * 340);
            this.setLocation(new Point(randomNumx,randomNumy));
            for(c=0; c<game.getBrick().length; c++)
            {
                checkCollide();
            }
    }
    public void checkCollide()
    {
            if(game.getBrick()[c].didCollide(this))//If any of the fruit is over any of the brick, the following codes will execute.
            {
                randomNumx = 5 + (int)(Math.random() * 550); 
                randomNumy = 5 + (int)(Math.random() * 340); 
                this.setLocation(new Point(randomNumx,randomNumy));
                System.out.println("rndomx2="+randomNumx);
                System.out.println("rndomy2="+randomNumy);
                for(int d=0; d<game.getBrick().length; d++)//Again checks if any of the fruit is over any of the brick.If yes, this function itself is called
                {
                    if(game.getBrick()[d].didCollide(this)){checkCollide();}
                }
            }
    }
    @Override
    public void castOnScreen(Graphics g)
    {
        try {
             File file = new File("apple1.png");
             img = ImageIO.read(file);
             System.out.println(file.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Image not found!!!!");
        }
            if(img!=null)
            g.drawImage(img, location.x, location.y, null);
    }
    @Override
    public void design(Graphics g) {
    }    
}