package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookOfferDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookRequestDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRequestServiceImpl implements BookRequestService {

    @Autowired
    private BookRequestDAO bookRequestDAO;

    @Autowired
    private BookOfferDAO bookOfferDAO;

    @Override
    public void saveBookRequest(BookRequest bookRequest) {
        BookOffer bookOffer = bookOfferDAO.findById(bookRequest.getBookOffer().getId()).orElse(null);
        if (bookOffer != null) {
            bookRequest.setBookOffer(bookOffer);
            bookRequestDAO.save(bookRequest);
        }
    }

    @Override
    public List<BookRequest> getRequestsByUserId(int userId) {
        return bookRequestDAO.findByBookOfferUserId(userId);
    }
}
