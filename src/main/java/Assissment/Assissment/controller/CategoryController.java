package Assissment.Assissment.controller;

import Assissment.Assissment.Model.Category;
import Assissment.Assissment.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryServ;

    @PostMapping("/add-category")
    @ResponseStatus(HttpStatus.OK)
    public Category save(@RequestBody Category product) {
        return categoryServ.saveCategory(product);
    }
    @DeleteMapping("/deletebyid/{id}")
    public void deletebyid(@PathVariable int id) {
        categoryServ.deleteCategoryById(id);
    }

    @GetMapping("/getallcategory")
    public List<Category> getallCategories() {
        List<Category> category = categoryServ.getallcategory();
        return category;
    }

    @PutMapping("/update/{id}")
    public Optional<Category> updateUser(@RequestBody Category category) {
        Optional<Category> updatedCategory = categoryServ.updatecategory(category);
        return updatedCategory;
    }
    @GetMapping("/findById/{id}")
    public Category findByCategoryId(@PathVariable ("id") int id){
        Category tempObj = categoryServ.findById(id);
        return tempObj;
    }
}
