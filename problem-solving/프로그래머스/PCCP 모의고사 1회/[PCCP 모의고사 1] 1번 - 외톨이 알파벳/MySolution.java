class Solution {
    public String solution(String input) {
        StringBuilder builder = new StringBuilder();
        String change = input.replaceAll("a+", " ");

        for(char c = 'a'; c <= 'z'; c++) {
            String pattern = c + "+";

            String replaced = input.replaceAll(pattern, " ");
            int count = 0;

            for(char s : replaced.toCharArray()) {
                if(s == ' ') count++;
            }

            if(count >= 2) {
                builder.append(c);
            }
        }

        if(builder.length() == 0) return "N";

        return builder.toString();
    }
}