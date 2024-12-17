/*public class Page52 {
    public static void main(String[] args) {
        Company cmp = new Company();

        Driver drv1 = new Driver(cmp);
        drv1.start();

        Driver drv2 = new Driver(cmp);
        drv2.start();
    }
}

class Company {
    private int sum = 0;

    public void add(int a) {
        int tmp = sum;
        System.out.println("The current total amount is " + tmp + "元");
        System.out.println("Earned " + a + "元");
        tmp = tmp + a;
        System.out.println("The total amount is " + tmp + "元");
        sum = tmp;
    }
}

class Driver extends Thread {
    private Company comp;

    public Driver(Company c) {
        comp = c;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            comp.add(50);
        }
    }
}*/