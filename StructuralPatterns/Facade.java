/* 
The facade pattern is used to help client applications easily interact with the system.
*/

// ************************* CPU Example: *************************

// Subsystems
class CPU {
    public void start() {
        System.out.println("CPU is starting");
    }

    public void execute() {
        System.out.println("CPU is executing");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory is loading data");
    }
}

class HardDrive {
    public void readData() {
        System.out.println("Hard Drive is reading data");
    }
}

// Facade
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        System.out.println("Computer is starting...");
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
        System.out.println("Computer is ready to use");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}