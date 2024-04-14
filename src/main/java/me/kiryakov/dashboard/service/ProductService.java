package me.kiryakov.dashboard.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import me.kiryakov.dashboard.domain.Note;
import me.kiryakov.dashboard.domain.Product;
import me.kiryakov.dashboard.dto.NoteDTO;
import me.kiryakov.dashboard.dto.ProductDTO;
import me.kiryakov.dashboard.repository.NoteRepository;
import me.kiryakov.dashboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();

        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setUrl(productDTO.getUrl());
        product = productRepository.save(product);
        return new ProductDTO(product.getId(), product.getProductName(), product.getProductPrice(), product.getUrl());
    }

    public ProductDTO getById(Integer id) {
        Product product = productRepository.getById(id);
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getProductName(), product.getProductPrice(), product.getUrl());
        return productDTO;
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productRepository.getById(id);
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setUrl(productDTO.getUrl());
        product = productRepository.save(product);
        return new ProductDTO(product.getId(), product.getProductName(), product.getProductPrice(), product.getUrl());
    }
    public void deleteProduct(Integer id){
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }
}
