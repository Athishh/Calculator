package me.athishh.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @Author: Athishh
 * Package: me.athishh.calculator
 * Created on: 3/4/2024
 */
public class Calculator {
    private final MathContext context;

    public Calculator(int precision) {
        context = new MathContext(precision);
    }

    public BigDecimal exponent(BigDecimal a, int b) {
        return a.pow(b, context);
    }


    public BigDecimal add(BigDecimal... numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            sum = sum.add(number, context);
        }
        return sum;
    }

    public BigDecimal multiply(BigDecimal... numbers) {
        BigDecimal product = BigDecimal.ONE;
        for (BigDecimal number : numbers) {
            product = product.multiply(number, context);
        }
        return product;
    }

    public BigDecimal subtract(BigDecimal... numbers) {
        BigDecimal result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = result.subtract(numbers[i], context);
        }
        return result;
    }

    public BigDecimal divide(BigDecimal... numbers) {
        BigDecimal result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = result.divide(numbers[i], context);
        }
        return result;
    }

    // it is retarded to take more than two numbers for exponentiation
}
