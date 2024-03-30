class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);

        for(int i = 0; i < builder.length() - 1; i++) {
            if(k == 0) break;

            if(builder.charAt(i) < builder.charAt(i+1)) {
                builder.deleteCharAt(i);
                k--;

                for(int j = i-1; j >= 0; j--) {
                    if(builder.charAt(i) > builder.charAt(j)) {
                        i = j;
                        break;
                    }
                }

                i--;
            }
        }

        if(k > 0) builder.delete(builder.length() - k, builder.length());

        return builder.toString();
    }
}