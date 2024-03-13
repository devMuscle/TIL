import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Arrays.sort(participants);
        Arrays.sort(completions);

        int i = 0;
        for(i=0; i<completions.length; i++) {
            if(!participants[i].equals(completions[i])) return participants[i];
        }

        return participants[i];
    }
}