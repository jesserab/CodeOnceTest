package CodeOnceTest.services;

import CodeOnceTest.models.Category;

import java.util.List;

public interface Categoryservice {
     Category createcategory (Category category);

     Category getcategory(long id);

     Category getcategory(String name);

     List<Category> getAllcategories();

     void deletecategory(long id);

     //Category updatecategory(int id , Category category);
}
