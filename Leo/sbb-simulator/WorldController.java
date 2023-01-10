import java.util.List;
import java.util.ArrayList;
import greenfoot.*;
/**
 * Write a description of class WorldController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldController  
{
    // instance variables - replace the example below with your own
    public List<Route> routes = new ArrayList<Route>();
    public int currentHighscore = 0;
    
    /**
     * Constructor for objects of class WorldController
     */
    public WorldController()
    {
        routes.add( new Route());
        
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getTotalRouteDistance(){
        return 12;
    }
    
    public void undoRoute(){
        System.out.println("UNDO");
    }
    
    public void resetRoutes(){
        System.out.println("RESET");
    }
    
    private void setHighscore(){
        
    }
}
