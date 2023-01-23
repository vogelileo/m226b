import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;
/**
 * Class Route
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class Route extends Actor
{
    public City startCity;
    public City endCity;
    
    public Route(City startCity, City endCity){
        this.startCity = startCity;
        this.endCity = endCity;
        
        
        
    }
    
    private int heightDistance(){
        return startCity.getY() - endCity.getY(); 
    }
    
    private int widthDistance(){
        return startCity.getX() - endCity.getX();
    }
    
    /**
     * Act - do whatever the Route wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int sX = startCity.getX();
        int sY = startCity.getY();
        int eX = endCity.getX();
        int eY = endCity.getY();
        
        setLocation(sX - widthDistance() /2, sY - heightDistance() / 2);
            
        GreenfootImage image = new GreenfootImage("rails.png");
        image.scale(getRouteDistance(),10);
        setImage(image);
        
        double aval = (double)Math.abs(heightDistance()) / getRouteDistance();
        double rotation = rotation= Math.toDegrees(Math.asin(aval));

        if(sX >= eX && sY >= eY){
             rotation = 180-rotation;
        }else if(sX < eX && sY < eY){
            rotation = 180-rotation;
        }
        rotation = -1 * rotation;
        
        setRotation((int)rotation);    
    }
    
    public int getRouteDistance(){
        int heightDistance = Math.abs(heightDistance());
        int widthDistance = Math.abs(widthDistance());

        return (int)Math.sqrt(Math.pow(heightDistance,2) + Math.pow(widthDistance,2));
        
    }
}
