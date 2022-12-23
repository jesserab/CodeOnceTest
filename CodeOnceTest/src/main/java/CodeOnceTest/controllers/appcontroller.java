package CodeOnceTest.controllers;

import CodeOnceTest.models.Category;
import CodeOnceTest.models.Product;
import CodeOnceTest.services.Categoryservice;
import CodeOnceTest.services.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class appcontroller {
    @Autowired
    Categoryservice categoryservice;

    @Autowired
    Productservice productservice;

    //Create a category
    @PostMapping("/category")
    public ResponseEntity<?> addcategory(@Valid @RequestBody Category category){
        return ResponseEntity.ok(categoryservice.createcategory(category));
    }

    //Get a category by the id
    @GetMapping("/category/{idcategory}")
    public ResponseEntity<?> getcategory(@PathVariable("idcategory") long idcategory){
        return ResponseEntity.ok(categoryservice.getcategory(idcategory));
    }

    //Get a category by the name
    @GetMapping("/categoryByname/{categoryname}")
    public ResponseEntity<?> getcategory(@PathVariable("categoryname") String name){
        return ResponseEntity.ok(categoryservice.getcategory(name));
    }

    //Get all the categories
    @GetMapping("/categories")
    public ResponseEntity<?> getcategories(){
        return ResponseEntity.ok(categoryservice.getAllcategories());
    }

    //Delete a category
    @DeleteMapping("/category/{idcategory}")
    public ResponseEntity<?> deletecategory(@PathVariable long idcategory){
        categoryservice.deletecategory(idcategory);
        return ResponseEntity.ok("Category deleted successfully");
    }

    //Products API

    //Create a product in the category with id "idcategory"
    @PostMapping("/product/{idcategory}")
    public ResponseEntity<?> addproduct(@Valid @RequestBody Product product, @PathVariable long idcategory){
        Product postproduct = product;

        Category category = categoryservice.getcategory(idcategory);
        postproduct.setCategory(category);

        List<Product> products = category.getProducts();
        if(products == null) {
            products = new ArrayList<Product>();
        }

        products.add(postproduct);
        category.setProducts(products);

        return ResponseEntity.ok(productservice.createproduct(postproduct));
    }

    //Get the disponible products in the category with id "idcategory"
    @GetMapping("/productsdispo/{idcategory}")
    public ResponseEntity<?> getproducts(@PathVariable long idcategory){
        Category c = categoryservice.getcategory(idcategory);
        return ResponseEntity.ok(productservice.getdispoproducts(c));
    }

    // Get the disponible products in the category named "categoryname"
    @GetMapping("/productdispoBycategname/{categoryname}")
    public ResponseEntity<?> getproducts(@PathVariable("categoryname") String name){
        Category c = categoryservice.getcategory(name);
        return ResponseEntity.ok(productservice.getdispoproducts(c));
    }

    //Delete the product with id "idproduct"
    @DeleteMapping("/product/{idproduct}")
    public ResponseEntity<?> deteleproduct(@PathVariable long idproduct){
        productservice.deleteproduct(idproduct);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
