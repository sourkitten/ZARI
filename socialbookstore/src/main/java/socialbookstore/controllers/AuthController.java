package socialbookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";  // Name of the login view (login.jsp or login.html)
    }
    
	public void register(Model model) {
		// TODO Auto-generated method stub
	}

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        //userService.register(user);
        //model.addAttribute("message", "Registration successful");
        return "login";  // Redirect to login after successful registration
    }
}

