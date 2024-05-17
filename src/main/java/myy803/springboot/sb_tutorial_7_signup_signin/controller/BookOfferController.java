package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class BookOfferController {

    @Autowired
    private BookOfferService bookOfferService;

    @Autowired
    private UserService userService;

    @GetMapping("/bookoffer")
    public String showBookOfferForm(Model model) {
        model.addAttribute("bookOffer", new BookOffer());
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
}