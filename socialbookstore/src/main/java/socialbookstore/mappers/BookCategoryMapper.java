package socialbookstore.mappers;

import java.util.List;

import socialbookstore.domainmodel.Book;

public interface BookCategoryMapper {

	// Getters and Setters for BookCategory
	int getCategoryId();

	void setCategoryId(int categoryId);

	String getName();

	void setName(String name);

	List<Book> getBooks();

	void setBooks(List<Book> books);
}
