package socialbookstore.domainmodel;

import java.util.List;

public class BookCategory{
	
	private int categoryId;
    private String name;
    private List<Book> books;

    // Getters and Setters for BookCategory
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
	
}
