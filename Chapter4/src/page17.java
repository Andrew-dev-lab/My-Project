/*public class page17 {
    public static void main(String[] args) {
        Car cars[];
        cars = new Car[2];

        cars[0] = new Car();
        cars[0].setCar(1234, 20.5);

        cars[1] = new RacingCar();
        cars[1].setCar(4567, 30.5);

        for (int i = 0; i < cars.length; i++) {
            cars[i].show();
        }
    }
}

class Car{
    protected int num;
    protected double gas;

    public Car(){
        num = 0;
        gas = 0.0;
        System.out.println("Car Produced");
    }

    public void setCar(int n, double g) {
        num = n;
        gas = g;
        System.out.println("Set the Vehicle Number as " + num + ", and the Gasoline amount as " + gas);
    }

    public void show() {
        System.out.println("The Vehicle Number is " + num);
        System.out.println("The amount of Gasoline is " + gas);
    }
}

class RacingCar extends Car {
    private int course;

    public RacingCar() {
        course = 0;
        System.out.println("Racing Car Produced");
    }

    public void setCourse(int c) {
        course = c;
        System.out.println("Set the Vehicle Number to " + course);
    }

    public void show() {
        System.out.println("The car number is " + num);
        System.out.println("The amount of gasoline is " + gas);
        System.out.println("The racing number is " + course);
    }
}*/
