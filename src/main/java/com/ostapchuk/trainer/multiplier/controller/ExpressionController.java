package com.ostapchuk.trainer.multiplier.controller;

import com.ostapchuk.trainer.multiplier.model.Expression;
import com.ostapchuk.trainer.multiplier.service.ExpressionService;
import com.ostapchuk.trainer.multiplier.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ExpressionController {

    private final ProducerService producerService;
    private final ExpressionService expressionService;

    @GetMapping("/easy")
    public Expression generateEasyExpression() {
        return expressionService.generateEasyExpression();
    }

    @GetMapping("/medium")
    public Expression generateMediumExpression() {
        return expressionService.generateMediumExpression();
    }

    @GetMapping("/hard")
    public Expression generateHardExpression() {
        return expressionService.generateHardExpression();
    }

    @PostMapping()
    public boolean checkAttempt(@RequestBody Expression expression, KeycloakAuthenticationToken authentication) {
        SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
        AccessToken token = account.getKeycloakSecurityContext().getToken();
        producerService.produceClick(LocalDateTime.now(), token.getId());
        boolean result = expressionService.checkAttempt(expression);
        if (!result) {
            log.info(expression.getFirstParameter() + " * " + expression.getSecondParameter());
        }
        return result;
    }
}
