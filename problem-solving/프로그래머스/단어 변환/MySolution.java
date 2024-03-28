import java.util.*;

class Solution {

    private static int minChange = 51;

    private void DFS(int changeCount, String cur, String target,
                     String[] words, boolean[] isVisited) {
        if(cur.equals(target)) {
            minChange = Math.min(minChange, changeCount);
            return;
        }

        for(int i = 0 ; i < words.length; i++) {
            if(isVisited[i]) continue;

            if(canChange(cur, words[i])) {
                isVisited[i] = true;
                DFS(changeCount + 1, words[i], target, words, isVisited);
                isVisited[i] = false;
            }
        }
    }

    private boolean canChange(String begin, String target) {
        int count = 0;

        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != target.charAt(i)) count++;
        }

        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {
        if(!List.of(words).contains(target)) return 0;

        DFS(0, begin, target, words, new boolean[words.length]);

        return minChange;
    }
}