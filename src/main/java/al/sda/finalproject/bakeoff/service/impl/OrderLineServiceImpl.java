package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.OrderLineDAO;
import al.sda.finalproject.bakeoff.dto.OrderLineDTO;
import al.sda.finalproject.bakeoff.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLineServiceImpl implements OrderLineService {

    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderLineServiceImpl(OrderLineDAO orderLineDAO){
        this.orderLineDAO = orderLineDAO;
    }

    @Override
    public List<OrderLineDTO> findAll() {
        return this.orderLineDAO.findAll();
    }

    @Override
    public OrderLineDTO findById(Long id) {
        return this.orderLineDAO.findById(id);
    }

    @Override
    public void save(OrderLineDTO orderLineDTO) {
        this.orderLineDAO.save(orderLineDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.orderLineDAO.deleteById(id);
    }
}
