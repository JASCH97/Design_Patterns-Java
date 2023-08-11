/* 
The singleton pattern restricts the instantiation of a Class and 
ensures that only one instance of the class exists in the 
Java Virtual Machine.

- Singleton pattern restricts the instantiation of a class and ensures 
  that only one instance of the class exists in the Java Virtual Machine.
- The singleton class must provide a global access point to get the instance of the class.
- Singleton pattern is used for logging, drivers objects, caching, and thread pool.
- Singleton design pattern is also used in other design patterns like Abstract Factory, 
  Builder, Prototype, Facade, etc.
- Singleton design pattern is used in core Java classes also 
  (for example, java.lang.Runtime, java.awt.Desktop).
*/

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private builder to avoid direct instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


// ************************* Logger Example: *************************

public class Logger {
    private static Logger instance;
    private String logData;

    private Logger() {
        // Private constructor to prevent direct instantiation
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logData += message + "\n";
    }

    public void printLog() {
        System.out.println(logData);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Log entry 1");
        logger.log("Log entry 2");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Log entry 3");

        logger.printLog();
    }
}
