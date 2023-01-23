import lang.stride.*;
import greenfoot.*;

/**
 * Class TitleScreen
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class TitleScreen extends MasterWorld {
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen() {
        FileReader fileReader = new FileReader();
        int score = fileReader.readHighscore();
        this.worldController = new WorldController(score);

        addObject(new Startbutton(), 400, 410);

        Greenfoot.start();
    }
}
