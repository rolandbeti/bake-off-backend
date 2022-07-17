package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private CustomerEntity customer;
    private double totalAmount;
    private List<OrderLineDTO>orderLines;
    private String status;

}
