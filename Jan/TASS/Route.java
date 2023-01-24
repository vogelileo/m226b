import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;

/**
 * Class for Route
 * 
 * @author Jan Schweizer
 * @version V1.0
 */
public class Route extends Actor {
    public City startCity;
    public City endCity;

    public Route(City startCity, City endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }

    /**
     * Returns height diffrence between the two cities
     * 
     * @return heightDistance
     */
    private int heightDistance() {
        return startCity.getY() - endCity.getY();
    }

    /**
     * Returns horizontal distance between the two cities
     * 
     * @return widthDistance
     */
    private int widthDistance() {
        return startCity.getX() - endCity.getX();
    }

    /**
     * Returns length of the route
     * 
     * @return routLength
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
        int startCityX = startCity.getX();
        int startCityY = startCity.getY();
        int endCityX = endCity.getX();
        int endCityY = endCity.getY();

        int imageX = startCityX - widthDistance() / 2;
        int imageY = startCityY - heightDistance() / 2;

        setLocation(imageX, imageY);

        GreenfootImage image = new GreenfootImage("rails.png");
        image.scale(getRouteDistance(), 10);
        setImage(image);

        double aval = (double) Math.abs(heightDistance()) / getRouteDistance();
        double rotation = Math.toDegrees(Math.asin(aval));

        if (startCityX >= endCityX && startCityY >= endCityY) {
            rotation = 180 - rotation;
        } else if (startCityX < endCityX && startCityY < endCityY) {
            rotation = 180 - rotation;
        }
        rotation *= -1;

        setRotation((int) rotation);
    }

}
