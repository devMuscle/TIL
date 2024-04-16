import java.util.*;

class Solution {

    private static class Position {
        private int y;
        private int x;
        private int step;
        private final StringBuilder sentence;

        public Position(int y, int x, int step, StringBuilder sentence) {
            this.y = y;
            this.x = x;
            this.step = step;
            this.sentence = sentence;
        }

        public int distanceFrom(int r, int c) {
            return Math.abs(y-r) + Math.abs(x-c);
        }
    }

    private static final char[] direction = {'d', 'l', 'r', 'u'};
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {1, 0, 0, -1};
    private static String answer = null;

    private static void DFS(Position cur, int n, int m, int r, int c, int k) {
        if(answer != null) return;
        if(cur.step + cur.distanceFrom(r,c) > k) return;

        if(cur.step == k && cur.distanceFrom(r,c) == 0) {
            answer = cur.sentence.toString();
            return;
        }

        int curX = cur.x;
        int curY = cur.y;

        for(int d = 0; d < 4; d++) {
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];

            if(nx > 0 && nx <= m && ny > 0 && ny <= n) {
                cur.x = nx;
                cur.y = ny;
                cur.step += 1;
                cur.sentence.append(direction[d]);

                DFS(cur, n, m, r, c, k);

                cur.x = curX;
                cur.y = curY;
                cur.step -= 1;
                cur.sentence.deleteCharAt(cur.sentence.length() - 1);
            }
        }
    }

    public String solution(int n, int m, int y, int x, int r, int c, int k) {

        Position cur = new Position(y, x, 0, new StringBuilder());
        int distance = cur.distanceFrom(r, c);
        if((k - distance) % 2 == 1 || k < distance) return "impossible";

        DFS(cur, n, m, r, c, k);
        if(answer == null) return "impossible";

        return answer;
    }
}