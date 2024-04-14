package me.kiryakov.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class ProductDTO {
    private int id;

    private String productName;

    private BigDecimal productPrice;

    private String url;
}
