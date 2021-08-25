package com.ostapchuk.trainer.multiplier.service;

import com.ostapchuk.trainer.multiplier.model.Expression;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.ostapchuk.trainer.multiplier.utils.Constants.EASY_BOUND;
import static com.ostapchuk.trainer.multiplier.utils.Constants.HARD_BOUND;
import static com.ostapchuk.trainer.multiplier.utils.Constants.MEDIUM_BOUND;

@Service
public class ExpressionService {

    private static final Random RANDOM = new Random();

    public Expression generateEasyExpression() {
        return generateExpression(EASY_BOUND);
    }

    public Expression generateMediumExpression() {
        return generateExpression(MEDIUM_BOUND);
    }

    public Expression generateHardExpression() {
        return generateExpression(HARD_BOUND);
    }

    public boolean checkAttempt(Expression expression) {
        return expression.getUserResult() == expression.getFirstParameter() * expression.getSecondParameter();
    }

    private Expression generateExpression(int bound) {
        return new Expression(RANDOM.nextInt(bound) + 1, RANDOM.nextInt(bound) + 1, 0);
    }
}
