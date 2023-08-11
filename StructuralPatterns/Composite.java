/* 
When we need to create a structure in a way that the objects in the structure has to 
be treated the same way, we can apply composite design pattern. Lets understand it 
with a real life example - A diagram is a structure that consists of Objects such as 
Circle, Lines, Triangle etc. When we fill the drawing with color (say Red), the same 
color also gets applied to the Objects in the drawing. Here drawing is made up of 
different parts and they all have same operations. Composite Pattern consists of 
following objects.

- Base Component: is the interface for all objects in the composition, client program 
  uses base component to work with the objects in the composition. It can be an interface 
  or an abstract class with some methods common to all the objects.
- Leaf: Defines the behaviour for the elements in the composition. It is the building block 
  for the composition and implements base component. It doesn’t have references to other 
  Components.
- Composite: It consists of leaf elements and implements the operations in base component.
*/


// Component
interface Employee {
    void showDetails();
}

// Leaf
class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

// Composite
class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee subordinate : subordinates) {
            subordinate.showDetails();
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Alice");
        Developer dev2 = new Developer("Bob");

        Manager manager1 = new Manager("Charlie");
        manager1.addSubordinate(dev1);
        manager1.addSubordinate(dev2);

        Developer dev3 = new Developer("David");
        Developer dev4 = new Developer("Eve");

        Manager manager2 = new Manager("Frank");
        manager2.addSubordinate(dev3);
        manager2.addSubordinate(dev4);

        Manager director = new Manager("Director");
        director.addSubordinate(manager1);
        director.addSubordinate(manager2);

        director.showDetails();
    }
}


// ************************* Employees Example: *************************

// Component
interface Employee {
    void showDetails();
}

// Leaf
class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

class Designer implements Employee {
    private String name;

    public Designer(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name);
    }
}

// Composite
class Department implements Employee {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Employee developer1 = new Developer("Alice");
        Employee designer1 = new Designer("Bob");

        Department developmentDepartment = new Department("Development");
        developmentDepartment.addEmployee(developer1);
        developmentDepartment.addEmployee(designer1);

        Employee developer2 = new Developer("Charlie");
        Employee designer2 = new Designer("David");

        Department designDepartment = new Department("Design");
        designDepartment.addEmployee(developer2);
        designDepartment.addEmployee(designer2);

        Department company = new Department("Company");
        company.addEmployee(developmentDepartment);
        company.addEmployee(designDepartment);

        company.showDetails();
    }
}