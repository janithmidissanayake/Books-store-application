package com.janithmi.catalog_service.service;

import com.janithmi.catalog_service.dto.CatalogRequest;
import com.janithmi.catalog_service.dto.CatalogResponse;
import com.janithmi.catalog_service.model.Catalog;
import com.janithmi.catalog_service.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {
    private final CatalogRepository catalogRepository;

  public void createCatalog(CatalogRequest catalogRequest) {
       Catalog catalog = Catalog.builder()
               .name(catalogRequest.getName())
               .description(catalogRequest.getDescription())
               .imageUrl(catalogRequest.getImageUrl())
                .price(catalogRequest.getPrice())
                .build();

        catalogRepository.save(catalog);
        log.info("Catalog created");
    }

    public List<CatalogResponse> getAllCatalogs() {
        List<Catalog> catalogs = catalogRepository.findAll();

        return catalogs.stream().map(this::mapToCatalogResponse).toList();
    }

    private CatalogResponse mapToCatalogResponse(Catalog catalog) {
       return CatalogResponse.builder()
                .id(catalog.getId())
                .name(catalog.getName())
                .description(catalog.getDescription())
                .imageUrl(catalog.getImageUrl())
                .price(catalog.getPrice())
                .build();
    }

}
