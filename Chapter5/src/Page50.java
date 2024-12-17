/*public class Page50 {
    public static void main (String[] args) {
        Car car1 = new Car("Car no 1");

        Thread th1 = new Thread(car1);
        th1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main() processing is in progress");
        }
    }
}

class Car implements Runnable{
    private String name;

    public Car(String nm){
        name = nm;
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println("Processing " + name + " is in progress");
        }
    }
}*/
