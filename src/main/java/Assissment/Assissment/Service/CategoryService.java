package Assissment.Assissment.Service;

import Assissment.Assissment.Model.Category;
import Assissment.Assissment.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;
    public Category saveCategory(Category category){
        return categoryRepo.save(category);
    }
    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }
    public List<Category> getallcategory() {
        return categoryRepo.findAll();
    }
    public Optional<Category> updatecategory(Category category) {
        Optional<Category> updatedCategory = Optional.of(categoryRepo.saveAndFlush(category));
        int id = category.getId();
        if(existbyid(id)) return updatedCategory;
        return null;
    }
    public Category findById(int id){
        Optional<Category> tempObj = categoryRepo.findById(id);
        if(tempObj.isEmpty()){
            System.out.println("User id is not there " + id);
        }
        return categoryRepo.findById(id).get();
    }
    public boolean existbyid(int id) {
        boolean existornot = categoryRepo.existsById(id);
        return existornot;
    }
}
