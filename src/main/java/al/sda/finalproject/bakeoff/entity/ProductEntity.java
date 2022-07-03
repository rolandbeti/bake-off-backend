package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    private ProductCategoryEntity category;
    private String description;
    private String imageUrl;
}
