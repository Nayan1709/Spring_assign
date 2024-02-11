package Assissment.Assissment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name = "description")
    private String description;
    @ManyToOne()
    @JoinColumn(name="prod_id")
    private Category category;


}
