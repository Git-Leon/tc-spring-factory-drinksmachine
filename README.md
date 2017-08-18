# Drinks Machine Factory
* **Lab Author** - Leon Hunter
* **Purpose** - to demonstrate the [Abstract Factory Design pattern](https://sourcemaking.com/design_patterns/abstract_factory)

# Domain Implementation

* _Domain objects_ are the backbone for an application and contain the [business logic](https://en.wikipedia.org/wiki/Business_logic).
* Create a sub package of `io.zipcoder.drinks_machine_factory` named `domain`.









## Part 1 - Create class `Drink`
* Create an _abstract_ class `Drink` in the `domain` sub-package.

### Part 1.1 - Create class `Coffee`
* Create a sub package of `beverages` named `coffee`.
* Create a subclass of `Drink` named `Coffee` in the `coffee` package.
* Create a subclass of `Coffee` named `Latte` in the `coffee` package.
* Create a subclass of `Coffee` named `Expresso` in the `coffee` package.

### Part 1.2 - Create class `SoftDrink`
* Create a sub package of `beverages` named `softdrink`.
* Create a subclass of `Drink` named `SoftDrink` in the `softdrink` package.
* Create a subclass of `SoftDrink` named `Coke` in the `softdrink` package.
* Create a subclass of `SoftDrink` named `Sprite` in the `softdrink` package.
* Create an enum `SoftDrinkType`  with enumerations for each of the respective `SoftDrink` subclasses










## Part 2 - Create class `DrinksMachine`
* Create a sub package of `domain` named `drinksmachines`
* Create a `DrinksMachine` class which is of [parameterized type]() `E` such that `E` is a subclass of `Enum`.
	* `DrinksMachine` should declare an abstract method `Drink dispenseDrink(E type)`
	* `DrinksMachine` should declare an abstract method `Drink dispenseDrink(String type)`
	
	
### Part 2.1 - Create class CoffeeMachine
* Create a subclass of `DrinkMachine<CofeeType>` named `CoffeeMachine`.
* `CoffeeMachine` should internally define an enum `CoffeeType` with enumerations for each of the respective `Coffee` subclasses.
* Ensure that the inherited method `dispenseDrink` returns a drink with respect to the method argument.



### Part 2.2 - Create class `SoftDrinksMachine`
* Create a subclass of `DrinkMachine<SoftDrinkType>` named `SoftDrinkMachine`.
* `SoftDrinkMachine` should internally define an enum `SoftDrinkType` with enumerations for each of the respective `SoftDrink` subclasses.
* Ensure that the inherited method `dispenseDrink` returns a drink with respect to the method argument.













# Controller Implementation

* _Controllers_ provides all of the necessary [endpoints](https://en.wikipedia.org/wiki/Web_API#Endpoints) to access and manipulate respective domain objects.
	*  REST resources are identified using URI endpoints.
* Create a sub package of `io.zipcoder.tc_spring_vehiclefactory_application` named `controller`.
# Part 7 - Test via Postman
