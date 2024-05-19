package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.model.Request;

import java.util.List;

public interface RequestService {
    List<Request> getRequestsByBookOfferId(int bookOfferId);
    void saveRequest(Request request);
    void selectRequest(int requestId, int bookOfferId);
    void notifyUsers(int selectedRequestId, int bookOfferId);
    Request findRequestById(int requestId); 
    void deleteRequestsByBookOfferId(int bookOfferId); 
}
