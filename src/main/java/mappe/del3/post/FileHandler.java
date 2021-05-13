package mappe.del3.post;
import mappe.del3.post.model.Post;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class FileHandler {
    public FileHandler(){
    }

    public ArrayList<Post> readTxt(File file) throws IOException{
        ArrayList<Post> newPostList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file, StandardCharsets.ISO_8859_1)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row = bufferedReader.readLine();

            while (row!=null){
                String[] list = row.split("\\t");
                try {
                    Post newPost = new Post(list[0],list[1],list[2],list[3],list[4]);
                    newPostList.add(newPost);
                }catch(IllegalArgumentException e){
                    System.out.println("Post could not be created");
                }
                row = bufferedReader.readLine();
            }
        }catch (IOException e){
            throw new IOException("File couldn't be opened");
        }
        return newPostList;
    }

    public void writeTxt(ArrayList<Post> postList, String filePath) throws IOException{
        try (FileWriter fileWriter = new FileWriter(String.valueOf(filePath))){
            for (Post post:postList) {
                String row = post.getPostCode().toUpperCase(Locale.ROOT) + "\t" + post.getPostArea().toUpperCase(Locale.ROOT) + "\t" + post.getMunicipalityNumber().toUpperCase(Locale.ROOT)  + "\t" + post.getMunicipalityName().toUpperCase(Locale.ROOT)  + "\t" + post.getCategory().toUpperCase(Locale.ROOT) + "\t" + "\n";
                fileWriter.append(row);
            }
        }catch (IOException e){
            System.out.println("ERROR: An IOException has occured: " + e.getCause());
            throw e;
        }
    }
}
