package al.sda.finalproject.bakeoff.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @Column(name = "total_amount")
    private double totalAmount;
    @OneToMany(mappedBy = "order")
    private List<OrderLineEntity>orderLines = new ArrayList<>();
    private String status;

    public void addTrip(OrderLineEntity orderLineEntity) {
        orderLineEntity.setOrder(this);
        orderLines.add(orderLineEntity);
    }
}
