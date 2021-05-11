package mappe.del3.post;

import mappe.del3.post.model.Post;
import mappe.del3.post.model.PostRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type File handler test.
 */
public class FileHandlerTest {
    private FileHandler fileHandler;
    private PostRegister postRegister;
    private final File file = new File("testData.txt");
    private final String path = file.getAbsolutePath();

    /**
     * Init.
     */
    @BeforeEach
    public void init() {
        fileHandler = new FileHandler();
        postRegister = new PostRegister();
        System.out.println(path);
    }

    /**
     * Write to file does not throw.
     */
    @Test
    @DisplayName("Writing to file does not throw exception")
    public void writeToFileDoesNotThrow() {
        assertDoesNotThrow(() -> fileHandler.writeTxt(postRegister.getPost(),path));
    }

    /**
     * Read from file does not throw.
     */
    @Test
    @DisplayName("Reading from file does not throw exception")
    public void readFromFileDoesNotThrow() {
        assertDoesNotThrow(() -> fileHandler.readTxt(file));
    }

    /**
     * Reading empty file.
     *
     * @throws IOException the io exception
     */
    @Test
    @DisplayName("Reading empty file returns empty list")
    public void readingEmptyFile() throws IOException {
        ArrayList<Post> list = fileHandler.readTxt(file);
        assertTrue(list.isEmpty());
    }

    /**
     * Writing then reading.
     *
     * @throws IOException the io exception
     */
    @Test
    @DisplayName("The read list is the same as the written list")
    public void writingThenReading() throws IOException {
        fileHandler.writeTxt(postRegister.getPost(),path);
        ArrayList<Post> fromFile = fileHandler.readTxt(file);
        assertEquals(postRegister.getPost(),fromFile);
    }
}