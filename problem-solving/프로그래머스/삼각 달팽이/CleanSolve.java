class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[] dx = {0,1,-1};
        int[] dy = {1,0,-1};

        int[][] arr = new int[n][n];

        int curY = 0;
        int curX = 0;
        int cnt = 1;
        int d=0;

        while(true) {
            arr[curY][curX] = cnt++;
            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if(nx == n || ny == n || arr[ny][nx] != 0) {
                d = (d+1)%3;
                nx = curX + dx[d];
                ny = curY + dy[d];

                if(nx == n || ny == n || arr[ny][nx] != 0) break;
            }

            curX = nx;
            curY = ny;
        }

        answer = new int[cnt-1];
        int index=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[index]=arr[i][j];
                index++;
            }
        }

        return answer;
    }
}