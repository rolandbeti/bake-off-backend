package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.ProductDAO;
import al.sda.finalproject.bakeoff.dto.ProductDTO;
import al.sda.finalproject.bakeoff.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductDTO> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public ProductDTO findById(Long id) {
        return this.productDAO.findById(id);
    }

    @Override
    public void save(ProductDTO productDTO) {
        this.productDAO.save(productDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.productDAO.deleteById(id);
    }
}
