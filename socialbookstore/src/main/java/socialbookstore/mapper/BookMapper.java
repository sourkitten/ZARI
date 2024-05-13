package socialbookstore.mapper;

import org.apache.ibatis.annotations.*;
import socialbookstore.domainmodel.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM Book WHERE Id = #{id}")
    Book findBookById(int id);

    @Select("SELECT * FROM Book WHERE Title LIKE CONCAT('%', #{title}, '%')")
    List<Book> findBooksByTitle(String title);

    @Insert("INSERT INTO Book (Id, Title, Category) VALUES (#{id}, #{title}, #{category})")
    void insertBook(Book book);

    @Update("UPDATE Book SET Title = #{title}, Category = #{category} WHERE Id = #{id}")
    void updateBook(Book book);

    @Delete("DELETE FROM Book WHERE Id = #{id}")
    void deleteBook(int id);

    // Search books based on keywords and match type
    @Select("<script>" +
            "SELECT * FROM Book " +
            "<where>" +
            "<if test='exactMatch'>" +
            "Title = #{keyword} " +
            "</if>" +
            "<if test='!exactMatch'>" +
            "Title LIKE CONCAT('%', #{keyword}, '%') " +
            "</if>" +
            "</where>" +
            "</script>")
    List<Book> searchBooks(@Param("keyword") String keyword, @Param("exactMatch") boolean exactMatch);

    // Additional methods needed for service operations
    @Delete("DELETE FROM Offers WHERE UId = #{username} AND BId = #{bookId}")
    void deleteBookOffer(@Param("username") String username, @Param("bookId") int bookId);
    
 // Finds books linked to a specific user through Offers table
    @Select("SELECT Book.* FROM Book JOIN Offers ON Book.Id = Offers.BId WHERE Offers.UId = #{username}")
    List<Book> findBooksByUser(String username);

    // Recommend books based on categories preferred by the user
    @Select("<script>" +
            "SELECT * FROM Book WHERE Category IN " +
            "<foreach item='category' collection='categories' open='(' separator=',' close=')'>" +
            "#{category}" +
            "</foreach>" +
            "</script>")
    List<Book> recommendBooks(@Param("username") String username, @Param("categories") String[] strings);

    // Find books exactly matching title and any of the author keywords
    @Select("<script>" +
            "SELECT DISTINCT Book.* FROM Book " +
            "JOIN BookAuthor ON Book.Id = BookAuthor.BId " +
            "JOIN Author ON BookAuthor.AId = Author.Id " +
            "WHERE Book.Title = #{title} AND Author.Name IN " +
            "<foreach item='authorKeyword' collection='authorKeywords' open='(' separator=',' close=')'>" +
            "#{authorKeyword}" +
            "</foreach>" +
            "</script>")
    List<Book> findBooksExactly(@Param("title") String title, @Param("authorKeywords") String[] strings);

    // Find books approximately matching title and any of the author keywords
    @Select("<script>" +
            "SELECT DISTINCT Book.* FROM Book " +
            "JOIN BookAuthor ON Book.Id = BookAuthor.BId " +
            "JOIN Author ON BookAuthor.AId = Author.Id " +
            "WHERE Book.Title LIKE CONCAT('%', #{title}, '%') AND Author.Name LIKE CONCAT('%', " +
            "<foreach item='authorKeyword' collection='authorKeywords' separator='%' open='%' close='%'>" +
            "#{authorKeyword}" +
            "</foreach>, '%')" +
            "</script>")
    List<Book> findBooksApproximately(@Param("title") String title, @Param("authorKeywords") String[] authorKeywords);
}
