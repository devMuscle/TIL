import java.util.*;

class Solution {

    private static final int INF = 200 * 100000 + 1;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] minMatrix = new int[n + 1][n + 1];

        for(int[] m : minMatrix) {
            Arrays.fill(m, INF);
        }

        for(int i = 0; i <= n; i++) {
            minMatrix[i][i] = 0;
        }

        for(int[] fare : fares) {
            int node1 = fare[0];
            int node2 = fare[1];
            int cost = fare[2];

            minMatrix[node1][node2] = cost;
            minMatrix[node2][node1] = cost;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    minMatrix[i][j] = Math.min(minMatrix[i][j],
                            minMatrix[i][k] + minMatrix[k][j]);
                }
            }
        }

        int minDistance = minMatrix[s][a] + minMatrix[s][b];

        for(int i = 1; i <= n; i++) {
            int totalDistance = minMatrix[s][i] + minMatrix[i][a] + minMatrix[i][b];
            minDistance = Math.min(minDistance, totalDistance);
        }

        return minDistance;
    }
}