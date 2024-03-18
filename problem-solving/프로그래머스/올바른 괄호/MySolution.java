class Solution {
    boolean solution(String s) {
        int top = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                top++;
            }else {
                top--;
            }

            if(top < 0) return false;
        }

        if(top > 0) return false;

        return true;
    }
}