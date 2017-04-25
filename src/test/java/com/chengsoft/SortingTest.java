package com.chengsoft;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by tcheng on 4/25/17.
 */
public class SortingTest {

    @Test
    public void sortRunner() {
        List<List<Integer>> randomIntArrays = IntStream.range(0, 5)
                .boxed()
                .map(num -> {
                    List<Integer> integerList = IntStream.rangeClosed(1, 10)
                            .boxed()
                            .collect(Collectors.toList());
                    Collections.shuffle(integerList);
                    return integerList;
                })
                .collect(Collectors.toList());

        randomIntArrays
                .stream()
                .map(l -> l.toArray(new Integer[l.size()]))
                .forEach(this::bubbleSort);
    }

    private void bubbleSort(Integer[] array) {
        int tmp;
        System.out.println("=== Beginning ===");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
                System.out.printf("i=%d, j=%d, array=%s\n", i, j, Arrays.toString(array));
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("=== End ===");
    }
}
