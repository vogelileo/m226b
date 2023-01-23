import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Undobutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Undobutton extends Button
{
    public int sleepTime = 0;
    
    public Undobutton(){
        name = "UNDO";
    
    }
    
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
            //Greenfoot.setWorld(new Map(getWorld().));
        }
    }
}
