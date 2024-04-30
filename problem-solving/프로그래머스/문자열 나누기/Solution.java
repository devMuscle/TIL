import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(start < s.length()) {
            char first = s.charAt(start);

            for(int i = start; i < s.length(); i++) {
                char c = s.charAt(i);

                map.put(c, map.getOrDefault(c, 0) + 1);

                int left = i - start + 1 - map.get(first);

                if(left == map.get(first)) {
                    count++;
                    start = i + 1;
                    map.clear();
                    break;
                }else if(left != map.get(first) && i == s.length() - 1) {
                    return count + 1;
                }
            }
        }

        return count;
    }
}