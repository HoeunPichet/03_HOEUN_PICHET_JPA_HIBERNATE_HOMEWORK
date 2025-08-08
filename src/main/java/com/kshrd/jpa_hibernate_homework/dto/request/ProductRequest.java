package com.kshrd.jpa_hibernate_homework.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @Schema(example = "name")
    @NotBlank(message = "Product name is required")
    @Size(min = 3, message = "Product name must be at least 3 characters")
    @Size(max = 255, message = "Product name must not exceed 255 characters")
    @Pattern(
        regexp = "^[a-zA-Z][a-zA-Z\\s]*$",
        message = "Product name is allowed for only letters, and must not start with a space"
    )
    private String name;

    @Schema(example = "0.00")
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    @DecimalMax(value = "99999999.99", message = "Price must not exceed 99999999.99")
    @Digits(integer = 8, fraction = 2, message = "Price must have at most 8 digits before the decimal point and 2 after")
    private BigDecimal price;

    @Schema(example = "1")
    @NotNull(message = "Quantity is required")
    @Min(value = 1L, message = "Quantity must be at least 1")
    @Max(value = 9999999999L, message = "Quantity must not exceed 9999999999")
    private Integer quantity;
}
