package chapter7;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {5,4,7,4,7,0,9};
        int[] reversed = Arrays.stream(arr).boxed().sorted((v1, v2) -> v2 - v1).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(reversed));
    }
}
