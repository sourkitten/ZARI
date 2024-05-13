package socialbookstore.formsdata;

public class UserProfileFormData {
    private String username;
    private String fullName;
    private int age;
    private String[] favoriteAuthors;
    private int[] favoriteCategories;

    // Constructors, Getters, and Setters
    public UserProfileFormData() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public void setFavoriteAuthors(String[] favoriteAuthors) {
        this.favoriteAuthors = favoriteAuthors;
    }

    public int[] getFavoriteCategories() {
        return favoriteCategories;
    }

    public void setFavoriteCategories(int[] favoriteCategories) {
        this.favoriteCategories = favoriteCategories;
    }
}
