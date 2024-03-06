import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        for(int i=0; i<numbers.length; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}