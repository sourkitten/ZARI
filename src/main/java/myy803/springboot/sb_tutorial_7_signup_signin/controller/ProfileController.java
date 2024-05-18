package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.springboot.sb_tutorial_7_signup_signin.model.Notification;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.NotificationService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        model.addAttribute("categories", getCategoriesList(currentUser.getPreferredCategories()));

        // Fetch and add notifications
        List<Notification> notifications = notificationService.getNotificationsByUserId(currentUser.getId());
        model.addAttribute("notifications", notifications);

        return "user/profile";
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("user") User updatedUser) {
        String categories = updatedUser.getPreferredCategories();
        System.out.println("Received categories: " + categories); // Debug print
        userService.updateUserProfile(updatedUser);
        return "redirect:/user/profile";
    }

    private List<String> getCategoriesList(String categories) {
        return categories != null && !categories.isEmpty() ? Arrays.asList(categories.split(",")) : Arrays.asList();
    }
}
