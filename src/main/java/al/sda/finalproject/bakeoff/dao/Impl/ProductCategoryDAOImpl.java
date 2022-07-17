package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.ProductCategoryDAO;
import al.sda.finalproject.bakeoff.dto.ProductCategoryDTO;
import al.sda.finalproject.bakeoff.entity.ProductCategoryEntity;
import al.sda.finalproject.bakeoff.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryDAOImpl(ProductCategoryRepository productCategoryRepository){
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        return this.productCategoryRepository.findAll().stream().map(ProductCategoryDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO findById(Long id) {
        Optional<ProductCategoryEntity>productCategoryEntity = this.productCategoryRepository.findById(id);
        return productCategoryEntity.map(ProductCategoryDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(ProductCategoryDTO productCategoryDTO) {
        this.productCategoryRepository.save(ProductCategoryDAOImpl.mapToEntity(productCategoryDTO));
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
