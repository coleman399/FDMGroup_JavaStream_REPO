import java.util.ArrayList;

public class CalorieCounter {
    private ArrayList<FoodItem> lowCalorieFoods = new ArrayList<FoodItem>();
    
    public void addLowCalorieFood(FoodItem foodItem) {
        if (foodItem.getCalories() <= 500) {
            lowCalorieFoods.add(foodItem);
        }
    }

    public ArrayList<FoodItem> getAllLowCalorieFoods() {
        return lowCalorieFoods;
    }
}
