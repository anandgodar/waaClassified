package edu.waa.classified.serviceImpl;

import edu.waa.classified.model.Product;
import edu.waa.classified.repostiory.ProductRepository;
import edu.waa.classified.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRespository;

    @Override
    public boolean saveProduct(Product product) {
        // TODO Auto-generated method stub
        if (productRespository.save(product) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAllProducts() {
        // TODO Auto-generated method stub

        return productRespository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        // TODO Auto-generated method stub
        return productRespository.findOne(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteProduct(int id) {
        // TODO Auto-generated method stub
        productRespository.delete(id);

    }


}
