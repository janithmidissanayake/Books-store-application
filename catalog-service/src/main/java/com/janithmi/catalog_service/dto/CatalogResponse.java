package com.janithmi.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
}
