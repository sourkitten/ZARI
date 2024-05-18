package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookRequest;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookRequestService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class BookOfferController {

    @Autowired
    private BookOfferService bookOfferService;

    @Autowired
    private BookRequestService bookRequestService;

    @Autowired
    private UserService userService;

    @GetMapping("/bookoffer")
    public String showBookOfferForm(Model model) {
        BookOffer bookOffer = new BookOffer();
        model.addAttribute("bookOffer", bookOffer);
        return "user/bookoffer";
    }

    @PostMapping("/bookoffer/save")
    public String saveBookOffer(@ModelAttribute("bookOffer") BookOffer bookOffer) {
        User currentUser = userService.getCurrentUser();
        bookOffer.setUser(currentUser);
        bookOfferService.saveBookOffer(bookOffer);
        return "redirect:/user/bookoffers";
    }

    @GetMapping("/bookoffers")
    public String showUserBookOffers(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("bookOffers", bookOfferService.getBookOffersByUser(currentUser.getId()));
        return "user/bookoffers";
    }

    @GetMapping("/bookrequests")
    public String showBookRequests(Model model) {
        User currentUser = userService.getCurrentUser();
        List<BookRequest> requests = bookRequestService.getRequestsByUserId(currentUser.getId());
        model.addAttribute("requests", requests);
        return "user/bookrequests";
    }
    
    @GetMapping("/bookrequest")
    public String showBookRequestForm(Model model) {
        BookRequest bookRequest = new BookRequest();
        model.addAttribute("bookRequest", bookRequest);
        return "user/bookrequest";
    }

    @PostMapping("/bookrequest/save")
    public String saveBookRequest(@ModelAttribute("bookRequest") BookRequest bookRequest) {
        User currentUser = userService.getCurrentUser();
        bookRequest.setUser(currentUser);
        bookRequestService.saveBookRequest(bookRequest);
        return "redirect:/user/bookoffers";
    }
    
    @GetMapping("/bookOffers")
    public String viewBookOffers(Model model) {
        User currentUser = userService.getCurrentUser();
        List<BookOffer> bookOffers = bookOfferService.findAllExcludingUser(currentUser.getId());
        model.addAttribute("bookOffers", bookOffers);
        return "bookOffers";
    }

}