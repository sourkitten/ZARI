package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookRequest;

import java.util.List;

public interface BookRequestService {
    void saveBookRequest(BookRequest bookRequest);
    List<BookRequest> getRequestsByUserId(int userId);
    
}