import java.io.*;

/**
 * Utility class for handling file operations such as creation, writing, reading, and appending.
 */
public class FileIO {

    /**
     * Creates a file with the specified filename and writes the provided content to it.
     * If the file already exists, its content will be overwritten.
     *
     * @param filename the name of the file to create
     * @param content  the content to write to the file
     * @throws IOException if an I/O error occurs during file creation or writing
     */
    public static void createAndWriteToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    /**
     * Reads the content of a file with the specified filename and returns it as a String.
     *
     * @param filename the name of the file to read
     * @return the content of the file as a String
     * @throws IOException if an I/O error occurs during file reading
     */
    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); // Remove trailing newline
    }

    /**
     * Appends the specified content to a file with the given filename.
     * If the file does not exist, it will be created.
     *
     * @param filename the name of the file to append content to
     * @param content  the content to append to the file
     * @throws IOException if an I/O error occurs during file appending
     */
    public static void appendToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
        }
    }
}

