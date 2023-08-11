/* 
When we have interface hierarchies in both interfaces as well as implementations, then the bridge 
design pattern is used to decouple the interfaces from the implementation and to hide the 
implementation details from the client programs. The implementation of the bridge design pattern 
follows the notion of preferring composition over inheritance.
*/

// Implementor
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}

// Concrete Implementors
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API1.circle at " + x + ":" + y + " radius " + radius);
    }
}

class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("API2.circle at " + x + ":" + y + " radius " + radius);
    }
}

// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}

// Refined Abstraction
class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
            new CircleShape(1, 2, 3, new DrawingAPI1()),
            new CircleShape(5, 7, 11, new DrawingAPI2())
        };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}


// ************************* TV Example: *************************

// Implementor interface
interface TV {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

// Concrete Implementors
class SonyTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Sony TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV is turned off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV set to channel " + channel);
    }
}

class SamsungTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Samsung TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV is turned off");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV set to channel " + channel);
    }
}

// Abstraction interface
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setChannel(int channel);
}

// Refined Abstraction
class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        System.out.print("Basic Remote: ");
        tv.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.print("Basic Remote: ");
        tv.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        System.out.print("Basic Remote: ");
        tv.setChannel(channel);
    }
}

class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        System.out.print("Advanced Remote: ");
        tv.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.print("Advanced Remote: ");
        tv.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        System.out.print("Advanced Remote: ");
        tv.setChannel(channel);
    }

    public void mute() {
        System.out.println("Muting the TV");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TV sonyTV = new SonyTV();
        RemoteControl basicRemote = new BasicRemoteControl(sonyTV);

        basicRemote.turnOn();
        basicRemote.setChannel(5);
        basicRemote.turnOff();

        TV samsungTV = new SamsungTV();
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(samsungTV);

        advancedRemote.turnOn();
        advancedRemote.setChannel(10);
        advancedRemote.mute();
        advancedRemote.turnOff();
    }
}