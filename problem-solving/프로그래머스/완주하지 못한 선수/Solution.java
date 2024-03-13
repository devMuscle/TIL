import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {

        Map<String, Integer> count = new HashMap<>();

        for(String name : participants) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for(String name : completions) {
            int v = count.get(name) - 1;
            count.put(name, v);
            if(v == 0) count.remove(name);
        }

        return count.keySet().iterator().next();
    }
}