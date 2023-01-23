import lang.stride.*;
import greenfoot.*;

/**
 * Class WinScreen
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class WinScreen extends MasterWorld
{

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Constructor for objects of class WinScreen.
     */
    public WinScreen(WorldController worldController)
    {
        this.worldController = worldController;
        GreenfootImage curScore = new GreenfootImage("YOUR SCORE: " + worldController.getTotalRouteDistance(), 24, Color.RED, new Color(0, 0, 0, 0));
        getBackground().drawImage(curScore, 320,215);
        
        GreenfootImage curHighScore = new GreenfootImage("HIGHSCORE: " + worldController.currentHighscore, 24, Color.RED, new Color(0, 0, 0, 0));
        getBackground().drawImage(curHighScore, 320,400);
        
        
    }
    
    public void act(){
        
    }
}
