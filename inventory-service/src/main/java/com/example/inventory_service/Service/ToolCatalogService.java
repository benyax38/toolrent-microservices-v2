package com.example.inventory_service.Service;

import com.example.inventory_service.DTOs.ToolCatalogDTO;
import com.example.inventory_service.Entity.ToolCatalogEntity;
import com.example.inventory_service.Repository.ToolCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolCatalogService {

    private final ToolCatalogRepository toolCatalogRepository;

    public ToolCatalogService(ToolCatalogRepository toolCatalogRepository) {
        this.toolCatalogRepository = toolCatalogRepository;
    }

    public List<ToolCatalogDTO> getAllCatalogs() {
        return toolCatalogRepository.findAll()
                .stream()
                .map(ToolCatalogDTO::fromEntity)
                .toList();
    }

    public ToolCatalogDTO getCatalogsById(Long id) {
        ToolCatalogEntity entity = toolCatalogRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Herramienta no encontrada en el catálogo. Id: " + id)
                );

        return ToolCatalogDTO.fromEntity(entity);
    }

    public List<ToolCatalogDTO> getCatalogsByName(String toolName) {
        return toolCatalogRepository
                .findByToolNameContainingIgnoreCase(toolName)
                .stream()
                .map(ToolCatalogDTO::fromEntity)
                .toList();
    }
}
