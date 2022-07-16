package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.OrderLineDAO;
import al.sda.finalproject.bakeoff.dto.OrderLineDTO;
import al.sda.finalproject.bakeoff.entity.OrderLineEntity;
import al.sda.finalproject.bakeoff.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderLineDAOImpl implements OrderLineDAO {

    private OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineDAOImpl(OrderLineRepository orderLineRepository){
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public List<OrderLineDTO> findAll() {

        return this.orderLineRepository.findAll().stream().map(OrderLineDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderLineDTO findById(Long id) {

        Optional<OrderLineEntity> orderLineEntity = this.orderLineRepository.findById(id);
        return orderLineEntity.map(OrderLineDAOImpl::mapToDTO).orElse(null);

    }

    @Override
    public void save(OrderLineDTO orderLineDTO) {
        this.orderLineRepository.save(OrderLineDAOImpl.mapToEntity(orderLineDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.orderLineRepository.deleteById(id);
    }


    public static OrderLineEntity mapToEntity(OrderLineDTO orderLineDTO){
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setLineAmount(orderLineDTO.getLineAmount());
        orderLineEntity.setId(orderLineDTO.getId());
        orderLineEntity.setProduct(ProductDAOImpl.mapToEntity(orderLineDTO.getProduct()) );
        orderLineEntity.setQuantity(orderLineDTO.getQuantity());
        return orderLineEntity;
    }

    public static OrderLineDTO mapToDTO(OrderLineEntity orderLineEntity){
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setLineAmount(orderLineEntity.getLineAmount());
        orderLineDTO.setProduct(ProductDAOImpl.mapToDTO(orderLineEntity.getProduct()));
        orderLineDTO.setId(orderLineEntity.getId());
        orderLineDTO.setQuantity(orderLineEntity.getQuantity());
        return orderLineDTO;
    }
}
