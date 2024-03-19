import java.util.*;

class Solution {

    private final boolean[][] win = new boolean[101][101];
    private final List<List<Integer>> winGraph = new ArrayList<>();
    private final List<List<Integer>> loseGraph = new ArrayList<>();

    private void makeWinList(int n, int winner, boolean[] visit,
                             List<Integer> winnerList) {
        for(int loser = 1; loser <= n; loser ++) {
            if(win[winner][loser] && visit[loser] == false) {
                winnerList.add(loser);
                visit[loser] = true;
                makeWinList(n, loser, visit, winnerList);
            }
        }
    }

    private void makeLoseList(int n, int loser, boolean[] visit,
                              List<Integer> loserList) {
        for(int winner = 1; winner <= n; winner ++) {
            if(win[winner][loser] && visit[winner] == false) {
                loserList.add(winner);
                visit[winner] = true;
                makeLoseList(n, winner, visit, loserList);
            }
        }
    }

    public int solution(int n, int[][] results) {
        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            win[winner][loser] = true;
        }

        for(int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            makeWinList(n, i, new boolean[n+1], winGraph.get(i));
            makeLoseList(n, i, new boolean[n+1], loseGraph.get(i));
        }

        int count = 0;

        for(int i = 1; i <= n; i++) {
            int gameCount = winGraph.get(i).size() + loseGraph.get(i).size();

            if(gameCount == (n - 1)) count++;
        }

        return count;
    }
}