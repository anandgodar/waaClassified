package edu.waa.classified.controller;

import edu.waa.classified.model.User;
import edu.waa.classified.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = "/user")
@SessionAttributes("USER")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * REST service to get all the users from the database and return the list of users.
     * Accepts GET request.
     * @return List of User domain object
     */
    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * Checks if session is available or not. If session is available it returns manageUser page as String.
     * If session is not found then redirects to the login page.
     * @param model Model domain object.
     * @return String manageUser jsp file name.
     */
    @RequestMapping(value = "manageUser")
    public String manageUser(Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        return "manageUser";
    }

    /**
     * REST service to get details of user whose Id is passed in the path variable.
     * It accepts GET request.
     * @param id User Id to fetch the details as a path variable.
     * @return User domain model.
     */
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    /**
     *
     * REST service which Accepts POST method. Adds new user to the database. Validates the fields of the User domain.
     * @param user User domain object as RequestBody.
     * @return User domain object with generated new id.
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveEmployee(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return user;
    }


    /**
     * REST service to delete user from the database. It accepts DELETE request.
     * User Id is sent as a path variable.
     *
     * @param id Integer value of userId to be deleted
     * @return String. success message.
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "{\"a\":\"success delete\"}";

    }

}
