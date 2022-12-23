package CodeOnceTest.services;

import CodeOnceTest.models.Category;
import CodeOnceTest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryserviceImpl implements Categoryservice{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createcategory (Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category getcategory(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getcategory(String name) {
        Category c = categoryRepository.findByName(name);
        return c ;
    }

    @Override
    public List<Category> getAllcategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deletecategory(long id) {
        categoryRepository.deleteById(id);
    }


}