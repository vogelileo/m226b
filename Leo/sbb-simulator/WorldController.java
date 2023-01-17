import java.util.*;
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
    private City firstCity  = null;
    
    /**
     * Constructor for objects of class WorldController
     */
    public WorldController(int highScore)
    {
        cities.add(new City("Chur",500,300));
        cities.add(new City("Bern",200,100));
        cities.add(new City("Luzern",200,200));
        cities.add(new City("Zürich",400,100));
        
        this.currentHighscore = highScore;
    }
    
    private void setHighscore(int score){
        if(currentHighscore > score){
            currentHighscore = score;
            FileReader fileReader = new FileReader();
            fileReader.writeHighscore(score);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getTotalRouteDistance(){
        var wrapper = new Object(){
            int total = 0;
        };
        routes.forEach((Route route) -> {
        wrapper.total+=route.getRouteDistance();
        });
        return wrapper.total;
    }
    
    public void undoRoute(){
        if(routes.size() > 0){
           routes.remove(routes.size() -1); 
        }
    }
    
    public void resetRoutes(){
        routes = new ArrayList<Route>();
        
    }
    
    private boolean validCity(City city){
        List<City> allUsedCities = new ArrayList<City>();
        routes.forEach((Route route) -> {
            allUsedCities.add(route.startCity);
            allUsedCities.add(route.endCity);
        });
        
        return Collections.frequency(allUsedCities, city) > 1;
    }
    
    private void checkAllCities(){
        List<City> allUsedCities = new ArrayList<City>();
        routes.forEach((Route route) -> {
            allUsedCities.add(route.startCity);
            allUsedCities.add(route.endCity);
        });
        
        Set<City> set = new HashSet<>(allUsedCities);
        allUsedCities.clear();
        allUsedCities.addAll(set);
        
        
        if(allUsedCities.containsAll(cities)){
            //Greenfoot.delay(60);
            Greenfoot.setWorld(new WinScreen(this));
            setHighscore(getTotalRouteDistance());
        };
    }
    
    public void selectCity(City city){
        if(validCity(city)){
            return;
        }
        if (firstCity == city){
            city.setSelected(false);
            firstCity = null;
            return;
        }
        if(firstCity != null){
            routes.add(new Route(firstCity, city));
            firstCity.setSelected(false);
            firstCity = null;
            city.setSelected(false);
        }
        if(firstCity == null){
            firstCity = city;
            firstCity.setSelected(true);
        }
        
        checkAllCities();
    }
    
    
}
