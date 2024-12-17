public class JavaLangExample {
    public static void main(String[] args) {
        // Example 1: String class
        String str = "Hello, java.lang!";
        System.out.println("Original String: " + str);
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Substring: " + str.substring(7, 15));

        // Example 2: Math class
        int a = 25, b = 4;
        System.out.println("\nMath Examples:");
        System.out.println("Square root of " + a + ": " + Math.sqrt(a));
        System.out.println("Power (" + a + "^" + b + "): " + Math.pow(a, b));
        System.out.println("Max of " + a + " and " + b + ": " + Math.max(a, b));

        // Example 3: Integer class
        String numStr = "123";
        int num = Integer.parseInt(numStr); // Convert String to int
        System.out.println("\nInteger Examples:");
        System.out.println("Parsed Integer: " + num);
        System.out.println("Integer as Binary: " + Integer.toBinaryString(num));

        // Example 4: Thread class
        System.out.println("\nThread Example:");
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread Running: " + i);
                try {
                    Thread.sleep(500); // Pause for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); // Start the thread

        // Wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main program finished.");
    }
}