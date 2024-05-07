package socialbookstore.mappers;

import java.util.List;

import socialbookstore.domainmodel.BookAuthor;
import socialbookstore.domainmodel.BookCategory;
import socialbookstore.domainmodel.UserProfile;

public interface BookMapper {

	// Getters and Setters for Book
		int getBookId();

		void setBookId(int bookId);

		String getTitle();

		void setTitle(String title);

		List<BookAuthor> getBookAuthors();

		void setBookAuthors(List<BookAuthor> bookAuthors);

		BookCategory getBookCategory();

		void setBookCategory(BookCategory bookCategory);

		List<UserProfile> getRequestingUsers();

		void setRequestingUsers(List<UserProfile> requestingUsers);
	
}
