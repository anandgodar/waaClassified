package edu.waa.classified.serviceImpl;

import edu.waa.classified.model.Category;
import edu.waa.classified.repostiory.CategoryRepository;
import edu.waa.classified.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRespository;

    @Override
    public boolean saveCategory(Category category) {

        if (categoryRespository.save(category) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAllCategories() {

        return categoryRespository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {

        return categoryRespository.findOne(id);
    }

    @Override
    public boolean updateCategory(Category category) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRespository.delete(id);

    }


}
