/* 
The factory design pattern is used when we have a superclass with multiple sub-classes and based 
on input, we need to return one of the sub-class. This pattern takes out the responsibility of the 
instantiation of a class from the client program to the factory class. Let’s first learn how to 
implement a factory design pattern in java and then we will look into factory pattern advantages. 
We will see some of the factory design pattern usage in JDK

- Factory design pattern provides approach to code for interface rather than implementation.
- Factory pattern removes the instantiation of actual implementation classes from client code. 
  Makes our code more robust, less coupled and easy to extend.
- Factory pattern provides abstraction between implementation and client classes through inheritance.
*/



interface Product {
    void create();
}

class ConcreteProductA implements Product {
    @Override
    public void create() {
        System.out.println("Creating ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Creating ConcreteProductB");
    }
}

abstract class Creator {
    abstract Product factoryMethod();
}

class ConcreteCreatorA extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// ************************* PizzaRestaurant Example: *************************

// Product interface
interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
}

// Concrete products
class MargheritaPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Margherita pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Margherita pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Margherita pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Margherita pizza...");
    }
}

class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Pepperoni pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Pepperoni pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Pepperoni pizza...");
    }
}

// Creator (Factory) interface
interface PizzaFactory {
    Pizza createPizza();
}

// Concrete creators (factories)
class MargheritaPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new MargheritaPizza();
    }
}

class PepperoniPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new PepperoniPizza();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        PizzaFactory margheritaFactory = new MargheritaPizzaFactory();
        Pizza margheritaPizza = margheritaFactory.createPizza();
        margheritaPizza.prepare();
        margheritaPizza.bake();
        margheritaPizza.cut();
        margheritaPizza.box();

        PizzaFactory pepperoniFactory = new PepperoniPizzaFactory();
        Pizza pepperoniPizza = pepperoniFactory.createPizza();
        pepperoniPizza.prepare();
        pepperoniPizza.bake();
        pepperoniPizza.cut();
        pepperoniPizza.box();
    }
}