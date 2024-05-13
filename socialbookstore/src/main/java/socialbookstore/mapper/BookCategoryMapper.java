package socialbookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import socialbookstore.domainmodel.Book;
import socialbookstore.domainmodel.BookCategory;

@Mapper
public interface BookCategoryMapper {

    int getCategoryId();
    void setCategoryId(int categoryId);

    String getName();
    void setName(String name);

    List<Book> getBooks();
    void setBooks(List<Book> books);

    // Additional methods for database interactions
    List<BookCategory> findAllCategories();
    BookCategory findCategoryById(int categoryId);
    void insertCategory(BookCategory category);
    void updateCategory(BookCategory category);
    void deleteCategory(int categoryId);
}
