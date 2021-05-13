package mappe.del3.post;
import mappe.del3.post.model.Post;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The type File handler.
 */
public class FileHandler {
    /**
     * Instantiates a new File handler.
     */
    public FileHandler(){
    }

    /**
     * Read txt array list.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<Post> readTxt(File file) throws IOException{
        ArrayList<Post> newPostList = new ArrayList<>();
        //Here fileReader will use the charset UTF-8, it is impossible to know how the plain text file is encoded
        //There is no solution to this problem as there will always be a possibility for issues, the best solution could be
        //To check for UTF-8 BOM at the beginning of the text file and if this isn't found revert to ISO 8859-1 encoding
        //This is somewhat outside of the scope of this project so if there are issues displaying special characters the simplest solution
        //Would be to open the saved file, click save as, keep the same name, and change the encoding type to UTF-8.
        try(FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)){
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

    /**
     * Write txt.
     *
     * @param postList the post list
     * @param filePath the file path
     * @throws IOException the io exception
     */
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
