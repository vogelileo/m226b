import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;
/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        setLocation(startCity.getX() - widthDistance() /2, startCity.getY() - heightDistance() / 2);
            
        GreenfootImage image = new GreenfootImage("board.jpg");
        image.scale(getRouteDistance(),10);
        
        setImage(image);
        
        double aval = (double)Math.abs(heightDistance()) / getRouteDistance();
        double rotation = 0.0;
        
        if(startCity.getX() >= endCity.getX()){
            rotation= Math.toDegrees(Math.asin(aval));
        }else{
            rotation= Math.toDegrees(Math.acos(aval));
            rotation += 90;
        }
        
        
        setRotation((int)rotation);
        
    }
    
    public int getRouteDistance(){
        int heightDistance = Math.abs(heightDistance());
        int widthDistance = Math.abs(widthDistance());

        return (int)Math.sqrt(Math.pow(heightDistance,2) + Math.pow(widthDistance,2));
        
    }
}
