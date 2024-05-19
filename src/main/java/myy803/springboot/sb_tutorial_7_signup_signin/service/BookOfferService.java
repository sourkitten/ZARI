package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;

import java.util.List;

public interface BookOfferService {
    void saveBookOffer(BookOffer bookOffer);
    List<BookOffer> getBookOffersByUser(int userId);
    BookOffer findById(int id);
    List<BookOffer> findAllExcludingUser(int userId);
    List<BookOffer> findAllBookOffers();
    void deleteBookOffer(int bookOfferId);
    List<BookOffer> searchBookOffers(String title, String authors, boolean exactMatch);
    List<BookOffer> recommendByCategory(int userId);
    List<BookOffer> recommendByAuthor(int userId);
}
