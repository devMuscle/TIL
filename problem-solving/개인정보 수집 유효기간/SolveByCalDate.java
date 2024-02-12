import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> termsMap = new HashMap<>();

        for(String term : terms) {
            String[] termArr = term.split(" ");

            termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        int daysInToday = calDays(today);

        for(int i=0; i<privacies.length; i++) {
            String[] privacyArr = privacies[i].split(" ");
            int daysInEndDate = calDays(privacyArr[0]) +
                    termsMap.get(privacyArr[1]) * 28;

            if(daysInToday >= daysInEndDate) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int calDays(String date) {
        String[] dateArr = date.split("\\.");
        int daysInYear = Integer.parseInt(dateArr[0])*12*28;
        int daysInMonth = Integer.parseInt(dateArr[1])*28;
        int daysInday = Integer.parseInt(dateArr[2]);

        return daysInYear + daysInMonth + daysInday;
    }
}