package Assissment.Assissment.Repository;

import Assissment.Assissment.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
List<Product> findByName(String name);
}
