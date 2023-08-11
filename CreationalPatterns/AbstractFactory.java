/* 
The abstract factory pattern is similar to the factory pattern and is a factory of factories. 
If you are familiar with the factory design pattern in Java, you will notice that we have a 
single factory class that returns the different subclasses based on the input provided and the 
factory class uses if-else or switch statements to achieve this. In the abstract factory pattern, 
we get rid of if-else block and have a factory class for each subclass and then an abstract factory 
class that will return the subclass based on the input factory class.

- Abstract Factory design pattern provides approach to code for interface rather than implementation.
- Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more 
  products, for example we can add another sub-class Laptop and a factory LaptopFactory.
- Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
*/

interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}


// ************************* GUIFactory Example: *************************

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Abstract Product
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Products
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style checkbox");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac-style button");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac-style checkbox");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a GUIFactory for the current OS
        GUIFactory factory;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Use the factory to create buttons and checkboxes
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Render the UI components
        button.render();
        checkbox.render();
    }
}