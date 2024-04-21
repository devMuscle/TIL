class Solution {

    private boolean isCorrectString(String s) {
        int top = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                top++;
            }else {
                top--;
            }

            if(top < 0) return false;
        }

        return top == 0;
    }

    private String toCorrectString(String s) {
        if(isCorrectString(s)) return s;

        int top = 0;
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                top++;
            }else {
                top--;
            }

            if(top == 0) {
                String u = s.substring(0, i + 1);
                String v = s.substring(i + 1);

                if(isCorrectString(u)) {
                    builder.append(u);
                    builder.append(toCorrectString(v));
                }else {
                    builder.append('(');
                    builder.append(toCorrectString(v));
                    builder.append(')');

                    for(int j = 1; j < u.length() - 1; j++) {
                        char ch = u.charAt(j);

                        if(ch == '(') {
                            builder.append(')');
                        }else {
                            builder.append('(');
                        }
                    }
                }

                break;
            }
        }

        return builder.toString();
    }

    public String solution(String p) {

        return toCorrectString(p);
    }
}