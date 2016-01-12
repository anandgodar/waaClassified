package edu.waa.classified.service;

import java.util.List;

import edu.waa.classified.model.Product;

public interface ProductService {
    public boolean saveProduct(Product product);

    public List<Product> findAllProducts();

    public Product findProductById(int id);


    public boolean updateProduct(Product product);

    public void deleteProduct(int id);


}

