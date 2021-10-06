package com.samirovic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNCalculatorTest {

    private RPNCalculator rpnCalculator;

    @BeforeEach
    public void setup() {
        this.rpnCalculator = new RPNCalculator();
    }

    @Test
    public void calculate_case_1( ){
        // Given
        String expression = "20 5 /";

        // When
        Float result = rpnCalculator.calculate(expression);

        // Then
        assertEquals( 4, result);
    }

    @Test
    public void calculate_case_2( ){
        // Given
        String expression = "4 2 + 3 - ";

        // When
        Float result = rpnCalculator.calculate(expression);

        // Then
        assertEquals( 3, result);
    }

    @Test
    public void calculate_case_3( ){
        // Given
        String expression = "9 SQRT";

        // When
        Float result = rpnCalculator.calculate(expression);

        // Then
        assertEquals( 3, result);
    }

    @Test
    public void calculate_case_4( ){
        // Given
        String expression = "5 3 4 2 9 1 MAX";

        // When
        Float result = rpnCalculator.calculate(expression);

        // Then
        assertEquals( 9, result);
    }

    @Test
    public void calculate_case_5( ){
        // Given
        String expression = "4 5 MAX 1 2 MAX 5 *";

        // When
        Float result = rpnCalculator.calculate(expression);

        // Then
        assertEquals( 25, result);
    }

}
