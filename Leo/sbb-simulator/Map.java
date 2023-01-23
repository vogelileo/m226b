import lang.stride.*;
import greenfoot.*;

/**
 * Class Map
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Map extends MasterWorld
{
    /**
     * Constructor for objects of class Map.
     *
     */
    /**
     * ad
     
     */
    public Map(WorldController worldController)
    {
        this.worldController = worldController;   
        addObject(new Resetbutton(),50,420);
        addObject(new Undobutton(),130,420);
        
        this.worldController.cities.forEach((City city) -> {
            addObject(city, city.xPos,city.yPos);
        });
    }
    
    public void act(){
        GreenfootImage defaultBackground = new GreenfootImage("MapScreen.png");
        setBackground(defaultBackground);
        String textString = "Score: " +Integer.toString(worldController.getTotalRouteDistance())+ "km";
        GreenfootImage text = new GreenfootImage(textString, 24, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(text, 660,405);
        
        removeObjects(getObjects(Route.class));
        this.worldController.routes.forEach((Route route) -> {
            addObject(route, 0,0);
        });
        
        
    }
}
