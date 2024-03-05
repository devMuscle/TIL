class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        char[] arr = s.toCharArray();
        boolean toUpper = true;

        for(char c : arr) {
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
                continue;
            }

            if(toUpper) {
                builder.append(Character.toUpperCase(c));
            }else {
                builder.append(Character.toLowerCase(c));
            }

            toUpper = !toUpper;
        }

        return builder.toString();
    }
}