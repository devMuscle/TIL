import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }
}