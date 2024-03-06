class Solution {

    public int countZero(String s) {
        int cnt = 0;

        for(char c : s.toCharArray()) {
            if(c == '0') cnt++;
        }

        return cnt;
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            int zeroCnt = countZero(s);

            answer[0]++;
            answer[1] += zeroCnt;

            s = Integer.toString(s.length()-zeroCnt ,2);
        }

        return answer;
    }
}