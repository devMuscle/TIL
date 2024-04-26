import java.util.*;

class Solution {

    private static final int INF = 16 * 6 * 2;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static int[][] board;

    private static class Position {
        int y;
        int x;
        int step;

        public Position(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

    private int bfs(Position start, Position end) {
        boolean[][] visited = new boolean[4][4];
        Queue<Position> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            Position cur = q.poll();
            if(cur.y == end.y && cur.x == end.x) return cur.step;

            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(nx < 0 || nx > 3 || ny < 0 || ny > 3) continue;

                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Position(ny, nx, cur.step + 1));
                }

                for(int j = 0; j < 2; j++) {
                    if(board[ny][nx] != 0) break;
                    if(ny + dy[d] < 0 || ny + dy[d] > 3 || nx + dx[d] < 0 || nx + dx[d] > 3) break;

                    ny += dy[d];
                    nx += dx[d];
                }

                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Position(ny, nx, cur.step + 1));
                }
            }
        }

        return INF;
    }

    private int search(Position cur) {
        int distance = INF;

        for(int val = 1; val <= 6; val++) {
            List<Position> cards = new ArrayList<>();

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(board[i][j] == val) {
                        cards.add(new Position(i, j, 0));
                    }
                }
            }

            if(!cards.isEmpty()) {
                int first = bfs(cur, cards.get(0)) + bfs(cards.get(0), cards.get(1)) + 2;
                int second = bfs(cur, cards.get(1)) + bfs(cards.get(1), cards.get(0)) + 2;

                for(Position card : cards) {
                    board[card.y][card.x] = 0;
                }

                distance = Math.min(distance, first + search(cards.get(1)));
                distance = Math.min(distance, second + search(cards.get(0)));

                for(Position card : cards) {
                    board[card.y][card.x] = val;
                }
            }
        }

        if(distance == INF) return 0;

        return distance;
    }

    public int solution(int[][] b, int r, int c) {
        board = b;
        return search(new Position(r,c,0));
    }
}