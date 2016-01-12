package edu.waa.classified.controller;

import edu.waa.classified.model.User;
import edu.waa.classified.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("USER")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * Accepts GET request and returns the login form to the user.
     * @param user User domain object and assign "user" as model attribute to bind the form.
     * @param model Model domain object.
     * @return login page
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") User user, Model model) {
        if (model.containsAttribute("USER")) {
            return "redirect:/user/dashboard";
        }
        return "login";
    }

    /**
     * Logout method. It clears the session of current user.
     * @param model Model domain object.
     * @param status SessionStatus object
     * @return page to be redirected.
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(Model model, SessionStatus status) {
        status.setComplete();
        return "redirect:/user/dashboard";

    }

    /**
     * It verifies the user login. Checks if the input username and password match or not. If matches, new session
     * is set and returns the admin dashboard. If doesn't match then it returns the same login page.
     * @param user User domain object.
     * @param result BindingResult object
     * @param model Model domain object
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String verifyUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        User userDetail = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (userDetail != null) {
            model.addAttribute("USER", userDetail);
            return "redirect:/user/dashboard";
        }
        return "redirect:/user/login";

    }

    @RequestMapping(value = {"/", "dashboard"}, method = RequestMethod.GET)
    public String dashboard(Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        User userDetail = (User) ((ModelMap) model).get("USER");
        return "dashboard-" + userDetail.getRoleName();
    }
}
