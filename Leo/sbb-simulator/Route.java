import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    /**
     * Act - do whatever the Route wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        getWorld().getBackground().drawLine(startCity.getX(),startCity.getY(),endCity.getX(),endCity.getY());
    }
    
    public int getRouteDistance(){
        int heightDistance = Math.abs(startCity.getY() - endCity.getY());
        int widthDistance = Math.abs(startCity.getX() - endCity.getX());

        return (int)Math.sqrt(Math.pow(heightDistance,2) + Math.pow(widthDistance,2));
        
    }
}
