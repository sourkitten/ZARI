package socialbookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserProfileService userProfileService;


    public String getUserMainMenu() {
		return null;
	}
    public String retrieveProfile(Model model) {
		return null;
	}
    /*public String saveProfile(UserProfileFormData userProfileFormData, Model theModel) {
		return null;
	} */
    public String listBookOffers(Model model) {
		return null;
	}
    public String showOfferForm(Model model) {
		return null;
	}
    /*public String saveOffer(BookFormData bookFormData, Model model) {
		return null;
	}*/
    public String showSearchForm(Model model) {
		return null;
	}
    /*public String search(SearchFormData searchFormData, Model model) {
		return null;
	}*/
    public String showRecommendationsForm(Model model) {
		return null;
	}
    /*public String recommendBooks(RecommendationsFormData recomFormData, Model model) {
		return null;
	}*/
    public String requestBook(int bookld, Model model) {
		return null;
	}
    public String showUserBookRequests(Model model) {
		return null;
	}
    public String showRequestingUsersForBookOffer(int bookid, Model model) {
		return null;
	}
    public String acceptRequest(String username, int bookid, Model model) {
		return null;
	}
    public String deleteBookOffer(String username, int bookid, Model model) {
		return null;
	}
    public String deleteBookRequest(String username, int bookid, Model model) {
		return null;
	}
	    
}

