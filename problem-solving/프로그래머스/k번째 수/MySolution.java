import java.util.*;

class Solution {

    private int[] cut(int start, int end, int[] array) {
        int[] cutted = new int[end-start+1];

        for(int i=start; i<=end; i++) {
            cutted[i-start] = array[i-1];
        }

        return cutted;
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int k = command[2];

            int[] cutted = cut(start, end, array);
            Arrays.sort(cutted);

            answer[i] = cutted[k-1];
        }

        return answer;
    }
}