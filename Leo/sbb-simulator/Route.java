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
    
    public void Route(City startCity, City endCity){
        startCity = startCity;
        endCity = endCity;
    }
    
    /**
     * Act - do whatever the Route wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
    }
    
    public int getRouteDistance(){
        return 0;
    }
}
