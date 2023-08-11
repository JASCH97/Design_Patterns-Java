/* 
Prototype design pattern is used when the Object creation is a costly affair and requires a lot 
of time and resources and you have a similar object already existing. Prototype pattern provides 
a mechanism to copy the original object to a new object and then modify it according to our needs. 
Prototype design pattern uses java cloning to copy the object.
*/

abstract class Prototype implements Cloneable {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

class ConcretePrototype extends Prototype {
    // Add specific attributes and methods if necessary
}


// ************************* CharacterPrototype Example: *************************

// Prototype interface
interface CharacterPrototype {
    CharacterPrototype clone();
    void display();
}

// Concrete prototypes
class Warrior implements CharacterPrototype {
    private String name;

    public Warrior(String name) {
        this.name = name;
    }

    @Override
    public CharacterPrototype clone() {
        return new Warrior(name);
    }

    @Override
    public void display() {
        System.out.println("Warrior: " + name);
    }
}

class Mage implements CharacterPrototype {
    private String name;

    public Mage(String name) {
        this.name = name;
    }

    @Override
    public CharacterPrototype clone() {
        return new Mage(name);
    }

    @Override
    public void display() {
        System.out.println("Mage: " + name);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CharacterPrototype originalWarrior = new Warrior("Aragorn");
        CharacterPrototype clonedWarrior = originalWarrior.clone();
        
        CharacterPrototype originalMage = new Mage("Gandalf");
        CharacterPrototype clonedMage = originalMage.clone();

        originalWarrior.display();
        clonedWarrior.display();

        originalMage.display();
        clonedMage.display();
    }
}
