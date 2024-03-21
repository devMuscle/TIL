import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> distinctGems = new HashSet<>();

        for(String gem : gems) {
            distinctGems.add(gem);
        }

        int s = 0;
        int e = gems.length - 1;

        int start = 0;
        int end = 0;

        Map<String, Integer> gemCount = new HashMap<>();
        gemCount.put(gems[0], 1);

        while(start <= end) {
            if(gemCount.keySet().size() == distinctGems.size()) {
                if(end - start < e - s) {
                    s = start;
                    e = end;
                }

                int left = gemCount.get(gems[start]) - 1;
                if(left == 0) {
                    gemCount.remove(gems[start]);
                }else {
                    gemCount.put(gems[start], left);
                }
                start++;
            }else {
                end++;

                if(end == gems.length) break;

                gemCount.putIfAbsent(gems[end], 0);
                gemCount.put(gems[end], gemCount.get(gems[end])+1);
            }
        }

        return new int[] {s+1, e+1};
    }
}