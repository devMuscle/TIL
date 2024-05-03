import java.util.*;
import java.util.stream.*;

class Solution {

    private int toGrade(int count) {
        if(count < 2) return 6;

        return 7 - count;
    }

    public int[] solution(int[] lottos, int[] winNums) {
        Set<Integer> lottoSet = Arrays.stream(lottos).boxed().collect(Collectors.toSet());
        Set<Integer> winNumSet = Arrays.stream(winNums).boxed().collect(Collectors.toSet());

        lottoSet.retainAll(winNumSet);

        int common = lottoSet.size();
        int zeroCount = (int)Arrays.stream(lottos).filter(n -> n == 0).count();

        return new int[] {toGrade(common + zeroCount), toGrade(common)};
    }
}