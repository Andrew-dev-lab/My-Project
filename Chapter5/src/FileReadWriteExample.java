import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Writing to a file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a file I/O example in Java.\n");
            writer.write("File handling is simple and powerful!\n");
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading data from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}