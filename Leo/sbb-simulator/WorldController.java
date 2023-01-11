import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
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
    public List<City> cities = new ArrayList<City>();
    public int currentHighscore = 0;
    
    /**
     * Constructor for objects of class WorldController
     */
    public WorldController()
    {
        
        
        cities.add(new City("Chur",500,300));
        cities.add(new City("Bern",200,100));
        cities.add(new City("Luzern",200,200));
        cities.add(new City("Zürich",400,100));
        
        routes.add(new Route(cities.get(0), cities.get(1)));
        routes.add(new Route(cities.get(1), cities.get(2)));
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getTotalRouteDistance(){
    //int sum = routes.stream().reduce(0,(a,b) -> a+b.getRouteDistance());
    var wrapper = new Object(){int total = 0;};
    routes.forEach((Route route) -> {
    wrapper.total+=route.getRouteDistance();
    });
    return wrapper.total;
    }
    
    public void undoRoute(){
        System.out.println(routes.size());
        if(routes.size() > 0){
           routes.remove(routes.size() -1); 
        }
    }
    
    public void resetRoutes(){
        routes = new ArrayList<Route>();
        
    }
    
    private void setHighscore(){
        
    }
}
