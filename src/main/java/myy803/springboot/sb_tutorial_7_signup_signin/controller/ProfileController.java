package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.model.Notification;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.NotificationService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private BookOfferService bookOfferService;

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        model.addAttribute("categories", getCategoriesList(currentUser.getPreferredCategories()));

        // Fetch and add notifications
        List<Notification> notifications = notificationService.getNotificationsByUserId(currentUser.getId());
        model.addAttribute("notifications", notifications);

        // Fetch and add book exchanges
        List<BookOffer> bookExchanges = bookOfferService.getBookOffersByUser(currentUser.getId());
        model.addAttribute("bookExchanges", bookExchanges);

        return "user/profile";
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("user") User updatedUser) {
        userService.updateUserProfile(updatedUser);
        return "redirect:/user/profile";
    }

    private List<String> getCategoriesList(String categories) {
        return categories != null && !categories.isEmpty() ? Arrays.asList(categories.split(",")) : Arrays.asList();
    }
    
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") User user, Model model) {
        userService.updateUserProfile(user);
        model.addAttribute("user", user);
        return "user/profile";
    }
}
