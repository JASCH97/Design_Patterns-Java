/*
DTO stands for Data Transfer Object. It is an object that transports data between 
different processes in an application. A DTO is specifically designed to reduce 
the number of method calls between client and server by aggregating data.
*/

// ************************* User Example: *************************

// DTO
class UserDTO {
    private String username;
    private String email;

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

// Service
class UserService {
    public UserDTO getUserInfo(int userId) {
        // Simulate fetching user data from database
        String username = "alice";
        String email = "alice@example.com";
        return new UserDTO(username, email);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserDTO userDTO = userService.getUserInfo(123);

        System.out.println("Username: " + userDTO.getUsername());
        System.out.println("Email: " + userDTO.getEmail());
    }
}

// ************************* Product Example: *************************

// DTO
class ProductDTO {
    private String name;
    private double price;

    public ProductDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Service
class ProductService {
    public ProductDTO getProductInfo(int productId) {
        // Simulate fetching product data from database
        String name = "Laptop";
        double price = 999.99;
        return new ProductDTO(name, price);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        ProductDTO productDTO = productService.getProductInfo(456);

        System.out.println("Product: " + productDTO.getName());
        System.out.println("Price: $" + productDTO.getPrice());
    }
}

