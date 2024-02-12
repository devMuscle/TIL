import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        Map<Character, Integer> termsMap = new HashMap<>();

        for(String term : terms) {
            termsMap.put(term.charAt(0), Integer.parseInt(term.substring(2,
                    term.length())));
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, format);

        for(int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            LocalDate privacyDate = LocalDate.parse(privacy.substring(0,
                    privacy.length()-2) , format);
            Character privacyTerm = privacy.charAt(privacy.length()-1);

            LocalDate privacyEndDate = privacyDate.plusMonths(
                    termsMap.get(privacyTerm)).minusDays(1);

            if(privacyEndDate.isBefore(todayDate)) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}