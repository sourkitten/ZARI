// BookOfferServiceTest.java
package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookOfferDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.dao.UserDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookOfferServiceTest {

    @Mock
    private BookOfferDAO bookOfferDAO;

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private BookOfferServiceImpl bookOfferService;

    private User testUser;
    private BookOffer testBookOffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User();
        testUser.setId(1);
        testUser.setPreferredCategories("Fiction,Science");
        testUser.setFavoriteAuthors("John Doe,Jane Smith");

        testBookOffer = new BookOffer();
        testBookOffer.setId(1);
        testBookOffer.setTitle("Test Book");
        testBookOffer.setAuthors("John Doe");
        testBookOffer.setCategory("Fiction");
    }

    @Test
    public void testRecommendByCategory() {
        when(userDAO.findById(anyInt())).thenReturn(Optional.of(testUser));
        when(bookOfferDAO.findByCategoryIn(anyList())).thenReturn(Arrays.asList(testBookOffer));

        List<BookOffer> recommendedBooks = bookOfferService.recommendByCategory(1);

        assertEquals(1, recommendedBooks.size());
        assertEquals(testBookOffer, recommendedBooks.get(0));
    }

    @Test
    public void testRecommendByCategoryNoResults() {
        when(userDAO.findById(anyInt())).thenReturn(Optional.of(testUser));
        when(bookOfferDAO.findByCategoryIn(anyList())).thenReturn(new ArrayList<>());

        List<BookOffer> recommendedBooks = bookOfferService.recommendByCategory(1);

        assertEquals(0, recommendedBooks.size());
    }

    @Test
    public void testRecommendByAuthorNoResults() {
        when(userDAO.findById(anyInt())).thenReturn(Optional.of(testUser));
        when(bookOfferDAO.findByAuthorsContaining(anyString())).thenReturn(new ArrayList<>());

        List<BookOffer> recommendedBooks = bookOfferService.recommendByAuthor(1);

        assertEquals(0, recommendedBooks.size());
    }

    @Test
    public void testRecommendByInvalidUser() {
        when(userDAO.findById(anyInt())).thenReturn(Optional.empty());

        List<BookOffer> recommendedBooks = bookOfferService.recommendByCategory(1);

        assertEquals(0, recommendedBooks.size());
    }

    @Test
    public void testSearchBookOffersExactMatch() {
        when(bookOfferDAO.findByTitleAndAuthors(anyString(), anyString())).thenReturn(Arrays.asList(testBookOffer));

        List<BookOffer> searchResults = bookOfferService.searchBookOffers("Test Book", "John Doe", true);

        assertEquals(1, searchResults.size());
        assertEquals(testBookOffer, searchResults.get(0));
    }

    @Test
    public void testSearchBookOffersApproximateMatch() {
        when(bookOfferDAO.findByTitleAndAuthorsContaining(anyString(), anyString())).thenReturn(Arrays.asList(testBookOffer));

        List<BookOffer> searchResults = bookOfferService.searchBookOffers("Test", "Doe", false);

        assertEquals(1, searchResults.size());
        assertEquals(testBookOffer, searchResults.get(0));
    }
}
