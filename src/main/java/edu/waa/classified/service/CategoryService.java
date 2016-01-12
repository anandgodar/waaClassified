package edu.waa.classified.service;

import java.util.List;

import edu.waa.classified.model.Category;


public interface CategoryService {
    public boolean saveCategory(Category category);

    public List<Category> findAllCategories();

    public Category findCategoryById(int id);


    public boolean updateCategory(Category category);

    public void deleteCategory(int id);


}

