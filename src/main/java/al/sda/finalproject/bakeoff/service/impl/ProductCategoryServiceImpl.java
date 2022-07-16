package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.ProductCategoryDAO;
import al.sda.finalproject.bakeoff.dto.ProductCategoryDTO;
import al.sda.finalproject.bakeoff.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryDAO productCategoryDAO){
        this.productCategoryDAO = productCategoryDAO;
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        return this.productCategoryDAO.findAll();
    }

    @Override
    public ProductCategoryDTO findById(Long id) {
        return this.productCategoryDAO.findById(id);
    }

    @Override
    public void save(ProductCategoryDTO productCategoryDTO) {
        this.productCategoryDAO.save(productCategoryDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.productCategoryDAO.deleteById(id);
    }
}
