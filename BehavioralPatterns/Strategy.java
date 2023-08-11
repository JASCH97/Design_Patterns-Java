/*
Strategy pattern is used when we have multiple algorithms for a specific task, and the 
client decides the actual implementation be used at runtime. A strategy pattern is also 
known as a policy pattern. We define multiple algorithms and let client applications pass 
the algorithm to be used as a parameter.

One of the best examples of this pattern is the Collections.sort() method that takes the 
Comparator parameter. Based on the different implementations of comparator interfaces, 
the objects are getting sorted in different ways.
*/

// ************************* Payment Example: *************************

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        PaymentStrategy paypalPayment = new PayPalPayment("user@example.com");

        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100);

        cart.setPaymentStrategy(paypalPayment);
        cart.checkout(50);
    }
}
