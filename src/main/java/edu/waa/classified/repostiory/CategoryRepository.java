package edu.waa.classified.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.waa.classified.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
