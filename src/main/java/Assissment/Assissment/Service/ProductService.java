package Assissment.Assissment.Service;
import Assissment.Assissment.Model.Category;
import Assissment.Assissment.Model.Product;
import Assissment.Assissment.Model.User;
import Assissment.Assissment.Repository.ProductRepository;
import Assissment.Assissment.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productrepository;

    @Autowired
    private CategoryRepository categoryrepository;

    public Product save(Product product){
        Product res= productrepository.save(product);
        System.out.println(res);
        return res;
    }

    public Optional<Product> findproductbyid(int id){
        return productrepository.findById(id);
    }
    public Product updateProduct(Product product,int id){
        Product product1= findproductbyid(id).get();
        if(product.getName()!=null)product1.setName(product.getName());
        if(product.getPrice()>0)product1.setPrice(product.getPrice());
        if(product.getDescription()!=null)product1.setDescription(product.getDescription());
        return productrepository.save(product1);
    }

    public String deleteById(int id){
        if(productrepository.existsById(id)){
            productrepository.deleteById(id);
            return " Product deleted";
        }

        return "Id does not exist";
    }
    public List<Product> getAllProducts(){
        return productrepository.findAll();
    }

    public Product updateProductWithCategory(String prod,String cat){


        List<Category> categoryList= categoryrepository.findByName(cat);
        Category category=categoryList.get(0);
        System.out.println(categoryList);
        if(!categoryrepository.existsById(category.getId())){
            return null;
        }
        List<Product> productList=productrepository.findByName(prod);
        System.out.println(productList);
        Product product=productList.get(0);
        System.out.println(cat+" "+prod);
        product.setCategory(category);
        return productrepository.save(product);
    }

    public List<Product> getProductByField(Product product){
        String name=product.getName();
        List<Product> productList=productrepository.findByName(name);
        return productList;
    }
}
