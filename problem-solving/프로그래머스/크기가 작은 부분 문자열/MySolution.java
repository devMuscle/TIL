class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for(int i = 0; i <= t.length() - p.length(); i++) {
            String prefix = t.substring(i, i + p.length());

            if(Long.parseLong(prefix) <= Integer.parseInt(p)) answer++;
        }

        return answer;
    }
}