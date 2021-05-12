package mappe.del3.post.model;

public class Post {
    private String postCode;
    private String postArea;
    private String municipalityNumber;
    private String municipalityName;
    private String category;

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

    public String getPostCode() {
        return postCode;
    }

    public String getPostArea() {
        return postArea;
    }

    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public String getCategory() {
        return category;
    }
}
