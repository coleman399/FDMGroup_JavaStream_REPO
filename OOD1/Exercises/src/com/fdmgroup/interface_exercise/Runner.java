package com.fdmgroup.interface_exercise;

public class Runner {
    public static void main(String[] args) {
        
        Toy toy = new Toy(5, 24, "toy", 5.00);
        Laptop laptop = new Laptop(5.00, 15.00, 5.00, "laptop", 200.00);
        Snack snack1 = new Snack(50, 100, "snack1", 5.00, 600);
        Snack snack2 = new Snack(5, 0, "snack2", 6.50, 100);
        ReadyMeal readyMeal1 = new ReadyMeal("American", "Ready Meal 1", 10.00, 800);
        ReadyMeal readyMeal2 = new ReadyMeal("Italian", "Ready Meal 2", 8.75, 500);
        Basket basket = new Basket();

        CalorieCounter calorieCounter = new CalorieCounter();

        basket.addItem(toy);
        basket.addItem(laptop);
        basket.addItem(snack1);
        basket.addItem(snack2);
        basket.addItem(readyMeal1);
        basket.addItem(readyMeal2);

        for (BasketItem basketItem : basket.getAllItems()) {
            System.out.println(basketItem.getName());
        }

        basket.removeItem(toy);

        for (BasketItem basketItem : basket.getAllItems()) {
            System.out.println(basketItem.getName());
        }

        calorieCounter.addLowCalorieFood(snack1);
        calorieCounter.addLowCalorieFood(snack2);
        calorieCounter.addLowCalorieFood(readyMeal1);
        calorieCounter.addLowCalorieFood(readyMeal2);

        for (FoodItem foodItem : calorieCounter.getAllLowCalorieFoods()) {
            System.out.println(foodItem.getCalories());
        }
    }
}
