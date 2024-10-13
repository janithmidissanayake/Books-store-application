package com.janithmi.inventory_service.service;

import com.janithmi.inventory_service.dto.InventoryRequest;
import com.janithmi.inventory_service.model.Inventory;
import com.janithmi.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    public Inventory updateInventory (InventoryRequest inventoryRequest){
        Inventory inventory = inventoryRepository.findBySkuCode(inventoryRequest.getSkuCode())
                .orElseThrow(() -> new RuntimeException("catalog not found"));

        inventory.setQuantity(inventoryRequest.getQuantity());
        return inventoryRepository.save(inventory);

    }
}
