import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTests {
    private final String testFilename = "testFile.txt";

    @BeforeEach
    public void setUp() {
        File file = new File(testFilename);
        if (file.exists()) file.delete();
    }

    @Test
    public void testFileCreationAndWrite() {
        try {
            FileIO.createAndWriteToFile(testFilename, "Hello, World!");
            assertTrue(new File(testFilename).exists(), "File should be created.");
        } catch (IOException e) {
            fail("Exception during file creation: " + e.getMessage());
        }
    }

    @Test
    public void testReadFile() {
        try {
            FileIO.createAndWriteToFile(testFilename, "Hello, World!");
            String content = FileIO.readFile(testFilename);
            assertEquals("Hello, World!", content.trim(), "Content should match.");
        } catch (IOException e) {
            fail("Exception during file read: " + e.getMessage());
        }
    }

    @Test
    public void testAppendToFile() {
        try {
            FileIO.createAndWriteToFile(testFilename, "Hello,");
            FileIO.appendToFile(testFilename, " World!");
            String content = FileIO.readFile(testFilename);
            assertEquals("Hello, World!", content.trim(), "Appended content should match.");
        } catch (IOException e) {
            fail("Exception during append: " + e.getMessage());
        }
    }
}
