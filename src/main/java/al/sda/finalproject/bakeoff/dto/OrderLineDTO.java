package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDTO {

    private Long id;
    private ProductDTO product;
    private int quantity;
    private double lineAmount;
    @JsonIgnore
    private OrderDTO order;
}
