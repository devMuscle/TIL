import java.util.*;

class Solution {

    private static class Stage {
        private final int index;
        private final double failPercent;

        public Stage(int index, double failPercent) {
            this.index = index;
            this.failPercent = failPercent;
        }
    }

    public int[] solution(int n, int[] stages) {
        int[] total = new int[n + 2];
        int[] success = new int[n + 2];

        for(int stage : stages) {
            for(int i = 1; i <= stage; i++) {
                success[i]++;
                total[i]++;
            }

            success[stage]--;
        }

        List<Stage> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            list.add(new Stage(i, 1 - (double)success[i] / total[i]));
        }

        list.sort(Comparator.comparingDouble(s -> - s.failPercent));

        return list.stream()
                .map(s -> s.index)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}