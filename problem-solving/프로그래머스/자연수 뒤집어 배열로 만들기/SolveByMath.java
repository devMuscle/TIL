import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        List<Integer> arr = new ArrayList<>();

        while(n > 0) {
            arr.add((int)(n%10L));
            n/=10L;
        }

        answer = arr.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}