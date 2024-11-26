/*public class page38 {
    public static void main(String[] args) {
        iVehicle[]ivc;
        ivc = new iVehicle[2];

        ivc[0] = new Car(1234, 20.5);
        ivc[1] = new Plane(232);

        for(int i = 0; i < ivc.length;i++){
            ivc[i].show();
        }
    }
}

interface iVehicle{
    int weight = 1000;
    void show();
}

class Car implements iVehicle{
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
    }
}

class Plane implements iVehicle{
    private int flight;

    public Plane(int f){
        flight = f;
        System.out.println("The aircraft of " + flight + "has been produced");
    }

    public void show() {
        System.out.println("The flight number is " + flight);
    }
}*/