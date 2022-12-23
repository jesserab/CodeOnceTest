package CodeOnceTest.services;

import CodeOnceTest.models.Category;
import CodeOnceTest.models.Product;
import java.util.List;

public interface Productservice {

    Product createproduct (Product product);

    Product getproduct(long id);

    List<Product> getdispoproducts(Category c);

    void deleteproduct(long id);

}
