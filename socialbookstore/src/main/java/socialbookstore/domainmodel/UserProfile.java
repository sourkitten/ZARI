package socialbookstore.domainmodel;

import java.util.List;

public class UserProfile {
	
	private String username;
    private String fullName;
    private int age;
    private List<BookAuthor> favouriteBookAuthors;
    private List<BookCategory> favouriteBookCategories;
    private List<Book> bookOffers;

    // Getters and Setters for UserProfile
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

    public List<BookAuthor> getFavouriteBookAuthors() {
        return favouriteBookAuthors;
    }

    public void setFavouriteBookAuthors(List<BookAuthor> favouriteBookAuthors) {
        this.favouriteBookAuthors = favouriteBookAuthors;
    }

    public List<BookCategory> getFavouriteBookCategories() {
        return favouriteBookCategories;
    }

    public void setFavouriteBookCategories(List<BookCategory> favouriteBookCategories) {
        this.favouriteBookCategories = favouriteBookCategories;
    }

    public List<Book> getBookOffers() {
        return bookOffers;
    }

    public void setBookOffers(List<Book> bookOffers) {
        this.bookOffers = bookOffers;
    }
	
    public UserProfile findById(String userName) {
    	// TODO retrieve from database, how?
    	return this;
    }
}
