package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
}
