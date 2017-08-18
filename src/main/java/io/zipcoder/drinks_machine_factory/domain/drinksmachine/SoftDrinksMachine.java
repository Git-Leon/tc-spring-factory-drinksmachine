package io.zipcoder.drinks_machine_factory.domain.drinksmachine;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;
import io.zipcoder.drinks_machine_factory.domain.beverages.softdrink.Coke;
import io.zipcoder.drinks_machine_factory.domain.beverages.softdrink.Sprite;

/**
 * Created by leon on 8/16/17.
 */
public class SoftDrinksMachine extends DrinksMachine<SoftDrinksMachine.SoftDrinkType> {
    public enum SoftDrinkType {
        SPRITE, COKE;
    }

    @Override
    public Drink dispenseDrink(SoftDrinkType type) {
        Drink drink;
        switch (type) {
            case SPRITE:
                drink = new Sprite();
                break;

            case COKE:
                drink = new Coke();
                break;

            default:
                String errorMessage = "Could not find a drink with the name '%s'.";
                throw new IllegalArgumentException(String.format(errorMessage, type.name()));
        }
        return drink;
    }
}
