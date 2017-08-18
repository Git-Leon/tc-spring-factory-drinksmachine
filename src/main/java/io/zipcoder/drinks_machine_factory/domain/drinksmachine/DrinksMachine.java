package io.zipcoder.drinks_machine_factory.domain.drinksmachine;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;

/**
 * Created by leon on 8/16/17.
 */
public abstract class DrinksMachine<E extends Enum<E>> {
    abstract public Drink dispenseDrink(E type);
    public Drink dispenseDrink(String type) {
        return dispenseDrink(E.valueOf(null, type));
    }
    public String displayMessage() {
        return "Thank you for your custom";
    }
}
