package game;

import core.Type;
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
    Bush[] bushes;
    int locationx[]=new int[al];
    int locationy[]=new int[al];
    public static int score=0;
    int bushheight[]=new int[al];
    int bushwidth[]=new int[al];
    public Level(Bunny bunny)
    {
        this.bunny=bunny;
    }
    public Bush[] getbushes(int i)
    {
        switch (i) {
            case 1:
                bushes=new Bush[5];
                locationx= new int[]{100,150,190,270,400};
                locationy=new int[]{100,40,104,250,170};
                bushheight=new int[]{100,30,150,30,30};
                bushwidth=new int[]{30,100,20,200,140};
                break;
            case 2:
                bushes=new Bush[7];
                locationx= new int[]{10,100,200,100,350,500,450};
                locationy=new int[]{150,100,10,250,200,50,330};
                bushheight=new int[]{100,30,150,30,130,130,50};
                bushwidth=new int[]{30,100,20,200,35,30,35};
                break;
            case 3:
                bushes=new Bush[9];
                locationx= new int[]{75,130,300,170,220,440,460,35,440};
                locationy=new int[]{5,150,50,250,200,50,330,332,160};
                bushheight=new int[]{90,30,150,30,130,130,50,50,34};
                bushwidth=new int[]{30,100,20,200,35,30,35,140,100};
                break;
            case 4:
                bushes=new Bush[11];
                locationx = new int[]{120,100,167,50,160,195,290,400,350,300,530};
                locationy = new int[]{240,80, 110,30,300,330,200,100,170,30,200};
                bushheight=new int[]{30, 30, 70, 30,30, 50, 100, 140,30, 35,150};
                bushwidth =new int[]{170,100,33, 70,90, 30, 30, 30, 120,150,30};
                break;
            default:
                break;
        }
        for(int j=0; j<bushes.length; j++)
        {
            bushes[j]=new Bush(new Point(locationx[j],locationy[j]),bushwidth[j],bushheight[j],Type.other,bunny);
        }
        return bushes;
    }
}