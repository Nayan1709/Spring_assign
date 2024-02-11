package Assissment.Assissment.controller;

import Assissment.Assissment.Model.Product;
import Assissment.Assissment.Model.User;
import Assissment.Assissment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productservice;

    // CREATE
    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.OK)
    public Product save(@RequestBody Product product){
        Product res= productservice.save(product);
        return res;
    }

    @PostMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        Product updatedproduct = productservice.updateProduct(product,id);
        return updatedproduct;
    }



    @PostMapping("/delete/{id}")
    public String deleteProductById(@PathVariable int id){
        return productservice.deleteById(id);
    }

    @PostMapping("/{prod}/{cat}")
    public Product updateProductWithCategory(@PathVariable String prod, @PathVariable String cat){
        return productservice.updateProductWithCategory(prod,cat);
    }

    @GetMapping("/")
    public List<Product> getProductByField(@RequestBody(required = false) Product product){

        if(product==null)
            return productservice.getAllProducts();

        return productservice.getProductByField(product);

    }
}
