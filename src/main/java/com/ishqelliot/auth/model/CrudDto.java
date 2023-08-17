package com.ishqelliot.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrudDto {
    private int productId;
    private String name;
    private int qty;
    private double price;
}
