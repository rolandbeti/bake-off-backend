package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    private CustomerEntity customer;
    @OneToMany
    private List<OrderLineEntity>orderLines;
    @Column(name = "total_amount")
    private double totalAmount;
}
