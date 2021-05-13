package mappe.del3.post.model;

import java.util.ArrayList;

/**
 * The type Post register.
 */
public class PostRegister {
    private ArrayList<Post> postNumberRegister;

    /**
     * Instantiates a new Post register.
     */
    public PostRegister() {
        this.postNumberRegister = new ArrayList<>();
    }

    /**
     * Gets post.
     *
     * @return the post
     */
    public ArrayList<Post> getPost() {
        return this.postNumberRegister;
    }

    /**
     * Sets post.
     *
     * @param postNumberRegister the post number register
     */
    public void setPost(ArrayList<Post> postNumberRegister) {
        this.postNumberRegister = postNumberRegister;
    }
}
