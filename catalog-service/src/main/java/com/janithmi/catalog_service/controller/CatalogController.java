package com.janithmi.catalog_service.controller;

import com.janithmi.catalog_service.dto.CatalogRequest;
import com.janithmi.catalog_service.dto.CatalogResponse;
import com.janithmi.catalog_service.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCatalog(@RequestBody CatalogRequest catalogRequest) {
        catalogService.createCatalog(catalogRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogResponse> getAllCatalogs() {
        return catalogService.getAllCatalogs();
    }
}

