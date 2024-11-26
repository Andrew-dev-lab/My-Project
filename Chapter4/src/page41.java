public class page41 {
    public static void main(String[] args) {
        Car car1 = new Car(1234, 20.5);
        car1.vShow();
        car1.mShow();
    }
}

interface iVehicle{
    void vShow();
}

interface iMaterial{
    void mShow();
}

class Car implements iVehicle, iMaterial{
    private int num;
    private double gas;

    public Car(int n, double g){
        num = n;
        gas = g;
        System.out.println("A car with a car number " + num + ", gasoline volume " + gas + " has been produced");
    }

    public void vShow() {
        System.out.println("The car number is " + num);
        System.out.println("The amount of gasoline is " + gas);
    }

    public void mShow() {
        System.out.println("The material of the car is iron");
    }
}

