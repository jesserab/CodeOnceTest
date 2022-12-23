package CodeOnceTest.services;

import CodeOnceTest.models.Category;
import CodeOnceTest.models.Product;
import CodeOnceTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductserviceImpl implements Productservice{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createproduct (Product product){
        return productRepository.save(product);
    }

    @Override
    public Product getproduct (long id){
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getdispoproducts(Category c){
        return productRepository.findByCategoryAndQuantityGreaterThan(c,0.0);
    }

    @Override
    public void deleteproduct(long id) {
        productRepository.deleteById(id);
    }
}
