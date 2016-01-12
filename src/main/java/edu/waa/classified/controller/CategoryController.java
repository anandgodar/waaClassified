package edu.waa.classified.controller;

import edu.waa.classified.model.Category;
import edu.waa.classified.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
@SessionAttributes("USER")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * Returns the form to add category input data. Accepts GET request method.
     * If user is logged in then it returns the addcategory form. If session is not found then it redirects
     * to the login page.
     *
     * @param category Category domain object to bind with the form.
     * @param model    Model object
     * @return String
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("submitLabel", "Add Category");
        return "addcategory";

    }

    /**
     * Adds new category to the database. Accepts POST request method.
     *If session exists, then the input data is stored to the database.
     *
     * @param category Category domain object bind with modelattribute "category" . Fields are validated.
     * @param result BindingResult object.
     * @param model Model object
     * @return String. 1. login page if user is not logged in.
     *                 2. If has validation error, addcategory page.
     *                 3. category if successful.
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAllCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("submitLabel", "Add Category");
            return "addcategory";
        }
        DateFormat df = new SimpleDateFormat("mm/dd/yy");
        Date dateobj = new Date();

        category.setCareateOn(dateobj);
        category.setCreatedBy(2);

        categoryService.saveCategory(category);

        return "redirect:/category";
    }

    /**
     * Accepts HTTP GET request. It is used to list all the available categories in the database.
     *
     * @param category Category domain object.
     * @param model Model object.
     * @return String. listCategory page.
     */
    @RequestMapping(value = {"", "/listcategory"}, method = RequestMethod.GET)
    public String showCategoryList(@ModelAttribute("category") Category category, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);

        return "listCategory";

    }

    /**
     *  Returns the form to edit category data whose id is sent as pathvariable . Accepts GET request method.
     * If user is logged in then it returns the edit category form. If session is not found then it redirects
     * to the login page.
     *
     * @param id Integer. PathVariable "id". This is categoryId to be edited.
     * @param category Category domain object to bind with the form.
     * @param model Model
     * @return String. name of the page to be displayed
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("id") Integer id, @ModelAttribute("category") Category category, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        Category categoryedit = categoryService.findCategoryById(id);
        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categoryedit", categoryedit);
        model.addAttribute("categories", categories);
        model.addAttribute("submitLabel", "Edit Category");

        return "addcategory";

    }

    /**
     * Deletes the category with id as path variable "id".
     * It is REST service which accepts DELETE request and returns json as a result.
     * @param id Integer value of category id. It is taken from path variable.
     * @param model Model domain object.
     * @return Json object if success.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        categoryService.deleteCategory(id);
        return "{\"Success\": \"Success\"";
    }
}
