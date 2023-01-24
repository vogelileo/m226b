import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Undobutton
 * 
 * @author Jan Schweizer 
 * @version V1.0
 */
public class Undobutton extends Button
{
    public int sleepTime = 0;
    
    public Undobutton(){
        name = "UNDO";
    
    }
    
    /**
     * Act - do whatever the Resetbutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act(){
        GreenfootImage text = new GreenfootImage("      "+ name +"      ", 24, Color.WHITE ,new Color(0,0,0,0));
        setImage(text);
        if(sleepTime > 0){
            sleepTime--;
            return;
        }
        if(Greenfoot.mouseClicked(this)){
            MasterWorld world = (MasterWorld)getWorld();
            WorldController controller = world.worldController;
            controller.undoRoute();
            sleepTime = 25;
        }
    }
}
