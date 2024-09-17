package ru.indevlabs.service;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class GetLostValue {

    public static int getLostValue(int[] array) throws MyCustomException {
        boolean flag = false;
        if (array == null) {
            throw new MyCustomException("Array is null");
        }
        if (array.length == 0) {
            throw new MyCustomException("Array has no values");
        }
        if (array.length == 1) {
            throw new MyCustomException("Array has only value");
        }
        StringJoiner joiner = new StringJoiner(", ");

        if (array.length == 2) {
            flag = true;
            joiner.add("Array has just two values");
        }
        long numberOfElements = Arrays.stream(array).distinct().count();

        if (numberOfElements < array.length) {
            flag = true;
            joiner.add("Array has duplicates");
        }

        IntSummaryStatistics summaryStatistics = Arrays.stream(array).summaryStatistics();
        int minValue = summaryStatistics.getMin();
        int maxValue = summaryStatistics.getMax();
        long numberOfElementsInTheRightArray = maxValue-minValue;

        if (numberOfElementsInTheRightArray - array.length > 1) {
            flag = true;
            joiner.add("Array has multiple lost of the values");
        }
        int expectedSum = IntStream.rangeClosed(minValue, maxValue)
                .sum();
        int actualSum = (int) summaryStatistics.getSum();
        int result = expectedSum - actualSum;
        if (result == 0) {
            flag = true;
            joiner.add("Array has no lost values");
        }
        if(flag){
            throw new MyCustomException(joiner.toString());
        }
        return result;
    }
}
