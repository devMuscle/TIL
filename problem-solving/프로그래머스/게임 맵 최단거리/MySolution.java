import java.util.*;

class Solution {

    private static class State {
        public final int x;
        public final int y;
        public final int step;

        public State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    private static final int[] dx = {0,0,1,-1,};
    private static final int[] dy = {-1,1,0,0};

    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));
        isVisited[0][0] = true;

        while(!queue.isEmpty()) {
            State cur = queue.poll();

            if(cur.x == (maps[0].length - 1) && cur.y == (maps.length - 1)) {
                return cur.step;
            }

            for(int i = 0 ; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length) {
                    continue;
                }

                if(isVisited[ny][nx]) continue;

                if(maps[ny][nx] == 0) continue;

                queue.add(new State(nx, ny, cur.step + 1));
                isVisited[ny][nx] = true;
            }
        }

        return -1;
    }
}