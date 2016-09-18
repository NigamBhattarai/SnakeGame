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
    BufferedImage img=null;
    Game game;
    int randomNumx,randomNumy,c=0;
    Brick[] bricks;
    public Fruit(Point location,int width, int height, Type type,Bunny bunny,Game game,Brick[] bricks) {
        super(location, width, height, type);
        this.bunny=bunny;
        this.game=game;
        this.bricks=bricks;
    }

    @Override
    public void move() {
        if(this.didCollide(bunny))
        {
            for(int x=1;x>0;x--)
            {
              java.awt.Toolkit.getDefaultToolkit().beep();
            }
            level.score++;
            randomNumx = 5 + (int)(Math.random() * 550);
            randomNumy = 5 + (int)(Math.random() * 340);
            this.setLocation(new Point(randomNumx,randomNumy));
            for(c=0; c<game.getBrick().length; c++)
            {
                checkCollide();
            }
        }
    }
    public void checkCollide()
    {
            if(game.getBrick()[c].getArea().intersects(this.getArea()))//If any of the fruit is over any of the brick, the following codes will execute.
            {
                randomNumx = 5 + (int)(Math.random() * 550); 
                randomNumy = 5 + (int)(Math.random() * 340); 
                this.setLocation(new Point(randomNumx,randomNumy));
                System.out.println("rndomx2="+randomNumx);
                System.out.println("rndomy2="+randomNumy);
                for(c=0; c<game.getBrick().length; c++)//Again checks if any of the fruit is over any of the brick.If yes, this function itself is called
                {
                    if(game.getBrick()[c].getArea().intersects(this.getArea())){c=0;checkCollide();}
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