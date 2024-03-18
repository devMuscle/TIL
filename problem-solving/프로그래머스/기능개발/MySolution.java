import java.util.*;

class Solution {

    private int countLeftDay(int left, int speed) {
        int day = 1;

        while(day * speed < left) {
            day++;
        }

        return day;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();
        int[] leftDays = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            leftDays[i] = countLeftDay(100 - progresses[i], speeds[i]);
        }

        int count = 1;
        int curDay = leftDays[0];

        for(int i=1; i<leftDays.length; i++) {

            if(leftDays[i] > curDay) {
                curDay = leftDays[i];
                counts.add(count);
                count = 0;
            }

            count++;
        }

        if(count != 0) counts.add(count);

        return counts.stream().mapToInt(Integer::intValue).toArray();
    }
}