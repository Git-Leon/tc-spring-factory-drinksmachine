package io.zipcoder.drinks_machine_factory.utils;


import io.zipcoder.drinks_machine_factory.domain.drinksmachine.DrinksMachine;
import io.zipcoder.drinks_machine_factory.domain.drinksmachine.DrinksMachineFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;

/**
 * Created by leon on 8/16/17.
 */
@Service
public final class DrinksMachineFactoryLookUp {
    @Inject
    private DrinksMachineFactory dmf;

    private HashMap<String, DrinksMachine> map = new HashMap<>();

    public DrinksMachineFactoryLookUp() {
        addToMap(dmf.createCoffeeMachine(), dmf.createSoftDrinksMachine());
    }

    public DrinksMachine get(String simpleClassName) {
        DrinksMachine drinksMachine = map.get(simpleClassName);
        if(drinksMachine  == null) {
            String errorMessage = "Could not find a drink machine with the name '%s'.";
            throw new IllegalArgumentException(String.format(errorMessage, simpleClassName));
        }
        return drinksMachine;
    }

    private void addToMap(DrinksMachine... drinksMachines) {
        for(DrinksMachine drinksMachine : drinksMachines) {
            map.put(drinksMachine.getClass().getSimpleName(), drinksMachine);
        }
    }
}
