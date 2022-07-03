package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ProductEntity product;
    private int quantity;
    @Column(name = "line_amount")
    private double lineAmount;
}
