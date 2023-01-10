import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class WinScreen here.
 * @author (your name) @version (a version number or a date)
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
        
        GreenfootImage text = new GreenfootImage("START", 24, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(text, 300,400);
        
        
    }
    
    public void act(){
        
    }
}
