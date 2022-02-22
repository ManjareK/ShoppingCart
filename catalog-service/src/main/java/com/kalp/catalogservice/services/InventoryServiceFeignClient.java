package com.kalp.catalogservice.services;

import com.kalp.catalogservice.web.models.ProductInventoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryServiceFeignClient {

    @GetMapping("/inventory")
    List<ProductInventoryResponse> getInventoryLevels();

    @GetMapping("/inventory/api/{productCode}")
    ResponseEntity<ProductInventoryResponse> getInventoryByProductCode(@PathVariable String productCode);

}
