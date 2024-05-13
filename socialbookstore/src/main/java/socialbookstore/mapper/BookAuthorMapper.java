package socialbookstore.mapper;

import org.apache.ibatis.annotations.*;
import socialbookstore.domainmodel.BookAuthor;

@Mapper
public interface BookAuthorMapper {

    @Insert("INSERT INTO BookAuthor (BId, AId) VALUES (#{bookId}, #{authorId})")
    void insertBookAuthor(BookAuthor bookAuthor);

    @Delete("DELETE FROM BookAuthor WHERE BId = #{bookId} AND AId = #{authorId}")
    void deleteBookAuthor(@Param("bookId") int bookId, @Param("authorId") int authorId);
}
