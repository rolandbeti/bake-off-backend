package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.ProductEntity;
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
}
