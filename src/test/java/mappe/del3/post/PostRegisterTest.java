package mappe.del3.post;

import mappe.del3.post.model.Post;
import mappe.del3.post.model.PostRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PostRegisterTest {
    private PostRegister postRegister;

    @BeforeEach
    public void init(){
        postRegister = new PostRegister();
    }

    @Test
    @DisplayName("Asserts getting values from post register does not throw")
    public void assertGetPostDoesNotThrow(){
        assertDoesNotThrow(() -> postRegister.getPost());
    }

    @Test
    @DisplayName("Asserts setting values to the post register does not throw")
    public void assertSetPostDoesNotThrow(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post("1","A","1","A","A"));
        assertDoesNotThrow(() -> postRegister.setPost(post));
    }
}
