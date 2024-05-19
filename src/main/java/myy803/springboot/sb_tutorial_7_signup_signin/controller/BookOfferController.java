package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.BookRequest;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookRequestService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.RequestService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @Autowired
    private RequestService requestService;

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
    
    @GetMapping("/allbookoffers")
    public String viewAllBookOffers(Model model) {
        model.addAttribute("bookOffers", bookOfferService.findAllBookOffers());
        return "user/allbookoffers";
    }
    
    @PostMapping("/bookoffer/{bookOfferId}/delete")
    public String deleteBookOffer(@PathVariable int bookOfferId) {
        // delete the requests related to the book offer
        requestService.deleteRequestsByBookOfferId(bookOfferId);
        // delete the book offer itself
        bookOfferService.deleteBookOffer(bookOfferId);
        return "redirect:/user/bookoffers";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        return "user/search";
    }

    @PostMapping("/search")
    public String searchBookOffers(@RequestParam("title") String title, @RequestParam("authors") String authors,
                                   @RequestParam(value = "exactMatch", required = false, defaultValue = "false") boolean exactMatch, Model model) {
        List<BookOffer> searchResults = bookOfferService.searchBookOffers(title, authors, exactMatch);
        model.addAttribute("searchResults", searchResults);
        return "user/search_results";
    }
}