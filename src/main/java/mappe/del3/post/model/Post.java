package mappe.del3.post.model;

/**
 * The type Post.
 */
public class Post {
    private String postCode;
    private String postArea;
    private String municipalityNumber;
    private String municipalityName;
    private String category;

    /**
     * Instantiates a new Post.
     *
     * @param postCode           the post code
     * @param postArea           the post area
     * @param municipalityNumber the municipality number
     * @param municipalityName   the municipality name
     * @param category           the category
     */
    public Post(String postCode, String postArea, String municipalityNumber, String municipalityName, String category) {
        if(postCode.isBlank() || postArea.isBlank() || municipalityName.isBlank()){
            throw new IllegalArgumentException("Postal code, postal area and municipality name cannot be blank.");
        }
        this.postCode = postCode;
        this.postArea = postArea;
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.category = category;
    }

    /**
     * Gets post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Gets post area.
     *
     * @return the post area
     */
    public String getPostArea() {
        return postArea;
    }

    /**
     * Gets municipality number.
     *
     * @return the municipality number
     */
    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * Gets municipality name.
     *
     * @return the municipality name
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }
}
