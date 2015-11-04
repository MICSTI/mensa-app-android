package itm.fhj.at.mensaapp.model;

import java.util.ArrayList;

/**
 * Created by michael.stifter on 04.11.2015.
 */
public class MealSchedule {
    private Location location;
    private long timestamp;
    private ArrayList<Meal> meals;

    public MealSchedule() {
        this.meals = new ArrayList<Meal>();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    /**
     * Adds a new meal to the meals array.
     * @param meal the meal to be added to the meals array
     */
    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }
}
