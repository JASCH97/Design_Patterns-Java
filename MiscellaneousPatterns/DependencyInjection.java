/*
The dependency injection pattern allows us to remove the hard-coded dependencies 
and make our application loosely-coupled, extendable, and maintainable. We can 
implement dependency injection in Java to move the dependency resolution from 
compile-time to runtime. Spring framework is built on the principle of dependency 
injection.
*/

// ************************* Payment Example: *************************

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Payment Method interface
interface PaymentMethod {
    void processPayment(double amount);
}

// Payment Method implementations
class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Payment Processor class
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    @Autowired
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// Spring configuration
@Configuration
public class AppConfig {
    @Bean
    public PaymentMethod creditCardPayment() {
        return new CreditCardPayment();
    }

    @Bean
    public PaymentMethod payPalPayment() {
        return new PayPalPayment();
    }

    @Bean
    public PaymentProcessor paymentProcessor(PaymentMethod paymentMethod) {
        return new PaymentProcessor(paymentMethod);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create and configure the Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the PaymentProcessor bean from the context
        PaymentProcessor paymentProcessor = context.getBean(PaymentProcessor.class);

        // Use the payment processor with different payment methods
        paymentProcessor.process(100.0); // Process credit card payment
        paymentProcessor.process(50.0);  // Process PayPal payment
    }
}


// ************************* MessageService Example: *************************

// Service interface
interface MessageService {
    String getMessage();
}

// Service implementation
class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Email message";
    }
}

// Client class using Constructor Injection
class NotificationService {
    private final MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification() {
        String message = messageService.getMessage();
        System.out.println("Sending notification: " + message);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);

        notificationService.sendNotification();
    }
}
