package game;

import component.GameObject;
import component.Screen;
import core.Type;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
/**
 *
 * @author nigam
 */
public class Bush extends GameObject{
    Screen screen;
    Level level;
    Bunny bunny;
    /**
     * 
     * @param location Sets the location of the bush
     * @param width Sets the width of the bush
     * @param height Sets the height of the bush
     * @param type Gives the type of the Bush
     */
    public Bush(Point location, int width, int height, Type type,Bunny bunny) {
        super(location, width, height, type);
        this.bunny=bunny;
    }
    @Override
    public void move() {
        if(bunny.didCollide(this))
        {
        for(int x=0;x<10;x++)
        {
          java.awt.Toolkit.getDefaultToolkit().beep();
        }
            bunny.life--;
            bunny.setLocation(new Point(0,100));
        }
    }
    public void clearbush()
    {
        this.setLocation(new Point(-300,-300));
    }
    @Override
    public void castOnScreen(Graphics g)
    {
        try {
             File file = new File("bush.jpg");
             img = ImageIO.read(file);
             System.out.println(file.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Image not found!!!!");
        }
            if(img!=null)
            g.drawImage(img, location.x, location.y, width, height, null);
    }
    @Override
    public void design(Graphics g) {
    }
}