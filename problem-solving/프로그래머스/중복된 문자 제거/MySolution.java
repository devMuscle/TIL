import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();

        Set<String> set = new HashSet<>();

        for(String s : my_string.split("")) {
            if(set.contains(s)) continue;

            set.add(s);
            builder.append(s);
        }

        return builder.toString();
    }
}