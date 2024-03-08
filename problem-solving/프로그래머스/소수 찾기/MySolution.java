import java.util.*;
import java.util.stream.*;

class Solution {

    private static Set<Integer> primeNumbers = new HashSet<>();

    private boolean isPrimeNumber(int num) {
        if(num < 2) return false;

        for(int i=2; i<num; i++) {
            if(num%i == 0) return false;
        }

        return true;
    }

    private void makeNumber(String cur, boolean[] visited,
                            String[] numberArr) {

        if(!cur.isEmpty() && isPrimeNumber(Integer.parseInt(cur))) {
            primeNumbers.add(Integer.parseInt(cur));
        }

        for(int i=0; i<visited.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            makeNumber(cur+numberArr[i], visited, numberArr);
            visited[i] = false;
        }
    }

    public int solution(String numbers) {
        String[] numberArr = numbers.split("");

        makeNumber("", new boolean[numberArr.length], numberArr);

        return primeNumbers.size();
    }
}