package game;

import core.Type;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author nigam
 */
public class Level
{
    int al;
    Game game;
    Bunny bunny;
    Brick[] bricks;
    public static int lvl;
    int locationx[]=new int[al];
    int locationy[]=new int[al];
    public static int score=0;
    int brickheight[]=new int[al];
    int brickwidth[]=new int[al];
    public Level(Bunny bunny)
    {
        this.bunny=bunny;
        switch (lvl) {
            case 1:
                bricks=new Brick[5];
                locationx= new int[]{50,150,190,270,400};
                locationy=new int[]{100,40,104,250,170};
                brickheight=new int[]{100,30,150,30,30};
                brickwidth=new int[]{30,100,20,200,140};
                break;
            case 2:
                bricks=new Brick[7];
                locationx= new int[]{10,100,200,100,350,500,450};
                locationy=new int[]{50,100,10,250,200,50,330};
                brickheight=new int[]{100,30,150,30,130,130,50};
                brickwidth=new int[]{30,100,20,200,35,30,35};
                break;
            case 3:
                bricks=new Brick[9];
                locationx= new int[]{25,130,300,170,220,440,460,35,440};
                locationy=new int[]{10,150,50,250,200,50,330,332,160};
                brickheight=new int[]{100,30,150,30,130,130,50,50,34};
                brickwidth=new int[]{30,100,20,200,35,30,35,140,100};
                break;
            case 4:
                bricks=new Brick[11];
                locationx= new int[]{ 120,  100,167,50,160,195,290,400,350,300,530};
                locationy=new int[]{  240,  80, 110,30,300,330,200,100,170,30,200};
                brickheight=new int[]{30,   30, 70,30,30, 50, 100, 140,30, 35,150};
                brickwidth=new int[]{170,   100,33, 70,90, 30, 30, 30, 120,150,30};
                break;
            default:
                break;
        }
        for(int i=0; i<bricks.length; i++)
        {
            bricks[i]=new Brick(new Point(locationx[i],locationy[i]),brickwidth[i],brickheight[i],Type.rectangle,bunny);
        }
    }
    public Brick[] getbricks(int i)
    {
        return bricks;
    }
}