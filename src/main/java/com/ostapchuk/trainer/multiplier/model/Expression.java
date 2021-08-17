package com.ostapchuk.trainer.multiplier.model;

import lombok.Data;

@Data
public class Expression {
    private final int firstParameter;
    private final int secondParameter;
    private final int userResult;
}
