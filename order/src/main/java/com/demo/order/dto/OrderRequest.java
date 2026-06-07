package com.demo.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {
    @Min(1)
    private long quantity;
    @NotNull
    private long productId;

    @NotNull
    private long userId;
}
