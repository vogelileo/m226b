import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;

/**
 * Class Route
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Route extends Actor {
    public City startCity;
    public City endCity;

    public Route(City startCity, City endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }

    /**
     * Returns height diffrence between startcity and endcity
     * 
     * @return int
     */
    private int heightDistance() {
        return startCity.getY() - endCity.getY();
    }

    /**
     * Returns horizontal distance between startcity and endcity
     * 
     * @return int
     */
    private int widthDistance() {
        return startCity.getX() - endCity.getX();
    }

    /**
     * Returns length of the route itself. Calculated with pythagoras
     * 
     * @return int
     */
    public int getRouteDistance() {
        int heightDistance = Math.abs(heightDistance());
        int widthDistance = Math.abs(widthDistance());

        return (int) Math.sqrt(Math.pow(heightDistance, 2) + Math.pow(widthDistance, 2));

    }

    /**
     * Act - do whatever the Route wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        int sX = startCity.getX();
        int sY = startCity.getY();
        int eX = endCity.getX();
        int eY = endCity.getY();

        setLocation(sX - widthDistance() / 2, sY - heightDistance() / 2); // Set location to middle of route between
                                                                          // both cities

        GreenfootImage image = new GreenfootImage("rails.png");
        image.scale(getRouteDistance(), 10);
        setImage(image);

        double aval = (double) Math.abs(heightDistance()) / getRouteDistance(); // get the sin between catheter and
                                                                                // hypotenuse
        double rotation = Math.toDegrees(Math.asin(aval)); // get degrees value for rotation

        if (sX >= eX && sY >= eY) {
            rotation = 180 - rotation; // get reflexion, if line goes from bottom to top
        } else if (sX < eX && sY < eY) {
            rotation = 180 - rotation;
        }
        rotation = -1 * rotation; // set rotation to -1 cause of greenfoots rotation system

        setRotation((int) rotation);
    }

}
