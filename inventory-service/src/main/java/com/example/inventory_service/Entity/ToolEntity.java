package com.example.inventory_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tools")

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ToolEntity {

    public enum ToolStatus {
        DISPONIBLE,
        PRESTADA,
        EN_REPARACION,
        DADA_DE_BAJA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id")
    private Long toolId;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_tool_state", length = 20, nullable = false)
    private ToolStatus currentToolState;

    @Column(name = "tool_catalog_id", nullable = false)
    private Long toolCatalogId;
}
