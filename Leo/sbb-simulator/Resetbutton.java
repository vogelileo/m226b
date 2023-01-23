import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Resetbutton
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Resetbutton extends Button {
    public Resetbutton() {
        name = "RESET";
    }

    /**
     * Act - do whatever the Resetbutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        GreenfootImage text = new GreenfootImage("      " + name + "      ", 24, Color.WHITE, new Color(0, 0, 0, 0));

        setImage(text);

        if (Greenfoot.mouseClicked(this)) {
            MasterWorld world = (MasterWorld) getWorld();
            WorldController controller = world.worldController;
            controller.resetRoutes();
        }
    }
}
