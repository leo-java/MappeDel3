package mappe.del3.post;

import mappe.del3.post.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The type Post test.
 */
public class PostTest {

    /**
     * Asserts valid post does not throw.
     */
    @Test
    @DisplayName("Asserts that making a valid post does not throw")
    public void assertsValidPostDoesNotThrow(){
        assertDoesNotThrow(() -> new Post("1","A","1","A","A"));
    }

    /**
     * Asserts invalid post does throw.
     */
    @Test
    @DisplayName("Asserts that making an invalid post does throw")
    public void assertsInvalidPostDoesThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Post("","","","",""));
        assertThrows(IllegalArgumentException.class, () -> new Post("","a","a","a","a"));
        assertThrows(IllegalArgumentException.class, () -> new Post("a","","a","a","a"));
        assertThrows(IllegalArgumentException.class, () -> new Post("a","a","a","","a"));
        assertThrows(IllegalArgumentException.class, () -> new Post("","","a","","a"));
    }

    /**
     * Asserts get methods work.
     */
    @Test
    @DisplayName("Asserts get methods work")
    public void assertsGetMethodsWork(){
        Post post = new Post("1","A","2","B","C");
        assertDoesNotThrow(() -> post.getPostCode());
        assertDoesNotThrow(() -> post.getPostArea());
        assertDoesNotThrow(() -> post.getMunicipalityNumber());
        assertDoesNotThrow(() -> post.getMunicipalityName());
        assertDoesNotThrow(() -> post.getCategory());
    }
}
