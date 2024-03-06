class Solution {
    public boolean solution(String s) {

        for(char c : s.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }

        return s.length() == 4 || s.length() == 6;
    }
}