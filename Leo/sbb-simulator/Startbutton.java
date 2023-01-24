import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Startbutton
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Startbutton extends Button {
    public Startbutton() {
        name = "START";

    }

    /**
     * Act - do whatever the Startbutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        GreenfootImage text = new GreenfootImage("      " + name + "      ", 32, Color.RED, Color.WHITE);
        setImage(text);

        if (Greenfoot.mouseClicked(this)) {
            MasterWorld world = (MasterWorld) getWorld();
            Map map = new Map(world.worldController);
            Greenfoot.setWorld(map);

        }
    }
}
