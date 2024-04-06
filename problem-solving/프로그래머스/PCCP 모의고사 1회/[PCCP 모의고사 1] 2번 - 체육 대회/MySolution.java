class Solution {

    private static int result = 0;

    private void game(int[][] ability, boolean[] visited, int score, int player) {
        if(player == ability.length) {
            result = Math.max(result, score);
            return;
        }

        game(ability, visited, score, player + 1);

        for(int i = 0; i < ability[player].length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            game(ability, visited, score + ability[player][i], player + 1);
            visited[i] = false;
        }
    }

    public int solution(int[][] ability) {
        game(ability, new boolean[ability[0].length], 0, 0);
        return result;
    }
}