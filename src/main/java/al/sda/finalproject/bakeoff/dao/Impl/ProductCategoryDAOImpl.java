package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.ProductCategoryDAO;
import al.sda.finalproject.bakeoff.dto.ProductCategoryDTO;
import al.sda.finalproject.bakeoff.entity.ProductCategoryEntity;

import java.util.List;

public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    @Override
    public List<ProductCategoryDTO> findAll() {
        return null;
    }

    @Override
    public ProductCategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public void save(ProductCategoryDTO productCategoryDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public static ProductCategoryEntity mapToEntity(ProductCategoryDTO productCategoryDTO){
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        productCategoryEntity.setCategoryName(productCategoryDTO.getCategoryName());
        productCategoryEntity.setId(productCategoryDTO.getId());
        return productCategoryEntity;
    }

    public static ProductCategoryDTO mapToDTO(ProductCategoryEntity productCategoryEntity){
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryName(productCategoryEntity.getCategoryName());
        productCategoryDTO.setId(productCategoryEntity.getId());
        return productCategoryDTO;
    }
}
