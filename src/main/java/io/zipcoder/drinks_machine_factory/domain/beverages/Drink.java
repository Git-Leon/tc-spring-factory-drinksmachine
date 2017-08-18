package io.zipcoder.drinks_machine_factory.domain.beverages;

/**
 * Created by leon on 8/16/17.
 */
public abstract class Drink {
    public Drink() {
        String drinkType = getClass().getSimpleName();
        System.out.println(drinkType);
    }
}
