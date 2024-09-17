package ru.indevlabs.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.indevlabs.service.GetLostValue.getLostValue;

class GetLostValueTest {

    @Test
    void whenReturnRightNumber() throws MyCustomException {
        int[] array1 = new int[]{5, 0, 1, 3, 2};
        int expectedValue = 4;
        int result = getLostValue(array1);
        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    void whenReturnRightNumberNotEqualToRightAnswer() throws MyCustomException {
        int[] array1 = new int[]{5, 0, 1, 3, 2};
        int expectedValue = 5;
        int result = getLostValue(array1);
        assertThat(result).isNotEqualTo(expectedValue);
    }

    @Test
    void whenArrayIsNull() {
        int[] array1 = null;
        String expectedMessage = "Array is null";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasNoValues() {
        int[] array1 = new int[]{};
        String expectedMessage = "Array has no values";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasOnlyValue() {
        int[] array1 = new int[]{2};
        String expectedMessage = "Array has only value";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasJustTwoValuesAndHasDuplicates() {
        int[] array1 = new int[]{2, 2};
        String expectedMessage = "Array has just two values, Array has duplicates";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasJustTwoValuesAndNoLostValues() {
        int[] array1 = new int[]{3, 2};
        String expectedMessage = "Array has just two values, Array has no lost values";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasDuplicates() {
        int[] array1 = new int[]{5, 0, 0, 3, 2};
        String expectedMessage = "Array has duplicates";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasNoLostValues() {
        int[] array1 = new int[]{5, 4, 1, 3, 2};
        String expectedMessage = "Array has no lost values";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasMultipleLostValues() {
        int[] array1 = new int[]{1, 3, 2, 7, 8, 9};
        String expectedMessage = "Array has multiple lost of the values";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void whenArrayHasDuplicatesAndArrayHasMultipleLostValues() {
        int[] array1 = new int[]{1, 3, 2, 7, 10, 9, 9};
        String expectedMessage = "Array has duplicates, Array has multiple lost of the values";
        Exception exception = assertThrows(MyCustomException.class, () -> {
            getLostValue(array1);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }
}