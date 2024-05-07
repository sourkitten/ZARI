package socialbookstore.mappers;

import java.util.List;

import socialbookstore.domainmodel.Book;

public interface BookAuthorMapper {

	// Getters and Setters for BookAuthor
	int getAuthorId();

	void setAuthorId(int authorId);

	String getName();

	void setName(String name);

	List<Book> getBooks();

	void setBooks(List<Book> books);

}
