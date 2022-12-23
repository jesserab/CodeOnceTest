package CodeOnceTest.repositories;

import CodeOnceTest.models.Category;
import CodeOnceTest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryAndQuantityGreaterThan(Category c , Double i);
}