class Solution {
    public int[] solution(int n) {
        int[] answer = {};

        int[][] arr = new int[n][n];

        int curY = 0;
        int curX = 0;
        int cnt = 1;

        for(int i=0; i<n; i++) {
            int tempY = curY;
            int tempX = curX;

            if(i%3==0) {
                for(curY=tempY; curY<n; curY++) {
                    if(arr[curY][curX] != 0) {
                        break;
                    }

                    arr[curY][curX] = cnt;
                    cnt++;
                }

                curY--;
                curX++;

            }else if(i%3==1) {
                for(curX=tempX; curX<n; curX++) {
                    if(arr[curY][curX] != 0) {
                        break;
                    }

                    arr[curY][curX] = cnt;
                    cnt++;
                }

                curX-=2;
                curY--;

            }else if(i%3==2) {
                while(arr[curY][curX] == 0) {
                    arr[curY][curX] = cnt;
                    cnt++;

                    curX--;
                    curY--;
                }

                curX++;
                curY+=2;
            }
        }

        answer = new int[cnt-1];
        int index=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j]!=0) {
                    answer[index]=arr[i][j];
                    index++;
                    continue;
                }

                break;
            }
        }

        return answer;
    }
}