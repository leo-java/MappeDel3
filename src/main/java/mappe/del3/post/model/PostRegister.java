package mappe.del3.post.model;

import java.util.ArrayList;

public class PostRegister {
    private ArrayList<Post> postNumberRegister;

    public PostRegister() {
        this.postNumberRegister = new ArrayList<>();
        this.fillRegister();
    }

    private void fillRegister(){
        this.postNumberRegister.add(new Post("postCode","postArea","municipalityCode","municipalityName","category"));
        this.postNumberRegister.add(new Post("1","a","1","A","a"));
        this.postNumberRegister.add(new Post("2","b","2","B","b"));
        this.postNumberRegister.add(new Post("a","b","c","d","e"));
    }

    public ArrayList<Post> getPost() {
        return this.postNumberRegister;
    }

    public void setPost(ArrayList<Post> postNumberRegister) {
        this.postNumberRegister = postNumberRegister;
    }
}
