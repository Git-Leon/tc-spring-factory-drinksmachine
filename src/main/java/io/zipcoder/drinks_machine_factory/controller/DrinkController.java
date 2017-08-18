package io.zipcoder.drinks_machine_factory.controller;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;
import io.zipcoder.drinks_machine_factory.repository.DrinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

/**
 * Created by leon on 8/18/17.
 */
public class DrinkController {
    @Inject
    private DrinkRepository drinkRepository;

    @GetMapping
    public ResponseEntity<Iterable<Drink>> getAllDrinks() {
        Iterable<Drink> drink = drinkRepository.findAll();
        return new ResponseEntity<>(drink, HttpStatus.OK);
    }

    @PostMapping(value="/{vehicleId}")
    public ResponseEntity<?> getDrink(@PathVariable Long vehicleId) {
        Drink drink = drinkRepository.findOne(vehicleId);
        return new ResponseEntity<> (drink, HttpStatus.OK);
    }
}
