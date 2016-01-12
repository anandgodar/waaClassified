package edu.waa.classified.service;

import edu.waa.classified.model.Category;
import edu.waa.classified.model.Product;
import edu.waa.classified.model.User;
import edu.waa.classified.model.WishList;
import edu.waa.classified.repostiory.CategoryRepository;
import edu.waa.classified.repostiory.ProductRepository;
import edu.waa.classified.repostiory.UserRepository;
import edu.waa.classified.repostiory.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {

    @Autowired
    CategoryRepository categoryrepository;
    @Autowired
    ProductRepository productrepository;

    @Autowired
    UserRepository userrepository;

    @Autowired
    WishListRepository wishListRepository;
  
    @PostConstruct
    public void init() {

        Category c1 = new Category();
        Product p1 = new Product();

        List<Product> productList = new ArrayList();
        p1.setName("Pulsor Bike");
        p1.setDescription("Detail of the bike");
        productList.add(p1);
        c1.setName("Automobile");
        c1.setDescription("Description of Automobile");
        c1.setProducts(productList);
        categoryrepository.save(c1);

        Category c2 = new Category();
        Product p2 = new Product();
//        Product p3 = new Product();
        List<Product> productList2 = new ArrayList();
        p2.setName("Apartment on Sale");
        p2.setDescription("Fairfield Iowa");

//        p3.setName("Toyota 2012");
//        p3.setDescription("Almost new Car.");

        productList2.add(p2);
//        productList2.add(p3);

        c2.setName("Real State");
        c2.setDescription("Description of Real State");
        c2.setProducts(productList2);

        categoryrepository.save(c2);


        User u1 = new User();
        u1.setFirstName("Sanjay");
        u1.setLastName("Khatri");
        u1.setUserName("sanjay");
        u1.setPassword("khatri");
        u1.setRoleName("admin");
        u1.setEmail("anandgodar@gmail.com");
        u1.setPhoneNumber("641-954-2725");
        userrepository.save(u1);

        User u2 = new User();
        u2.setFirstName("Ishwor");
        u2.setLastName("Pokharel");
        u2.setUserName("ishwor");
        u2.setPassword("ishwor");
        u2.setRoleName("general");
        u2.setEmail("anandgodar@gmail.com");
        u2.setPhoneNumber("641-954-2725");
        userrepository.save(u2);

        WishList wishList = new WishList();
        wishList.setUserId(1);
        wishList.setProductId(1);
        wishListRepository.save(wishList);
        WishList wishList1 = new WishList();
        wishList1.setUserId(1);
        wishList1.setProductId(2);
        wishListRepository.save(wishList1);
        
        /*Login login = new Login();
		login.setUsername("Anand");
		login.setPassword("Godar");
		login.setRole("Admin");
		
		Member member = new Member();
		member.setFirstName("Anand");
		member.setLastName("Godar");
		member.setEmail("anandgodar@gmail.com");
		
		login.setMember(member);
		
		userRepository.save(login);*/


    }
}