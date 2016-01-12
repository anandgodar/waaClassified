package edu.waa.classified.controller;

import edu.waa.classified.model.Product;
import edu.waa.classified.model.User;
import edu.waa.classified.model.WishList;
import edu.waa.classified.service.ProductService;
import edu.waa.classified.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/wishlist")
@SessionAttributes("USER")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    ProductService productService;

    User user = null;

    /**
     * REST service to add product to the wishlist. It accepts POST request and json data as inout.
     * Validates the domain for productId and userId
     * @param wishList Wishlist domain object containing userId and productId.
     * @return stored WishList domain object with generated new wishlist id.
     */
    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public WishList addToWishList(@Valid @RequestBody WishList wishList, BindingResult bindingResult) {
        if (user != null) {
            return wishListService.saveWishList(wishList);
        }
        return new WishList();
    }

    /**
     * Accepts GET request. Fetch all the wishlist of logged in user from database and returns to the wishlist page.
     * @return String. wishlist page to be displayed.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getWishList() {
        if (user != null) {
            List<WishList> allWishLists = wishListService.findAllWishLists(user.getId());
            List<Product> productList = new ArrayList<Product>(allWishLists.size());
            for (WishList wishList : allWishLists) {
                productList.add(productService.findProductById(wishList.getProductId()));
            }
            user.setProducts(productList);
            return "wishlist";
        }
        return "redirect:/user/login";
    }

    /**
     * Accepts DELETE request to delete the product from the database.userid and productid are sent as path variables.
     * @param userId Integer value of userId first from path variable.
     * @param productId Integer value of productId first from path variable.
     * @return boolean. true if successful and false if unable to delete.
     */
    @RequestMapping(value = "delete/{userId}/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteFromWishList(@PathVariable("userId") Integer userId,@PathVariable("productId") Integer productId) {
        if (user != null && user.getId().equals(userId)) {
            wishListService.deleteWishList(userId, productId);
            return true;
        }
        return false;
    }

    @ModelAttribute
    public void getSession(Model model) {
    	user = null;
        if (model.containsAttribute("USER")) {
            user = (User) ((ModelMap) model).get("USER");
        }
    }
}
