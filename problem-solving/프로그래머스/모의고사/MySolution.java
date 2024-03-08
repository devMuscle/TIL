import java.util.*;

class Solution {
    int[][] picks = {
            {},
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}};

    public int[] solution(int[] answers) {
        int[] corrects = new int[4];

        for(int i=0; i<answers.length; i++) {
            int answer = answers[i];
            int pick1 = picks[1][i%picks[1].length];
            int pick2 = picks[2][i%picks[2].length];
            int pick3 = picks[3][i%picks[3].length];

            if(pick1 == answer) corrects[1]++;
            if(pick2 == answer) corrects[2]++;
            if(pick3 == answer) corrects[3]++;
        }

        int maxCorrect = Integer.MIN_VALUE;

        for(int i=1; i<=3; i++) {
            maxCorrect = Math.max(maxCorrect, corrects[i]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=3; i++) {
            if(corrects[i] == maxCorrect) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}