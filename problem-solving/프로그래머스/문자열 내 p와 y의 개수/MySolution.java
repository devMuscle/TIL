class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();

        long pCount = s.chars().filter(x -> x=='P').count();
        long yCount = s.chars().filter(x -> x=='Y').count();

        if(pCount != yCount) answer = false;

        return answer;
    }
}