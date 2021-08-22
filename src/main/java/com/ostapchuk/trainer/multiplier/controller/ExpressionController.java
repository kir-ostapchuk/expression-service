package com.ostapchuk.trainer.multiplier.controller;

import com.ostapchuk.trainer.multiplier.model.Expression;
import com.ostapchuk.trainer.multiplier.service.MultiplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ExpressionController {

    private final MultiplierService multiplierService;

    @GetMapping("/easy")
    public Expression generateEasyExpression() {
        return multiplierService.generateEasyExpression();
    }

    @GetMapping("/medium")
    public Expression generateMediumExpression() {
        return multiplierService.generateMediumExpression();
    }

    @GetMapping("/hard")
    public Expression generateHardExpression() {
        return multiplierService.generateHardExpression();
    }

    @PostMapping()
    public boolean checkAttempt(@RequestBody Expression expression) {
        boolean result = multiplierService.checkAttempt(expression);
        if (!result) {
            log.info(expression.getFirstParameter() + " * " + expression.getSecondParameter());
        }
        return result;
    }
}
