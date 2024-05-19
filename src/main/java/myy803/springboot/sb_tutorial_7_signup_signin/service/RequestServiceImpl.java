package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.BookOfferDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.dao.RequestDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.Request;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDAO requestDAO;

    @Autowired
    private BookOfferDAO bookOfferDAO;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @Override
    public List<Request> getRequestsByBookOfferId(int bookOfferId) {
        return requestDAO.findByBookOfferId(bookOfferId);
    }

    @Override
    public void saveRequest(Request request) {
        requestDAO.save(request);
    }

    @Override
    public void selectRequest(int requestId, int bookOfferId) {
        Request selectedRequest = requestDAO.findById(requestId).orElse(null);
        if (selectedRequest != null) {
            BookOffer bookOffer = selectedRequest.getBookOffer();
            User selectedUser = selectedRequest.getUser();
            User currentUser = userService.getCurrentUser();

            // Update the book offer to mark it as taken and set the user who gave the book
            bookOffer.setTakenByUser(selectedUser);
            bookOffer.setGivenByUser(currentUser);
            bookOfferDAO.save(bookOffer);

            notifyUsers(requestId, bookOfferId);
        }
    }

    @Override
    public void notifyUsers(int selectedRequestId, int bookOfferId) {
        List<Request> requests = getRequestsByBookOfferId(bookOfferId);
        for (Request request : requests) {
            if (request.getId() == selectedRequestId) {
                notificationService.saveNotification(request.getUser(), "Your request for the book '" + request.getBookOffer().getTitle() + "' has been approved!");
            } else {
                notificationService.saveNotification(request.getUser(), "The book '" + request.getBookOffer().getTitle() + "' has been given to another user.");
            }
        }
    }
    
    @Override
    public Request findRequestById(int requestId) {
        return requestDAO.findById(requestId).orElse(null);
    }

}
