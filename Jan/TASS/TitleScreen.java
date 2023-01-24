import lang.stride.*;
import greenfoot.*;     // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for TitleScreen
 * @author Jan Schweizer
 * @version V1.0
 */
public class TitleScreen extends MasterWorld
{
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
