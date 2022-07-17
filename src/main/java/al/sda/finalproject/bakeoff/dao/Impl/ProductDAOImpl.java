package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.ProductDAO;
import al.sda.finalproject.bakeoff.dto.ProductDTO;
import al.sda.finalproject.bakeoff.entity.ProductEntity;
import al.sda.finalproject.bakeoff.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDAOImpl implements ProductDAO {

    private ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        return this.productRepository.findAll().stream().map(ProductDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional <ProductEntity>productEntity = this.productRepository.findById(id);
        return productEntity.map(ProductDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public void save(ProductDTO productDTO) {

        this.productRepository.save(ProductDAOImpl.mapToEntity(productDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    public static ProductEntity mapToEntity(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(ProductCategoryDAOImpl.mapToEntity(productDTO.getCategory()));
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setImageUrl(productDTO.getImageUrl());
        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        return productEntity;
    }

    public static ProductDTO mapToDTO(ProductEntity productEntity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategory(ProductCategoryDAOImpl.mapToDTO(productEntity.getCategory()));
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setId(productEntity.getId());
        productDTO.setImageUrl(productEntity.getImageUrl());
        productDTO.setName(productEntity.getName());
        productDTO.setPrice(productEntity.getPrice());
        return productDTO;
    }
}
