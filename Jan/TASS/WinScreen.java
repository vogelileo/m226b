import lang.stride.*;
import greenfoot.*;     // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for WinScreen
 * @author Jan Schweizer
 * @version V1.0
 */
public class WinScreen extends MasterWorld
{

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
