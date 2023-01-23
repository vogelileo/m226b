import java.util.*;
import greenfoot.*;

/**
 * Class WorldController
 * 
 * @author Leo Vogel
 * @version 24012023
 */
public class WorldController {
    public List<Route> routes = new ArrayList<Route>();
    public List<City> cities = new ArrayList<City>();
    public int currentHighscore = 0;
    private City firstCity = null;

    /**
     * Constructor for objects of class WorldController
     */
    public WorldController(int highScore) {
        cities.add(new City("Chur", 530, 180));
        cities.add(new City("Bern", 320, 150));
        cities.add(new City("Genf", 160, 280));
        cities.add(new City("Zürich", 420, 100));
        cities.add(new City("Lugano", 480, 340));
        cities.add(new City("Zermatt", 350, 320));

        this.currentHighscore = highScore;
    }

    /**
     * set new highscore if it's higher than current one
     * 
     * @param score
     */
    private void setHighscore(int score) {
        if (currentHighscore > score) {
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
    public int getTotalRouteDistance() {
        var wrapper = new Object() {
            int total = 0;
        };
        routes.forEach((Route route) -> {
            wrapper.total += route.getRouteDistance();
        });
        return wrapper.total;
    }

    /**
     * Remove last places route
     */
    public void undoRoute() {
        if (routes.size() > 0) {
            routes.remove(routes.size() - 1);
        }
    }

    /**
     * Remove all routes
     */
    public void resetRoutes() {
        routes = new ArrayList<Route>();

    }

    /**
     * A city can't be selected, when its already selected twice. This functions
     * checks if a city was already selcted twice before
     * 
     * @param city
     * @return boolean if city is valid
     */
    private boolean validCity(City city) {
        List<City> allUsedCities = new ArrayList<City>();
        routes.forEach((Route route) -> {
            allUsedCities.add(route.startCity);
            allUsedCities.add(route.endCity);
        });

        return Collections.frequency(allUsedCities, city) > 1;
    }

    /**
     * Check if the route is completed. Aka if all cities where used
     */
    private void checkAllCities() {
        List<City> allUsedCities = new ArrayList<City>();
        routes.forEach((Route route) -> {
            allUsedCities.add(route.startCity);
            allUsedCities.add(route.endCity);
        });

        Set<City> set = new HashSet<>(allUsedCities);
        allUsedCities.clear();
        allUsedCities.addAll(set);

        if (allUsedCities.containsAll(cities)) {
            Greenfoot.setWorld(new WinScreen(this));
            setHighscore(getTotalRouteDistance());
        }
        ;
    }

    /**
     * Describe selection of a city. If already a startcity for an route has be
     * defined, generate a new route and reset the startcity
     * 
     * @param city
     */
    public void selectCity(City city) {
        if (validCity(city)) {
            return;
        }
        if (firstCity == city) {
            city.setSelected(false);
            firstCity = null;
            return;
        }
        if (firstCity != null) {
            routes.add(new Route(firstCity, city));
            firstCity.setSelected(false);
            firstCity = null;
            city.setSelected(false);
        }
        if (firstCity == null) {
            firstCity = city;
            firstCity.setSelected(true);
        }

        checkAllCities();
    }

}
