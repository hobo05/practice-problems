package com.chengsoft;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by tcheng on 5/4/17.
 */
public class CodeFightsTest {

    char firstNotRepeatingCharacter(String s) {
        int[] letters = new int[26];

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int curChar = charArray[i];
            int value = curChar - '0';
            letters[value]++;
        }

        return IntStream.of(letters)
                .boxed()
                .filter(v -> v > 1)
                .findFirst()
                .map(Character.class::cast)
                .orElse('-');
    }


    @Test
    public void testRecursion() {
//        System.out.println(factorialRegular(Integer.MAX_VALUE));
//        System.out.println(factorialTail(Integer.MAX_VALUE, 1));
        depth(0);
    }

    public void depth(int start) {
        System.out.println(start++);
        depth(start);
    }

    public int factorialRegular (int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorialRegular(n-1);
    }

    // result starts with 1
    public int factorialTail(int n, int result) {
        if (n == 0) {
            return result;
        }

        return factorialTail(n-1, result*n);
    }

    @Test
    public void testChar() {
        char base = '0';
        int num = '9' - base;
        System.out.println(1 % 10);
    }

    @Test
    public void testStringPermutations() {
        String string = "CBA";
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
//        String first = new String(charArray);
        List<String> permutations = generatePermutations(charArray, charArray.length, new ArrayList<>());
        System.out.println(permutations);
    }

    class LetterInWord {
        char letter;
        String word;
        int index;

        LetterInWord(char letter, String word, int index) {
            this.letter = letter;
            this.word = word;
            this.index = index;
        }

        public String toString() {
            return String.format("[%s, %s, %d]", letter, word, index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LetterInWord that = (LetterInWord) o;

            if (letter != that.letter) return false;
            if (index != that.index) return false;
            return word != null ? word.equals(that.word) : that.word == null;
        }

        @Override
        public int hashCode() {
            int result = (int) letter;
            result = 31 * result + (word != null ? word.hashCode() : 0);
            result = 31 * result + index;
            return result;
        }
    }

    private List<String> generatePermutations(char[] charArray, int index, ArrayList<String> strings) {
        if (index == 0) {
            return strings;
        }

        generatePermutations(charArray, index-1, strings);
        int currPos = charArray.length-index;
        for (int i = currPos+1; i < charArray.length; i++) {
            swap(charArray, currPos, i);
            generatePermutations(charArray, index-1, strings);
            swap(charArray, i, currPos);
        }

        return strings;
    }

    private void swap(char[] charArray, int indexA, int indexB) {
        char temp = charArray[indexA];
        charArray[indexA] = charArray[indexB];
        charArray[indexB] = temp;
    }

    @Test
    public void testCountBlackCells() {
//        System.out.println(countBlackCells(3,4));
//        new HashMap<>().keySet()
        List<String> myList = Stream.of("abc".split("")).collect(Collectors.toList());
        List<String> cloneList = new ArrayList<>(myList);
        cloneList.set(1, "blah");
        System.out.println(myList);

        Stack<Integer> stack = new Stack<>();
//        stack.is
    }

    int countBlackCells(int rows, int cols) {
        int answer = 0;
        System.out.printf("rows=%d, cols=%d\n", rows,cols);
        for (int x = 0; x < rows; x++) {
            long L = (long) cols * x / rows;
            System.out.printf("x=%d, L=%d\n", x, L);
            if ((long) cols * x % rows == 0) {
                L--;
                System.out.printf("L--=%d\n", L);
            }
            long R = (long) cols * (x+1) / rows;
            System.out.printf("R=%d\n", R);
            L = Math.max(0, L);
            R = Math.min(R, cols - 1);
            answer += R - L + 1;
            System.out.printf("Math.max(0, L)=%d, Math.min(R, cols - 1)=%d, answer=%d\n", L, R, answer);
        }
        return answer;
    }

    int isSumOfConsecutive2(int n) {

        int[] fails = new ArrayList<Integer>().stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(e -> new int[]{e.getKey(), e.getValue().size()})
                .orElseThrow(() -> new RuntimeException("fail"));


        Set<Integer> usedNums = new HashSet<>();
        int count = 0;
        for (int i = 1; i < n/2+1; i++) {
            int sum = i;
            for (int j = i+1; j < n/2+1; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return count;
    }

    int comfortableNumbers(int l, int r) {

        return -1;
    }

    int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


}
