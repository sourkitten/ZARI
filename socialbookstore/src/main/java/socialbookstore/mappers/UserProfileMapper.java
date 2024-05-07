package socialbookstore.mappers;

import java.util.List;

import socialbookstore.domainmodel.Book;
import socialbookstore.domainmodel.BookAuthor;
import socialbookstore.domainmodel.BookCategory;

public interface UserProfileMapper {
	
	// Getters and Setters for UserProfile
	String getUsername();

	void setUsername(String username);

	String getFullName();

	void setFullName(String fullName);

	int getAge();

	void setAge(int age);

	List<BookAuthor> getFavouriteBookAuthors();

	void setFavouriteBookAuthors(List<BookAuthor> favouriteBookAuthors);

	List<BookCategory> getFavouriteBookCategories();

	void setFavouriteBookCategories(List<BookCategory> favouriteBookCategories);

	List<Book> getBookOffers();

	void setBookOffers(List<Book> bookOffers);
}
