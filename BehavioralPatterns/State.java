/*
The state design pattern is used when an Object changes its behavior based on its 
internal state. If we have to change the behavior of an Object based on its state, 
we can have a state variable in the Object and use if-else condition block to perform 
different actions based on the state. The state pattern is used to provide a systematic
and loosely-coupled way to achieve this through context and state implementations.
*/

// ************************* VendingMachine Example: *************************

// Context
class VendingMachine {
    private State state;

    public VendingMachine() {
        state = new ReadyState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void selectItem() {
        state.selectItem();
    }
}

// State interface
interface State {
    void insertCoin();
    void selectItem();
}

// Concrete States
class ReadyState implements State {
    private VendingMachine machine;

    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        machine.setState(new ItemSelectedState(machine));
    }

    @Override
    public void selectItem() {
        System.out.println("Insert coin first");
    }
}

class ItemSelectedState implements State {
    private VendingMachine machine;

    public ItemSelectedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectItem() {
        System.out.println("Dispensing item");
        machine.setState(new ReadyState(machine));
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectItem();  // Insert coin first
        vendingMachine.insertCoin();  // Coin inserted
        vendingMachine.selectItem();  // Dispensing item
    }
}