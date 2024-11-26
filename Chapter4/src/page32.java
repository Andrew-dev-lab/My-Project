/*public class page32 {
    public static void main(String[] args) {
        Vehicle[]vc;
        vc = new Vehicle[2];

        vc[0] = new Car(1234, 20.5);
        vc[1] = new Plane(232);

        for(int i = 0; i < vc.length; i++){
            if (vc[i] instanceof Car){
                System.out.println("The " + (i+1) + " object is of Car type");
                System.out.println("The " + (i+1) + " object is not of car type");
            }
        }
    }
}

abstract class Vehicle{
    protected int speed;
    public void setSpeed(int s){
        speed = s;
        System.out.println("Speed is set to " + speed);
    }

    abstract void show();
}

class Car extends Vehicle{
    private int num;
    private double gas;

    public Car(int n, double g){
        num = n;
        gas = g;
        System.out.println("A car with a car number " + num + ", gasoline volume " + gas + " has been produced");
    }

    public void show() {
        System.out.println("The car number is " + num);
        System.out.println("The amount of gasoline is " + gas);
        System.out.println("The speed is " + speed);
    }
}

class Plane extends Vehicle{
    private int flight;

    public Plane(int f){
        System.out.println("The aircraft of " + flight + "has been produced");
    }

    public void show() {
        System.out.println("The flight number is " + flight);
        System.out.println("The speed is " + speed);
    }
}*/
