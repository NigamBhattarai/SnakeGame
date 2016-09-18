package game;

import Gadgets.Life;
import Gadgets.Score;
import Gadgets.Seperator;
import component.Screen;
import component.Stage;
import core.Type;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *This class is the game whose object will be created in main class so that we can play a game
 * @author nigam
 */
public class Game implements KeyListener{
    Screen screen;
    Level level;
    Bunny bunny;
    Score scores;
    Fruit fruit;
    Life lifes;
    Body body;
    int i,c;
    int randomNumx,randomNumy;
    Seperator seperator;
    Brick[] bricks;
    /**
     * Default Constructor which loads the Game class
     */
    public Game()
    {
        screen=new Screen(600,470,Color.WHITE);
        Stage stage = new Stage(screen);
        bunny=new Bunny(new Point(0,100),12,12,Type.other);
        body=new Body(new Point(0-10,100),10,10,Type.other,bunny);
        randomNumx = 5 + (int)(Math.random() * 550); 
        randomNumy = 5 + (int)(Math.random() * 340); 
        System.out.println("rndomx1="+randomNumx);
        System.out.println("rndomy1="+randomNumy);
        fruit = new Fruit(new Point(randomNumx,randomNumy),15,15,Type.circle,bunny);
        level.lvl=4;
        scores = new Score(new Point(2,420),70,30,Type.other);
        scores.setColor(Color.BLACK);
        lifes = new Life(new Point(500,420),70,30,Type.other);
        lifes.setColor(Color.BLACK);
        seperator = new Seperator(new Point(0,400),600,0,Type.line);
        seperator.setColor(Color.black);
        level = new Level(bunny);
        bricks = level.getbricks(i);
        for(i=0; i<bricks.length; i++)
        {
            bricks[i].setColor(Color.black);
            screen.add(bricks[i]);
        }
        for(c=0; c<bricks.length; c++)
        {
            checkCollide();
        }
        stage.addKeyListener(this);
        fruit.setColor(Color.BLUE);
        screen.add(fruit);
        screen.add(seperator);
        screen.add(lifes);
        screen.add(scores);
        screen.add(body);
        screen.add(bunny);
        if(bunny.didCollide(fruit))
        {
            checkCollide();
        }
        screen.play();
    }
    /**
     * This Function Checks either fruit is on the brick or not, If yes, new location is given to the fruit!
     */
    public void checkCollide()
    {
            if(bricks[c].getArea().intersects(fruit.getArea()))//If any of the fruit is over any of the brick, the following codes will execute.
            {
                randomNumx = 5 + (int)(Math.random() * 550); 
                randomNumy = 5 + (int)(Math.random() * 340); 
                fruit = new Fruit(new Point(randomNumx,randomNumy),15,15,Type.circle,bunny);
                System.out.println("rndomx2="+randomNumx);
                System.out.println("rndomy2="+randomNumy);
                for(c=0; c<bricks.length; c++)//Again checks if any of the fruit is over any of the brick.If yes, this function itself is called
                {
                    if(bricks[c].getArea().intersects(fruit.getArea())){c=0;checkCollide();}
                }
            }
    }
     /**
     * 
     * @param state is the game status which denote beginning,loading...exit etc
     * @param name Title of the game
     * @return If it is playing it will return true else false
     */
    public boolean play(int state, String name)
    {
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    if(e.getKeyCode()==37)
    {
        bunny.left();
        body.left();
   }
    else if(e.getKeyCode()==39)
    {
        bunny.right();
        body.right();
     }
    
    if(e.getKeyCode()==38)
    {
        bunny.up();
        body.up();
     }
    else if(e.getKeyCode()==40)
    {
        bunny.down();
        body.down();
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
