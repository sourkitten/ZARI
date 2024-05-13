package socialbookstore.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import socialbookstore.formsdata.BookFormData;
import socialbookstore.formsdata.RecommendationsFormData;
import socialbookstore.formsdata.SearchFormData;
import socialbookstore.formsdata.UserProfileFormData;
import socialbookstore.service.UserProfileService;

@Controller
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/user/menu")
    public String getUserMainMenu() {
        return "user_menu";  // Path to the main menu view for the user
    }

    @GetMapping("/user/profile")
    public String retrieveProfile(@PathVariable String username, Model model) {
        UserProfileFormData userProfile = userProfileService.retrieveProfile(username);
        model.addAttribute("profile", userProfile);
        return "profile_view";  // Path to the user profile view
    }

    @PostMapping("/user/profile")
    public String saveProfile(UserProfileFormData userProfileFormData, Model model) {
        userProfileService.save(userProfileFormData);
        model.addAttribute("message", "Profile updated successfully");
        return "profile_view";
    }

    @PostMapping("/user/offers")
    public String saveOffer(@ModelAttribute BookFormData bookFormData, Principal principal, Model model) {
        String username = principal.getName(); // Get logged in username
        bookFormData.setUsername(username); // Set the username in BookFormData
        userProfileService.addBookOffer(username, bookFormData); // Assuming this method exists
        model.addAttribute("message", "Offer added successfully");
        return "redirect:/user/offers";
    }


    @GetMapping("/user/offers/new")
    public String showOfferForm(Model model) {
        model.addAttribute("bookFormData", new BookFormData());
        return "offer_form";
    }

    @PostMapping("/user/offers")
    public String saveOffer(BookFormData bookFormData, Model model) {
        userProfileService.addBookOffer(bookFormData.getUsername(), bookFormData);
        model.addAttribute("message", "Offer added successfully");
        return "redirect:/user/offers";
    }

    @GetMapping("/user/search")
    public String showSearchForm(Model model) {
        model.addAttribute("searchFormData", new SearchFormData());
        return "search_form";
    }

    @PostMapping("/user/search")
    public String search(SearchFormData searchFormData, Model model) {
        model.addAttribute("searchResults", userProfileService.searchBooks(searchFormData));
        return "search_results";
    }

    @GetMapping("/user/recommendations")
    public String showRecommendationsForm(Model model) {
        model.addAttribute("recomFormData", new RecommendationsFormData());
        return "recommendations_form";
    }

    @PostMapping("/user/recommendations")
    public String recommendBooks(RecommendationsFormData recomFormData, Model model) {
        model.addAttribute("recommendations", userProfileService.recommendBooks(recomFormData.getUsername(), recomFormData));
        return "recommendations_list";
    }

    @PostMapping("/user/request/{bookId}")
    public String requestBook(@PathVariable int bookId, @PathVariable String username, Model model) {
        userProfileService.requestBook(bookId, username);
        model.addAttribute("message", "Request sent successfully");
        return "redirect:/user/requests";
    }

    @GetMapping("/user/requests")
    public String showUserBookRequests(@PathVariable String username, Model model) {
        model.addAttribute("requests", userProfileService.retrieveBookRequests(username));
        return "book_requests_list";
    }

    @GetMapping("/user/requests/{bookId}")
    public String showRequestingUsersForBookOffer(@PathVariable int bookId, Model model) {
        model.addAttribute("requestingUsers", userProfileService.retrieveRequestingUsers(bookId));
        return "requesting_users_list";
    }

    @PostMapping("/user/accept/{username}/{bookId}")
    public String acceptRequest(@PathVariable String username, @PathVariable int bookId, Model model) {
        userProfileService.acceptRequest(username, bookId);
        model.addAttribute("message", "Request accepted");
        return "redirect:/user/requests";
    }

    @PostMapping("/user/offers/delete/{bookId}")
    public String deleteBookOffer(@PathVariable String username, @PathVariable int bookId, Model model) {
        userProfileService.deleteBookOffer(username, bookId);
        model.addAttribute("message", "Book offer deleted");
        return "redirect:/user/offers";
    }

    @PostMapping("/user/requests/delete/{bookId}")
    public String deleteBookRequest(@PathVariable String username, @PathVariable int bookId, Model model) {
        userProfileService.deleteBookRequest(username, bookId);
        model.addAttribute("message", "Book request deleted");
        return "redirect:/user/requests";
    }
}
