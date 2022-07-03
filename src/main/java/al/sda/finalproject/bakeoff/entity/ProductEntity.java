package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date orderDate;

}
