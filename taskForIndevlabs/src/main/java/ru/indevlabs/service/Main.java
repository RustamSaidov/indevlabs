package ru.indevlabs.service;

import static ru.indevlabs.service.GetLostValue.getLostValue;

public class Main {
    public static void main(String[] args) throws MyCustomException {
        int[] array1 = new int[]{5, 0, 1, 3, 2};
        int[] array2 = new int[]{7, 9, 10, 11, 12};
        int[] array3 = new int[]{-1, -2, 0, 1, 3};
        int[] array4 = new int[]{9, 9};
        int[] array5 = new int[]{1,3,2,7,8,9};
        System.out.println(getLostValue(array1));
        System.out.println(getLostValue(array2));
        System.out.println(getLostValue(array3));
        System.out.println(getLostValue(array4));
        System.out.println(getLostValue(array5));
    }
}
