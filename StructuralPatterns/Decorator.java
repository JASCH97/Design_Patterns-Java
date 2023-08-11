/* 
The decorator design pattern is used to modify the functionality of an object at runtime. 
At the same time, other instances of the same class will not be affected by this, so the 
individual object gets the modified behavior. The decorator design pattern is one of the 
structural design patterns (such as adapter pattern, bridge pattern, or composite pattern) 
and uses abstract classes or interface with the composition to implement. We use inheritance 
or composition to extend the behavior of an object, but this is done at compile-time, and 
it’s applicable to all the instances of the class. We can’t add any new functionality to 
remove any existing behavior at runtime – this is when the decorator pattern is useful.
*/

// ************************* Coffe Example: *************************

// Component
interface Coffee {
    double cost();
    String description();
}

// Concrete Component
class Espresso implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Espresso";
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    @Override
    public String description() {
        return super.description() + " + Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + " + Sugar";
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        System.out.println("Cost: " + espresso.cost() + ", Description: " + espresso.description());

        Coffee milkCoffee = new MilkDecorator(new Espresso());
        System.out.println("Cost: " + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new Espresso()));
        System.out.println("Cost: " + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }
}