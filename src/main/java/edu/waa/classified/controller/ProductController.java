package edu.waa.classified.controller;

import edu.waa.classified.model.Category;
import edu.waa.classified.model.Product;
import edu.waa.classified.service.CategoryService;
import edu.waa.classified.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes("USER")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    /**
     * Accepts GET request and returns all the products to be displayed.
     * @param model Model domain object
     * @return String listProduct page to display all the product list.
     */
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String listProduct(Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "listProduct";
    }

    /**
     * This method accepts GET request and returns the addProduct form to add new product.
     * It sets Product domain modelattribute "product" to bind with the product add form.
     * @param product Product domain object
     * @param model Model domain object
     * @return String addProduct form page.
     */
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("submitLabel", "Add Product");
        return "addProduct";
    }

    /**
     * Saves new product to the database. This method does store data to database as well as image upload function.
     * It redirects to the product listing page after successful operation. Product domain is validated.
     * @param product Product domain object. It is validated.
     * @param result BindingResult object
     * @param model Model domain object
     * @param request HttpServletRequest
     * @return redirect to the product list
     */
    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request) {
		if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        if (result.hasErrors()) {
            return "addProduct";
        }

        MultipartFile productImage = product.getFileData();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        model.addAttribute("img", rootDirectory + "images/" + product.getId() + ".png");
        productService.saveProduct(product);
        if (productImage != null && !productImage.isEmpty()) {
            try {

                productImage.transferTo(new File(rootDirectory + "images/" + product.getId() + ".png"));
                product.setPhotoLocation(rootDirectory + "images/" + product.getId() + ".png");
                productService.saveProduct(product);
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        return "redirect:/product/";
    }

    /**
     * Pulls product details to edit be edited.Accepts GET request.Product id is sent as a path variable.
     * @param id Integer value of product id to be edited.
     * @param product  Product domain object
     * @param model Model domain object
     * @return addProduct form filled with details to edit the product
     */
    @RequestMapping(value = {"edit/{id}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") Integer id, @ModelAttribute("product") Product product, Model model) {
        if (!model.containsAttribute("USER")) {
            return "redirect:/user/login";
        }
        List<Category> categories = categoryService.findAllCategories();
        Product productedit = productService.findProductById(id);
        model.addAttribute("categories", categories);
        model.addAttribute("submitLabel", "Edit Product");
        model.addAttribute("productedit", productedit);
        //model.addAttribute("imageLocation",productedit);
        return "addProduct";
    }

    /**
     * REST service to delete the
     * @param id Integer value of product id as a path variable.
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "{\"Success\": \"Success\"";

    }


}