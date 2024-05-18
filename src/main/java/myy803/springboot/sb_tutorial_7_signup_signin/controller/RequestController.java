package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.Request;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.NotificationService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.RequestService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private BookOfferService bookOfferService;

    @Autowired
    private UserService userService;
    

    /*
    @GetMapping("/bookoffer/{bookOfferId}/requests")
    public String showRequestsForBookOffer(@PathVariable int bookOfferId, Model model) {
        List<Request> requests = requestService.getRequestsByBookOfferId(bookOfferId);
        model.addAttribute("requests", requests);
        return "user/bookoffer_requests";
    }*/

    @GetMapping("/bookoffer/{bookOfferId}/request")
    public String showRequestForm(@PathVariable int bookOfferId, Model model) {
        model.addAttribute("bookOfferId", bookOfferId);
        model.addAttribute("request", new Request());
        return "user/request_form";
    }

    @PostMapping("/bookoffer/{bookOfferId}/request")
    public String submitRequest(@PathVariable int bookOfferId, @ModelAttribute Request request, @RequestParam String message) {
        BookOffer bookOffer = bookOfferService.findById(bookOfferId);
        User currentUser = userService.getCurrentUser();
        request.setBookOffer(bookOffer);
        request.setUser(currentUser);
        request.setMessage(message);
        requestService.saveRequest(request);
        return "redirect:/user/bookoffers";
    }
    
    @GetMapping("/bookoffer/{bookOfferId}/requests")
    public String showRequestsForBookOffer(@PathVariable int bookOfferId, Model model) {
        List<Request> requests = requestService.getRequestsByBookOfferId(bookOfferId);
        model.addAttribute("requests", requests);
        model.addAttribute("bookOfferId", bookOfferId);
        return "user/bookoffer_requests";
    }

    @PostMapping("/bookoffer/{bookOfferId}/requests/{requestId}/select")
    public String selectRequest(@PathVariable int bookOfferId, @PathVariable int requestId) {
        requestService.selectRequest(requestId, bookOfferId);
        return "redirect:/user/bookoffer/" + bookOfferId + "/requests";
    }
    


}
