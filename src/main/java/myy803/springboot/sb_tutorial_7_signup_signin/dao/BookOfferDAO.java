package myy803.springboot.sb_tutorial_7_signup_signin.dao;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookOfferDAO extends JpaRepository<BookOffer, Integer> {
    List<BookOffer> findByUserId(int userId);
    List<BookOffer> findByUserIdNot(int userId);
    List<BookOffer> findByTitleAndAuthors(String title, String authors); // Exact match search
    
    @Query("SELECT b FROM BookOffer b WHERE b.title LIKE %:title% AND b.authors LIKE %:authors%")
    List<BookOffer> findByTitleAndAuthorsContaining(@Param("title") String title, @Param("authors") String authors); // Approximate match search}

    @Query("SELECT b FROM BookOffer b WHERE b.category IN :categories")
    List<BookOffer> findByCategoryIn(@Param("categories") List<String> categories);

    @Query("SELECT b FROM BookOffer b WHERE b.authors LIKE CONCAT('%', :author, '%')")
    List<BookOffer> findByAuthorsContaining(@Param("author") String author);
    
}    