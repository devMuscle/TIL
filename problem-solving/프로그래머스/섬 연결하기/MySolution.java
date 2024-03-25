import java.util.*;

class Solution {

    public int solution(int n, int[][] rawCosts) {
        int[][] costs = new int[n][n];
        Set<Integer> islands = new HashSet<>();

        for(int[] rawCost : rawCosts) {
            int land1 = rawCost[0];
            int land2 = rawCost[1];
            int cost = rawCost[2];

            costs[land1][land2] = cost;
            costs[land2][land1] = cost;
        }

        islands.add(0);
        int cost = 0;

        while(islands.size() != n) {
            int dest = 0;
            int minCost = Integer.MAX_VALUE;

            for(int island : islands) {
                for(int i = 0; i < n; i ++) {
                    if(costs[island][i] == 0) continue;
                    if(islands.contains(i)) continue;

                    if(costs[island][i] < minCost) {
                        minCost = costs[island][i];
                        dest = i;
                    }
                }
            }

            islands.add(dest);
            cost += minCost;
        }

        return cost;
    }
}