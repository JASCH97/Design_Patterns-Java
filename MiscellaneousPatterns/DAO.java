/*
The Data Access Object (DAO) design pattern is used to decouple the data persistence logic 
to a separate layer. DAO is a very popular pattern when we design systems to work with databases. 
The idea is to keep the service layer separate from the data access layer. This way we implement 
the separation of logic in our application.
*/

// ************************* Student Example: *************************

// Entity class
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Data Access Object interface
interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}

// Concrete DAO implementation
class StudentDAOImpl implements StudentDAO {
    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                break;
            }
        }
    }

    @Override
    public void deleteStudent(Student student) {
        students.removeIf(s -> s.getId() == student.getId());
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();

        studentDAO.addStudent(new Student(1, "Alice"));
        studentDAO.addStudent(new Student(2, "Bob"));

        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }
}

// ************************* Product Example: *************************

// Entity class
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Data Access Object interface
interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}

// Concrete DAO implementation
class ProductDAOImpl implements ProductDAO {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                break;
            }
        }
    }

    @Override
    public void deleteProduct(Product product) {
        products.removeIf(p -> p.getId() == product.getId());
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();

        productDAO.addProduct(new Product(1, "Laptop", 999.99));
        productDAO.addProduct(new Product(2, "Phone", 599.99));

        List<Product> products = productDAO.getAllProducts();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: $" + product.getPrice());
        }
    }
}