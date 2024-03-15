import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        for(int i=0; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                dp[i][j] = triangle[i][j];
            }
        }

        for(int i=0; i<triangle.length-1; i++) {
            for(int j=0; j<=i; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j],
                        dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],
                        dp[i][j] + triangle[i+1][j+1]);
            }
        }

        int answer = 0;

        for(int num : dp[dp.length-1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }
}