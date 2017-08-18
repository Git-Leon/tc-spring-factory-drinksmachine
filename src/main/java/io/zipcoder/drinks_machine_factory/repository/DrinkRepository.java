package io.zipcoder.drinks_machine_factory.repository;

import io.zipcoder.drinks_machine_factory.domain.beverages.Drink;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 8/18/17.
 */
public interface DrinkRepository extends CrudRepository<Drink, Long> {
}
