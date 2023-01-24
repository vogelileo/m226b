import lang.stride.*;
import greenfoot.*;

/**
 * Class Map
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Map extends MasterWorld {
    /**
     * Constructor for objects of class Map.
     * 
     * @param worldController to persist the worldcontroller
     */

    public Map(WorldController worldController) {
        this.worldController = worldController;
        addObject(new Resetbutton(), 50, 420);
        addObject(new Undobutton(), 130, 420);

        this.worldController.cities.forEach((City city) -> {
            addObject(city, city.xPos, city.yPos);
        });
    }

    /**
     * Act - do whatever the Map wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        GreenfootImage defaultBackground = new GreenfootImage("MapScreen.png"); // Set background
        setBackground(defaultBackground);

        String textString = "Score: " + Integer.toString(worldController.getTotalRouteDistance()) + "km"; // generate
                                                                                                          // score
        GreenfootImage text = new GreenfootImage(textString, 24, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(text, 660, 405); // draw score onto background

        removeObjects(getObjects(Route.class)); // remove all objects of class, so they can be rerendered and new routes
                                                // can be added
        this.worldController.routes.forEach((Route route) -> {
            addObject(route, 0, 0);
        });

    }
}
