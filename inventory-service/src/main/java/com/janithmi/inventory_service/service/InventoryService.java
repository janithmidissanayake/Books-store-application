package com.janithmi.inventory_service.service;

import com.janithmi.inventory_service.dto.InventoryRequest;
import com.janithmi.inventory_service.dto.InventoryResponse;
import com.janithmi.inventory_service.model.Inventory;
import com.janithmi.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository. findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
               ).toList();
    }

//    public Inventory updateInventory (InventoryRequest inventoryRequest){
//        Inventory inventory = inventoryRepository.findBySkuCode(inventoryRequest.getSkuCode())
//                .orElseThrow(() -> new RuntimeException("catalog not found"));
//
//        inventory.setQuantity(inventoryRequest.getQuantity());
//        return inventoryRepository.save(inventory);
//
//    }
}
