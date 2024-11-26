/*public class page9 {
    public static void main(String[] args){
        RacingCar rccar1;
        rccar1 = new RacingCar();

        rccar1.newShow();
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

    public void newShow(){
        System.out.println("The car number is " + num);
        System.out.println("The amount of gasoline is " + gas);
        System.out.println("The racing number is " + course);
    }
}
*/