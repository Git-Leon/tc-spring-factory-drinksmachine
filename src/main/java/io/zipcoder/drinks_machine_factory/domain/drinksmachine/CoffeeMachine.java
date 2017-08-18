package io.zipcoder.drinks_machine_factory.domain.drinksmachine;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;
import io.zipcoder.drinks_machine_factory.domain.beverages.coffee.Expresso;
import io.zipcoder.drinks_machine_factory.domain.beverages.coffee.Latte;

/**
 * Created by leon on 8/16/17.
 */
public class CoffeeMachine extends DrinksMachine<CoffeeMachine.CoffeeType> {
    public enum CoffeeType {
        LATTE, EXPRESSO;
    }

    @Override
    public Drink dispenseDrink(CoffeeType type) {
        Drink drink;
        switch(type) {
            case LATTE:
                drink = new Latte();
                break;

            case EXPRESSO:
                drink = new Expresso();
                break;

            default:
                String errorMessage = "Could not find a factory with the name '%s'.";
                throw new IllegalArgumentException(String.format(errorMessage, type.name()));
        }
        return drink;
    }

    public Drink dispenseDrink(String drinkName) {
        return dispenseDrink(CoffeeType.valueOf(drinkName));
    }
}
