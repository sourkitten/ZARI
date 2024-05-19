// RecommendationController.java
package myy803.springboot.sb_tutorial_7_signup_signin.controller;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import myy803.springboot.sb_tutorial_7_signup_signin.service.BookOfferService;
import myy803.springboot.sb_tutorial_7_signup_signin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class RecommendationController {

    @Autowired
    private BookOfferService bookOfferService;

    @Autowired
    private UserService userService;

    @GetMapping("/recommendations")
    public String showRecommendationStrategies(Model model) {
        return "user/recommendations";
    }

    @PostMapping("/recommendations")
    public String getRecommendations(@RequestParam("strategy") String strategy, Model model) {
        int userId = userService.getCurrentUser().getId();
        List<BookOffer> recommendations;
        if (strategy.equals("category")) {
            recommendations = bookOfferService.recommendByCategory(userId);
        } else if (strategy.equals("author")) {
            recommendations = bookOfferService.recommendByAuthor(userId);
        } else {
            recommendations = bookOfferService.findAllExcludingUser(userId); // Default strategy
        }
        model.addAttribute("recommendations", recommendations);
        return "user/recommendation_results";
    }
}
