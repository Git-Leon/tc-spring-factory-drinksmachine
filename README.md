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


## Part 3.1 - Create class `VehicleController`
* Create a `VehicleController` class in the `controller` sub package.
	* `VehicleController` signature should be `annotated` with
		* `@RestController`
		* `@RequestMapping(value = "/vehicles")`

* The class should declare a `vehicleRepository` instance variable of type `VehicleRepository`
	* `vehicleRepository` should be `annotated` with `@Inject`
* The class should define method `getAllVehicles()` method which is annotated with `@GetMapping`

* The class should define method `getVehicles(Long vehicleId)`
	* which is annotated with `@PostMapping(value="/{vehicleId}")`
	* method argument is annotated with `@PathVariable`















# Part 4 - Creating Factories

## Part 4.1 - Create class `AbstractRandomEntityFactory`
* Create an _abstract_ class `AbstractRandomEntityFactory<E>` in the `tc_spring_vehiclefactory_application.utilities` package
* The class should declare a method `abstract public E create()`
* The class should define a method `public final Stream<E> createStream(int numberOfVehicles)` which generates a `Stream` of `E` whose `count` is the respective `numberOfVehicles`.


## Part 4.2 - Create class `AbstractRandomVehicleFactory`
* Create an _abstract_ class `AbstractRandomVehicleFactory<E extends Vehicle>` in the `tc_spring_vehiclefactory_application.domain` package.
* The class should declare method `abstract public E createMake(String make)`
* The class should define method `public final E createMake(VehicleMake make)` which makes use of the abstract `createMake(String make)`.
* The class should define method `public E create()` which returns a vehicle whose `vehicleMake` is assigned to a random value from the `VehicleMake` enum







## Part 4.3 - Create class `AbstractRandomBikeFactory`
* Create an _abstract_ class `AbstractRandomBikeFactory` in the `tc_spring_vehiclefactory_application.domain.bike` package.
* The class should be a subclass of `AbstractRandomVehicleFactory<Bike>`.
* The class should define method `public Bike createMake(String make)` which returns a `new Bike` whose
	* `vehicleMake` is set to the respective `make` argument
	* `model` is set to a randomly generated string
	* `isHybrid` is set to a randomly generated boolean
* Tip: make use of `io.zipcoder.tc_spring_personfactory_application.utilties.RandomUtils`

## Part 4.4 - Create class `RandomYamahaBikeFactory`
* Create class `RandomYamahaBikeFactory` in the `tc_spring_vehiclefactory_application.domain.bike` package.
* The class should define method `public Bike create()` which returns a `new Bike` by calling the method `super.createMake(VehicleMake vehicleMake)`.













## Part 4.5 - Create class `AbstractRandomCarFactory`
* Create an _abstract_ class `AbstractRandomCarFactory` in the `tc_spring_vehiclefactory_application.domain.car` package.
* The class should be a subclass of `AbstractRandomVehicleFactory<Car>`.
* The class should define method `public Bike createMake(String make)` which returns a `new Car` whose
	* `vehicleMake` is set to the respective `make` argument
	* `model` is set to a randomly generated string
	* `isHybrid` is set to a randomly generated boolean

## Part 4.6 - Create class `RandomHondaCarFactory`
* Create class `RandomHondaCarFactory` in the `tc_spring_vehiclefactory_application.domain.car` package.
* The class should define method `public Car create()` which returns a `new Car` by calling

```java
super.createMake(VehicleMake vehicleMake)
```








# Part 5 - Create class `RandomVehicleFactoryLookup`
* Create class `RandomVehicleFactoryLookup` in the `tc_spring_vehiclefactory_application.utilities` package.
* The class should have an instance variable, `map` of type `HashMap<String, AbstractRandomVehicleFactory>`.
* The class should define a method `private addToMap(AbstractRandomVehicleFactory... factories)`, which maps each of the respective factory objects to their [simple class name](https://www.tutorialspoint.com/java/lang/class_getsimplename.htm).
* The class should define a _nullary constructor_, which calls

```java
addToMap(new RandomHondaCarFactory(), new RandomYamahaBikeFactory());
```

* The class should define a method `public AbstractRandomVehicleFactory get(String simpleClassName)` which
	* returns the respective factory from `map`
	* throws `IllegalArgumentException` if the `map` has no respective `key`


# Part 6 - Create class `VehicleFactoryController` 
* Create class `VehicleFactoryController`
* The class signature should be annotated with
	* `@RestController`
	* `@RequestMapping(value = "/vehicleFactory")`
* The class should declare an instance variable `vehicleRepository` of type `VehicleRepository`.
	* `vehicleRepository` should be annotated with `@Inject`
* The class should declare an instance variable `factoryLookup` of type `RandomVehicleFactoryLookup`
	* `factoryLookup` should be annotated with `@Inject`
* The class should declare a method `public ResponseEntity<?> createRandomVehicle(String simpleClassName)`
	* `createRandomVehicle` should be annotated with `PostMapping`
	* arugment of `createRandomVehicle` should be annotated with `@RequestParam(value="vehicleMaker")`
	* `simpleClassName` should be used to query from `factoryLookup` for the respective factory and generate a respective `vehicle`.










# Part 7 - Test via Postman
