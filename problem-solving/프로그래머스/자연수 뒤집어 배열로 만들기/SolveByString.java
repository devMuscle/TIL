import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};

        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        answer = new int[arr.length];

        for(int i=0; i<answer.length; i++) {
            answer[i] = arr[i] - '0';
        }

        return answer;
    }
}