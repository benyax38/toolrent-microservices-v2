package com.example.inventory_service.DTOs;

import com.example.inventory_service.Entity.ToolCatalogEntity;

public record ToolCatalogDTO(
        Long toolCatalogId,
        String toolName,
        String toolCategory,
        Double dailyRentalValue,
        Double replacementValue,
        String description,
        int availableUnits
) {
    public static ToolCatalogDTO fromEntity(ToolCatalogEntity catalog) {
        return new ToolCatalogDTO(
                catalog.getToolCatalogId(),
                catalog.getToolName(),
                catalog.getToolCategory(),
                catalog.getDailyRentalValue(),
                catalog.getReplacementValue(),
                catalog.getDescription(),
                catalog.getAvailableUnits()
        );
    }
}
