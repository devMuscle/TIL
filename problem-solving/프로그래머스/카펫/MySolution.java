class Solution {

    public int[] solution(int targetBrown, int targetYellow) {
        int x = 0;
        int y = 0;

        for(int yellowY = 1; yellowY <= targetYellow; yellowY++) {
            for(int yellowX = 1; yellowX <= targetYellow; yellowX++) {
                int yellow = yellowX*yellowY;
                int brown = (yellowX + 2) * 2 + yellowY * 2;

                if(brown == targetBrown && yellow == targetYellow) {
                    x = yellowX + 2;
                    y = yellowY + 2;

                    return new int[] {x, y};
                }
            }
        }

        return new int[] {x, y};
    }
}