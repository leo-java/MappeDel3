package mappe.del3.post.model;

import java.util.ArrayList;

public class PostRegister {
    private ArrayList<Post> postNumberRegister;

    public PostRegister() {
        this.postNumberRegister = new ArrayList<>();
    }

    public ArrayList<Post> getPost() {
        return this.postNumberRegister;
    }

    public void setPost(ArrayList<Post> postNumberRegister) {
        this.postNumberRegister = postNumberRegister;
    }
}
