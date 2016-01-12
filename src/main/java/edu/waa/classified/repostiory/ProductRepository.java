package edu.waa.classified.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.waa.classified.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
