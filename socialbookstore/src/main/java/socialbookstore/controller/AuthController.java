package socialbookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import socialbookstore.domainmodel.User;
import socialbookstore.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
    	System.out.println("s");
        return "login";
    }
/*
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model) {
        return "redirect:/login?logout=true";
    }
*/
    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }
    
    /*@PostMapping("/register")
    public String registerUser(User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("message", "Registration successful");
        return "redirect:/login";
    }*/
}
