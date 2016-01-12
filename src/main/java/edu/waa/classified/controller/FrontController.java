package edu.waa.classified.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("USER")
public class FrontController {
    /**
     * It returns the name of login form page.
     * Redirects to the login page.
     * @param model Model domain object.
     * @return login form.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        if (model.containsAttribute("USER")) {
            return "redirect:/user/dashboard";
        }
        return "redirect:/user/login";

    }
}
