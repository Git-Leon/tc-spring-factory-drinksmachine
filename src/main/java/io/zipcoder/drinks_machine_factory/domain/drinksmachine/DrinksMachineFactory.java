package io.zipcoder.drinks_machine_factory.domain.drinksmachine;

import org.springframework.stereotype.Service;

/**
 * Created by leon on 8/16/17.
 */
@Service
public class DrinksMachineFactory {
    public DrinksMachine createCoffeeMachine() {
        return new CoffeeMachine();
    }

    public DrinksMachine createSoftDrinksMachine() {
        return new SoftDrinksMachine();
    }
}
