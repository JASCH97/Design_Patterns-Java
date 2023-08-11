/*
An observer design pattern is useful when you are interested in the state of an Object 
and want to get notified whenever there is any change. In the observer pattern, the 
Object that watches the state of another Object is called observer, and the Object that 
is being watched is called subject.

Java provides an built-in platform for implementing the observer pattern through the 
java.util.Observable class and java.util.Observer interface. However, it’s not widely 
used because the implementation is limited and most of the time we don’t want to end up 
extending a class solely for implementing the observer pattern as Java doesn’t provide 
multiple inheritances in classes. Java Message Service (JMS) uses the observer pattern 
along with the mediator pattern to allow applications to subscribe and publish data to 
other applications.
*/

// ************************* NewsAgency Example: *************************

// Observer interface
interface Observer {
    void update(String message);
}

// Subject (Observable)
class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// Concrete Observers
class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Observer channel1 = new NewsChannel("Channel 1");
        Observer channel2 = new NewsChannel("Channel 2");

        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        newsAgency.setNews("Breaking news: Important event!");
    }
}