package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookOfferDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.dao.UserDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookOfferServiceImpl implements BookOfferService {

    @Autowired
    private BookOfferDAO bookOfferDAO;

    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void saveBookOffer(BookOffer bookOffer) {
        bookOfferDAO.save(bookOffer);
    }

    @Override	
    public List<BookOffer> getBookOffersByUser(int userId) {
        return bookOfferDAO.findByUserId(userId);
    }
    
    @Override
    public BookOffer findById(int id) {
        return bookOfferDAO.findById(id).orElse(null);
    }
    
    
    @Override
    public List<BookOffer> findAllExcludingUser(int userId) {
        return bookOfferDAO.findByUserIdNot(userId);
    }
    
    @Override
    public List<BookOffer> findAllBookOffers() {
        return bookOfferDAO.findAll();
    }
    
    @Override
    public void deleteBookOffer(int bookOfferId) {
        bookOfferDAO.deleteById(bookOfferId);
    }
    
    @Override
    public List<BookOffer> searchBookOffers(String title, String authors, boolean exactMatch) {
        if (exactMatch) {
            return bookOfferDAO.findByTitleAndAuthors(title, authors);
        } else {
            return bookOfferDAO.findByTitleAndAuthorsContaining(title, authors);
        }
    }
    
    @Override
    public List<BookOffer> recommendByCategory(int userId) {
        User user = userDAO.findById(userId).orElse(null);
        if (user != null) {
            List<String> categories = Arrays.asList(user.getPreferredCategories().split(","));
            return bookOfferDAO.findByCategoryIn(categories);
        }
        return new ArrayList<>();
    }

    @Override
    public List<BookOffer> recommendByAuthor(int userId) {
        User user = userDAO.findById(userId).orElse(null);
        if (user != null) {
            List<String> authors = Arrays.asList(user.getFavoriteAuthors().split(","));
            return authors.stream()
                          .flatMap(author -> bookOfferDAO.findByAuthorsContaining(author).stream())
                          .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }   
    
}
