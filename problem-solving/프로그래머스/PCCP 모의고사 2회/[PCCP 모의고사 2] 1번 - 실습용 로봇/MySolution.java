class Solution {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static class Robot {
        public int x;
        public int y;
        public int d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public void move(char command) {
            switch(command) {
                case 'R' :
                    d = (d + 1) % 4;
                    break;
                case 'L' :
                    d = (d + 3) % 4;
                    break;
                case 'G' :
                    x += dx[d];
                    y += dy[d];
                    break;
                case 'B' :
                    int backD = (d + 2) % 4;
                    x += dx[backD];
                    y += dy[backD];
                    break;
            }
        }
    }

    public int[] solution(String commands) {
        Robot robot = new Robot(0,0,0);

        for(char command : commands.toCharArray()) {
            robot.move(command);
        }

        return new int[] {robot.x, robot.y};
    }
}