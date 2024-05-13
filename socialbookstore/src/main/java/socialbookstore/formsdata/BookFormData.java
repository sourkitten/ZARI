package socialbookstore.formsdata;

public class BookFormData {
    private int bookId;
    private String title;
    private String[] authorNames; // Array of author names
    private int categoryId; // Id of the book category
    private String description; // Description of the book
    private String username; // Username of the user associated with the book

    // Constructor, getters and setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String[] authorNames) {
        this.authorNames = authorNames;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
