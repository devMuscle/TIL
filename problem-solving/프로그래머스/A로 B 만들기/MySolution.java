import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> alphabets = new HashMap<>();

        for(char c : before.toCharArray()) {
            alphabets.putIfAbsent(c, 0);
            alphabets.put(c, alphabets.get(c)+1);
        }

        for(char c : after.toCharArray()) {
            if(alphabets.containsKey(c)) {
                if(alphabets.get(c) > 0) {
                    alphabets.put(c, alphabets.get(c)-1);
                    continue;
                }

                return 0;
            }
        }

        for(int val : alphabets.values()) {
            if(val != 0) return 0;
        }

        return 1;
    }
}