import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class Map here.
 * @author (your name) @version (a version number or a date)
 */
public class Map extends MasterWorld
{

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Constructor for objects of class Map.
     */
    public Map(WorldController worldController)
    {
        this.worldController = worldController;   
        addObject(new Resetbutton(),50,420);
        addObject(new Undobutton(),130,420);
        addObject(new City("Zürich"),400,100);
        addObject(new City("Luzern"),250,200);
        addObject(new City("Bern"),200,150);
        addObject(new City("Chur"),500,300);
        removeObjects(getObjects(Route.class));
        this.worldController.routes.forEach((Route route) -> {
            addObject(route, 0,0);
        });
    }
    
    public void act(){
        String textString = "Score: " +Integer.toString(worldController.getTotalRouteDistance())+ "km";
        GreenfootImage text = new GreenfootImage(textString, 24, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(text, 660,405);
        
        
        
        
        
    }
}
