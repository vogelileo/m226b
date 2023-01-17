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
        FileReader fileReader = new FileReader();
        int score = fileReader.readHighscore();
        this.worldController = new WorldController(score);
        
        addObject(new Startbutton(),400,410);
        
        Greenfoot.start();
    }
}
