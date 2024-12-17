/*public class Page47 {
    public static void main (String[] args) {
        Car car1 = new Car("Car no 1");
        car1.start();

        for (int i = 0; i < 5; i++){
            try{
                Thread.sleep(1000);
                System.out.println("main() processing is in progress");
            }
            catch (InterruptedException e){
            }
        }
    }
}

class Car extends Thread{
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
