package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Product name cannot be blank")
    @Column(name = "Product_Name")
    private String name;

    @Min(value = 0,message = "Quantity must be a zero or a non-negative value")
    @Column(name = "Product_Quantity")
    private long quantity;

    @PositiveOrZero(message = "Price must be a non-negative value")
    @Column(name = "Product_Price")
    private long price;
}
