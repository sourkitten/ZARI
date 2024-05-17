package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookOfferDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOfferServiceImpl implements BookOfferService {

    @Autowired
    private BookOfferDAO bookOfferDAO;

    @Override
    public void saveBookOffer(BookOffer bookOffer) {
        bookOfferDAO.save(bookOffer);
    }

    @Override
    public List<BookOffer> getBookOffersByUser(int userId) {
        return bookOfferDAO.findByUserId(userId);
    }
}
