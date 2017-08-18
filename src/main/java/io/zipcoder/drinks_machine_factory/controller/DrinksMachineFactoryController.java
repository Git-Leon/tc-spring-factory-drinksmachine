package io.zipcoder.drinks_machine_factory.controller;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;
import io.zipcoder.drinks_machine_factory.domain.drinksmachine.DrinksMachine;
import io.zipcoder.drinks_machine_factory.domain.drinksmachine.DrinksMachineFactory;
import io.zipcoder.drinks_machine_factory.repository.DrinkRepository;
import io.zipcoder.drinks_machine_factory.utils.DrinksMachineFactoryLookUp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

/**
 * Created by leon on 8/18/17.
 */
public class DrinksMachineFactoryController {
    @Inject
    private DrinkRepository drinkRepository;

    @Inject
    private DrinksMachineFactoryLookUp dmflu;

    @PostMapping
    public ResponseEntity<?> createDrink(
            @RequestParam(value = "drinkMachineName") String drinkMachineName,
            @RequestParam(value= "drinkName") String drinkName) {
        DrinksMachine drinksMachine = dmflu.get(drinkMachineName);
        Drink drink = drinksMachine.dispenseDrink(drinkName);

        HttpHeaders headers = new HttpHeaders();
        URI vehicleUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(-1L)
                .toUri();
        headers.setLocation(vehicleUri);

        drinkRepository.save(drink);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
