package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        UserDetails currentUser = userService.getCurrentUser();
        // Add logic to retrieve user profile information and add it to the model
        model.addAttribute("user", currentUser);
        return "user/profile";
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("user") User updatedUser) {
        userService.updateUserProfile(updatedUser);
        return "redirect:/user/profile"; // Redirect back to the profile page
    }
}