package com.example.inventory_service.Controller;

import com.example.inventory_service.DTOs.ToolCatalogDTO;
import com.example.inventory_service.Service.ToolCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
public class ToolCatalogController {

    private final ToolCatalogService toolCatalogService;

    public ToolCatalogController(ToolCatalogService toolCatalogService) {
        this.toolCatalogService = toolCatalogService;
    }

    @GetMapping
    public ResponseEntity<List<ToolCatalogDTO>> getAllCatalogs() {
        return ResponseEntity.ok(toolCatalogService.getAllCatalogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolCatalogDTO> getCatalogById(@PathVariable Long id) {
        return ResponseEntity.ok(toolCatalogService.getCatalogsById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ToolCatalogDTO>> getCatalogsByName(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(toolCatalogService.getCatalogsByName(name));
    }
}

