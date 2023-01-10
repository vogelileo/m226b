import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class TitleScreen here.
 * @author (your name) @version (a version number or a date)
 */
public class TitleScreen extends MasterWorld
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {
        
        this.worldController = new WorldController();
        
        worldController.currentHighscore = 1;
        
        addObject(new Startbutton(),400,410);
        
        Greenfoot.start();
    }
}
