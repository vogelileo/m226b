import java.util.*;
import greenfoot.*;
/**
 * Class for WorldController
 * 
 * @author Jan Schweizer
 * @version V1.0
 */
public class WorldController  
{
    public List<Route> routes = new ArrayList<Route>();
    public List<City> cities = new ArrayList<City>();
    public int currentHighscore = 0;
    private City firstCity  = null;
    
    /**
     * Constructor for objects of class WorldController
     */
    public WorldController(int highScore)
    {
        cities.add(new City("Chur",530,180));
        cities.add(new City("Bern",320,150));
        cities.add(new City("Genf",160,280));
        cities.add(new City("Zürich",420,100));
        cities.add(new City("Lugano",480,340));
        cities.add(new City("Zermatt",350,320));
        
        this.currentHighscore = highScore;
    }
    
    /**
     * Sets new highscore if it's higher than the current one
     * 
     * @param score
     */

    private void setHighscore(int score){
        if(currentHighscore > score){
            currentHighscore = score;
            FileReader fileReader = new FileReader();
            fileReader.writeHighscore(score);
        }
    }

    /**
     * Returns the total routedistance of all routes
     * 
     * @return routedistance
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
    
    /**
     * Remove last route
     */
    
    public void undoRoute(){
        if(routes.size() > 0){
           routes.remove(routes.size() -1); 
        }
    }
    
    /**
     * Remove all routes
     */

    public void resetRoutes(){
        routes = new ArrayList<Route>();
        
        
    }
    
    /**
     * Checks if a city is already selected twice
     * 
     * @param city
     * @return isValid If city is valid
     */

    private boolean validCity(City city){
        List<City> allUsedCities = new ArrayList<City>();
        routes.forEach((Route route) -> {
            allUsedCities.add(route.startCity);
            allUsedCities.add(route.endCity);
        });
        
        return Collections.frequency(allUsedCities, city) > 1;
    }
    
    /**
     * Checks if all cities are connected
     */

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
            Greenfoot.setWorld(new WinScreen(this));
            setHighscore(getTotalRouteDistance());
        };
    }
    
    /**
     * If a startcity for a route already has been
     * defined, generate a new route and reset the startcity.
     * 
     * @param city
     */

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
