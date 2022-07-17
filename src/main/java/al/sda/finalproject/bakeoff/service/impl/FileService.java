package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.ProductDAO;
import al.sda.finalproject.bakeoff.dto.ProductDTO;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    ProductDAO productDAO;
    private final String rootPath = "/Users/user/Desktop/Sda-final-project/bake-off-frontend/src/assets/images";

    public void save(Long id, MultipartFile file) throws FileUploadException {
        try {
            Path root = Paths.get(uploadPath);
            String fileName = file.getOriginalFilename();
            Path resolve = root.resolve(file.getOriginalFilename());
            if (resolve.toFile()
                    .exists()) {
                fileName = 'f'+fileName;
                resolve = root.resolve(fileName);
            }
            Files.copy(file.getInputStream(), resolve);
            ProductDTO productDTO = this.productDAO.findById(id);
            productDTO.setImageUrl(rootPath+fileName);
            productDAO.save(productDTO);

        } catch (Exception e) {
            throw new FileUploadException("Could not store the file. Error: " + e.getMessage());
        }
    }
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofKilobytes(512));
        factory.setMaxRequestSize(DataSize.ofKilobytes(512));
        return factory.createMultipartConfig();
    }
}
