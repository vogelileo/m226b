import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startbutton extends Button
{
    public Startbutton(){
        name = "START";
    
    }
    
    public void act(){
        GreenfootImage text = new GreenfootImage("      "+ name +"      ", 32, Color.RED ,Color.WHITE);
        setImage(text);
        
        if(Greenfoot.mouseClicked(this)){
            MasterWorld world = (MasterWorld)getWorld();
            Map map = new Map(world.worldController);
            Greenfoot.setWorld(map);
            //Greenfoot.setWorld(new Map(getWorld().));
        }
    }
}
