/*
MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to 
separate application's concerns.

- Model: Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

- View: View represents the visualization of the data that model contains.

- Controller: Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.
*/

// ************************* Temperature Example: *************************

// Model
class TemperatureModel {
    private double temperature;
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public double getTemperature() {
        return temperature;
    }
}

// View
class TemperatureView {
    public void displayTemperature(double temperature) {
        System.out.println("Temperature: " + temperature + "°C");
    }
}

// Controller
class TemperatureController {
    private TemperatureModel model;
    private TemperatureView view;
    
    public TemperatureController(TemperatureModel model, TemperatureView view) {
        this.model = model;
        this.view = view;
    }
    
    public void updateTemperature(double temperature) {
        model.setTemperature(temperature);
        view.displayTemperature(model.getTemperature());
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TemperatureModel model = new TemperatureModel();
        TemperatureView view = new TemperatureView();
        TemperatureController controller = new TemperatureController(model, view);
        
        controller.updateTemperature(25.5); // Set and display temperature
        controller.updateTemperature(32.0); // Set and display temperature
    }
}


// ************************* Student Example: *************************

// Model
class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

// View
class StudentView {
    public void printStudentDetails(String name, int rollNumber) {
        System.out.println("Student:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

// Controller
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNumber());
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student("Alice", 101);

        // Create a view to display student details
        StudentView studentView = new StudentView();

        // Create a controller that connects the model and view
        StudentController studentController = new StudentController(student, studentView);

        // Update and display student details using the controller
        studentController.updateView();
    }
}
