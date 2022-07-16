package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.OrderDAO;
import al.sda.finalproject.bakeoff.dto.OrderDTO;
import al.sda.finalproject.bakeoff.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }
    @Override
    public List<OrderDTO> findAll() {
        return null;
    }

    @Override
    public OrderDTO findById(Long id) {
        return null;
    }

    @Override
    public void save(OrderDTO orderDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
