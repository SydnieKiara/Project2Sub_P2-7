
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String filename = "example.txt";
        String initialContent = "Hello, World!";
        String additionalContent = " This is an appended message.";

        try {
            // Create and write to the file
            FileIO.createAndWriteToFile(filename, initialContent);
            System.out.println("File created and written successfully.");

            // Read the file content
            String content = FileIO.readFile(filename);
            System.out.println("File content: " + content);

            // Append to the file
            FileIO.appendToFile(filename, additionalContent);
            System.out.println("Content appended successfully.");

            // Read the updated file content
            content = FileIO.readFile(filename);
            System.out.println("Updated file content: " + content);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
