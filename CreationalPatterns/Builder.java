/*
Builder pattern was introduced to solve some of the problems with Factory and Abstract Factory 
design patterns when the Object contains a lot of attributes. There are three major issues with 
Factory and Abstract Factory design patterns when the Object contains a lot of attributes.

- Too Many arguments to pass from client program to the Factory class that can be error prone because 
  most of the time, the type of arguments are same and from client side its hard to maintain the order 
  of the argument.
- Some of the parameters might be optional but in Factory pattern, we are forced to send all the parameters 
  and optional parameters need to send as NULL.
- If the object is heavy and its creation is complex, then all that complexity will be part of Factory classes 
  that is confusing.

We can solve the issues with large number of parameters by providing a constructor with required parameters 
and then different setter methods to set the optional parameters. The problem with this approach is that the 
Object state will be inconsistent until unless all the attributes are set explicitly. Builder pattern solves 
the issue with large number of optional parameters and inconsistent state by providing a way to build the object 
step-by-step and provide a method that will actually return the final Object.

How we can implement builder design pattern in java?

1. First of all you need to create a static nested class and then copy all the arguments from the outer class to the 
  Builder class. We should follow the naming convention and if the class name is Computer then builder class should be 
  named as ComputerBuilder.
2. Java Builder class should have a public constructor with all the required attributes as parameters.
3. Java Builder class should have methods to set the optional parameters and it should return the same Builder object 
   after setting the optional attribute.
4. The final step is to provide a build() method in the builder class that will return the Object needed by client program.
   For this we need to have a private constructor in the Class with Builder class as argument.
*/


class Product {
    private String part1;
    private String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

interface Builder {
    void buildPart1();
    void buildPart2();
    Product getResult();
}

class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("Part 1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Part 2");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}


// ************************* ComputerBuilder Example: *************************

// Product class
class Computer {
    private String cpu;
    private String memory;
    private String storage;
    private String graphicsCard;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer: CPU=" + cpu + ", Memory=" + memory + ", Storage=" + storage + ", Graphics Card=" + graphicsCard;
    }
}

// Builder interface
interface ComputerBuilder {
    void buildCPU();
    void buildMemory();
    void buildStorage();
    void buildGraphicsCard();
    Computer getResult();
}

// Concrete builder
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.setCpu("Intel Core i9");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("32 GB RAM");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 3080");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
class Director {
    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void buildComputer() {
        builder.buildCPU();
        builder.buildMemory();
        builder.buildStorage();
        builder.buildGraphicsCard();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        Director director = new Director(gamingComputerBuilder);

        director.buildComputer();
        Computer gamingComputer = gamingComputerBuilder.getResult();

        System.out.println(gamingComputer);
    }
}