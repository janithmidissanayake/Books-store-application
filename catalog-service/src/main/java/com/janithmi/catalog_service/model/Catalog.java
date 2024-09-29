package com.janithmi.catalog_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "catalog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Catalog name is required")
    @Basic(optional = false)
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
}
