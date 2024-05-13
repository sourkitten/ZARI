package socialbookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import socialbookstore.domainmodel.Book;
import socialbookstore.domainmodel.UserProfile;

@Mapper
public interface UserProfileMapper {

    @Select("SELECT * FROM User WHERE User = #{username}")
    UserProfile findByUsername(String username);

    @Insert("INSERT INTO UserProfile (User, FullName, Age) VALUES (#{username}, #{fullName}, #{age})")
    void insertUserProfile(UserProfile userProfile);

    @Update("UPDATE UserProfile SET FullName = #{fullName}, Age = #{age} WHERE User = #{username}")
    void updateUserProfile(UserProfile userProfile);

    // Requests and offers
    @Insert("INSERT INTO Requests (UId, BId) VALUES (#{username}, #{bookId})")
    void addBookRequest(@Param("username") String username, @Param("bookId") int bookId);

    @Delete("DELETE FROM Requests WHERE UId = #{username} AND BId = #{bookId}")
    void deleteBookRequest(@Param("username") String username, @Param("bookId") int bookId);

    @Insert("INSERT INTO Offers (UId, BId) VALUES (#{username}, #{bookId})")
    void insertBookOffer(@Param("username") String username, @Param("bookId") int bookId);

    @Delete("DELETE FROM Offers WHERE UId = #{username} AND BId = #{bookId}")
    void deleteBookOffer(@Param("username") String username, @Param("bookId") int bookId);

    @Select("SELECT * FROM Requests WHERE BId = #{bookId}")
    List<UserProfile> findUsersByBookId(int bookId);

    // Implementing request-related methods
    @Select("SELECT Book.* FROM Book JOIN Requests ON Book.Id = Requests.BId WHERE Requests.UId = #{username}")
    List<Book> findBookRequestsByUsername(String username);
    
    @Update("UPDATE Requests SET Status = #{status} WHERE UId = #{username} AND BId = #{bookId}")
    void updateRequestStatus(@Param("username") String username, @Param("bookId") int bookId, @Param("status") String status);

}
