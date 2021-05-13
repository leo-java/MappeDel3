package mappe.del3.post;

import mappe.del3.post.model.Post;
import mappe.del3.post.model.PostRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * The type Post register test.
 */
public class PostRegisterTest {
    private PostRegister postRegister;

    /**
     * Init.
     */
    @BeforeEach
    public void init(){
        postRegister = new PostRegister();
    }

    /**
     * Assert get post does not throw.
     */
    @Test
    @DisplayName("Asserts getting values from post register does not throw")
    public void assertGetPostDoesNotThrow(){
        assertDoesNotThrow(() -> postRegister.getPost());
    }

    /**
     * Assert set post does not throw.
     */
    @Test
    @DisplayName("Asserts setting values to the post register does not throw")
    public void assertSetPostDoesNotThrow(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post("1","A","1","A","A"));
        assertDoesNotThrow(() -> postRegister.setPost(post));
    }
}
