import java.util.*;

class Solution {
    public String solution(String xStr, String yStr) {
        char[] xArr = xStr.toCharArray();
        char[] yArr = yStr.toCharArray();

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int xIndex = 0;
        int yIndex = 0;

        StringBuilder builder = new StringBuilder();

        while(xIndex != xArr.length && yIndex != yArr.length) {
            char x = xArr[xIndex];
            char y = yArr[yIndex];

            if(x == y) {
                builder.append(x);
                xIndex++;
                yIndex++;
            }else if(x > y) {
                yIndex++;
            }else if(x < y) {
                xIndex++;
            }
        }

        if(builder.length() == 0) return "-1";

        String answer = builder.reverse().toString();
        if(answer.matches("0+")) return "0";

        return answer;
    }
}