class Solution {

    private void DFS(int cur, boolean[] visited, int[][] computers) {
        for(int i = 0; i < computers[cur].length; i++) {
            if(computers[cur][i] == 0 || visited[i]) continue;

            visited[i] = true;
            DFS(i, visited, computers);
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0 ; i < computers.length; i++) {
            if(visited[i]) continue;
            count++;

            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 0) continue;

                DFS(i, visited, computers);
            }
        }

        return count;
    }
}