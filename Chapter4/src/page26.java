/*public class page26 {
    public static void main(String[] args) {
        Car[] cars;
        cars = new Car[2];

        cars[0] = new Car();
        cars[1] = new RacingCar();

        for(int i = 0; i < cars.length; i++){
            Class cl = cars[i].getClass();
            System.out.println("The category of the " + (i+1) + " object is " + cl);
        }
    }
}

class Car {
    protected int num;
    protected double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("Car Produced");
    }
}

class RacingCar extends Car{
    public RacingCar(){
        System.out.println("Racing car produced");
    }
}*/
