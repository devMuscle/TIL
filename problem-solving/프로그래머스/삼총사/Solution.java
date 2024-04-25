class Solution {

    private int trio(int[] number, boolean[] isVisited, int cnt, int start) {
        int count = 0;

        if(cnt == 3) {
            int total = 0;

            for(int i = 0; i < isVisited.length; i++) {
                if(isVisited[i]) total += number[i];
            }

            if(total == 0)  return 1;

            return 0;
        }

        for(int i = start; i < number.length; i++) {
            if(isVisited[i]) continue;

            isVisited[i] = true;
            count += trio(number, isVisited, cnt + 1, i);
            isVisited[i] = false;
        }

        return count;
    }

    public int solution(int[] number) {
        return trio(number, new boolean[number.length], 0, 0);
    }
}