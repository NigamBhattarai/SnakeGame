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
    Background background;
    Bunny bunny;
    Score scores;
    Fruit fruit;
    Life lifes;
    Body body;
    int i,c;
    public static int lvl=1;
    int randomNumx,randomNumy;
    Seperator seperator;
    Bush[] bushes;
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
        background = new Background(new Point(),"background.jpg");
        fruit = new Fruit(new Point(randomNumx,randomNumy),20, 20,Type.other,bunny,this,bushes);
        scores = new Score(new Point(2,420),70,30,Type.other);
        scores.setColor(Color.white);
        lifes = new Life(new Point(500,420),70,30,Type.other);
        lifes.setColor(Color.white);
        seperator = new Seperator(new Point(0,400),600,0,Type.line);
        seperator.setColor(Color.white);
        level = new Level(bunny);
        screen.add(background);
        addBush();
        stage.addKeyListener(this);
        fruit.setColor(Color.BLUE);
        screen.add(fruit);
        screen.add(seperator);
        screen.add(lifes);
        screen.add(scores);
        screen.add(body);
        screen.add(bunny);
        screen.play();
    }
    /**
     * This Function Checks either fruit is on the bush or not, If yes, new location is given to the fruit!
     */
    public void addBush()
    {
        bushes = level.getbushes(lvl);
        for(i=0; i<bushes.length; i++)screen.add(bushes[i]);
        for(c=0; c<bushes.length; c++)checkCollide();
    }
    public void checkCollide()
    {
            if(bushes[c].getArea().intersects(fruit.getArea()))//If any of the fruit is over any of the bush, the following codes will execute.
            {
                randomNumx = 5 + (int)(Math.random() * 550); 
                randomNumy = 5 + (int)(Math.random() * 340); 
                fruit.setLocation(new Point(randomNumx,randomNumy));
                System.out.println("rndomx2="+randomNumx);
                System.out.println("rndomy2="+randomNumy);
                for(c=0; c<bushes.length; c++)//Again checks if any of the fruit is over any of the bush.If yes, this function itself is called
                {
                    if(bushes[c].getArea().intersects(fruit.getArea())){checkCollide();}
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
    public Bush[] getBrick()
    {
        return bushes;
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
