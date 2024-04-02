class Solution {

    private static int[] answer = new int[11];
    private static int maxDiff = 0;

    private void compareInfos(int[] myInfos) {
        boolean change = false;

        for(int i = myInfos.length - 1; i >= 0; i--) {
            if(answer[i] < myInfos[i]) {
                change = true;
            }else if(answer[i] > myInfos[i]) {
                break;
            }
        }

        if(change) {
            for(int i = 0; i < myInfos.length; i++) {
                answer[i] = myInfos[i];
            }
        }
    }

    private int calculateDiff(int[] myInfos, int[] infos) {
        int lion = 0;
        int apeach = 0;

        for(int i = 0; i < infos.length; i++) {
            if(infos[i] == 0 && myInfos[i] == 0) continue;
            int score = 10 - i;

            if(myInfos[i] <= infos[i]) {
                apeach += score;
            }else {
                lion += score;
            }
        }

        return lion - apeach;
    }

    private void shoot(int n, int index, int[] myInfos, int[] infos) {
        if(n == 0) {
            int diff = calculateDiff(myInfos, infos);

            if(diff <= 0) return;

            if(diff == maxDiff) {
                compareInfos(myInfos);
            }

            if(diff > maxDiff) {
                maxDiff = diff;

                for(int i = 0; i < myInfos.length; i++) {
                    answer[i] = myInfos[i];
                }
            }

            return;
        }

        if(index >= myInfos.length) return;

        shoot(n, index + 1, myInfos, infos);
        myInfos[index]++;
        shoot(n-1, index, myInfos, infos);
        myInfos[index]--;
    }

    public int[] solution(int n, int[] infos) {
        int[] myInfos = new int[infos.length];

        shoot(n, 0, myInfos, infos);

        if(maxDiff == 0) return new int[] {-1};

        return answer;
    }
}