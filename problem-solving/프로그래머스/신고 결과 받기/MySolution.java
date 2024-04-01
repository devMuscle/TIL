import java.util.*;

class Solution {

    public int[] solution(String[] idList, String[] reports, int k) {
        Map<String, Set<String>> receiver = new HashMap<>();
        Map<String, Set<String>> provider = new HashMap<>();

        for(String report : reports) {
            String[] reportArr = report.split(" ");

            receiver.putIfAbsent(reportArr[1], new HashSet<>());
            receiver.get(reportArr[1]).add(reportArr[0]);

            provider.putIfAbsent(reportArr[0], new HashSet<>());
            provider.get(reportArr[0]).add(reportArr[1]);
        }

        int[] counts = new int[idList.length];

        for(int i = 0; i < idList.length; i++) {
            for(String sued : provider.getOrDefault(idList[i], new HashSet<>())) {
                if(receiver.get(sued).size() >= k) {
                    counts[i]++;
                }
            }
        }

        return counts;
    }
}