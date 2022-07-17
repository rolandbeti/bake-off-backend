package al.sda.finalproject.bakeoff.dao.Impl;
import al.sda.finalproject.bakeoff.dao.OrderDAO;
import al.sda.finalproject.bakeoff.dto.OrderDTO;
import al.sda.finalproject.bakeoff.entity.OrderEntity;
import al.sda.finalproject.bakeoff.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDAOImpl implements OrderDAO {

    private OrderRepository orderRepository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> findAll() {

        return this.orderRepository.findAll().stream().map(OrderDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<OrderEntity> orderEntity = this.orderRepository.findById(id);
        return orderEntity.map(OrderDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        this.orderRepository.save(OrderDAOImpl.mapToEntity(orderDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.orderRepository.deleteById(id);
    }

    public static OrderEntity mapToEntity(OrderDTO orderDTO){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(orderDTO.getOrderDate());
        orderEntity.setId(orderDTO.getId());
        orderEntity.setCustomer(orderDTO.getCustomer());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());
        return orderEntity;
    }

    public static OrderDTO mapToDTO(OrderEntity orderEntity){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderDate(orderEntity.getOrderDate());
        orderDTO.setCustomer(orderEntity.getCustomer());
        orderDTO.setId(orderEntity.getId());
        orderDTO.setTotalAmount(orderEntity.getTotalAmount());
        return orderDTO;
    }
}
