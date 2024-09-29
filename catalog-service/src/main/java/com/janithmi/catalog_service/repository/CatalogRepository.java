package com.janithmi.catalog_service.repository;

import com.janithmi.catalog_service.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
