package com.example.inventory_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tool_catalogs")

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ToolCatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_catalog_id")
    private Long toolCatalogId;

    @NotBlank(message = "El nombre de la herramienta es obligatorio")
    @Column(name = "tool_name", length = 30, nullable = false)
    private String toolName;

    @NotBlank(message = "La categoría es obligatoria")
    @Column(name = "tool_category", length = 20, nullable = false)
    private String toolCategory;

    @Column(name = "daily_rental_value")
    private Double dailyRentalValue;

    @NotNull(message = "El valor de reposición es obligatorio")
    @Positive(message = "El valor de reposición debe ser mayor que 0")
    @Column(name = "replacement_value", nullable = false)
    private Double replacementValue;

    @Column(length = 256)
    private String description;

    @Column(name = "available_units", nullable = false)
    private int availableUnits;
}
