class Solution {

    private String second(String newId) {
        StringBuilder builder = new StringBuilder();

        for(char c : newId.toCharArray()) {
            if(Character.isDigit(c) || Character.isAlphabetic(c)
                    || c == '-' || c == '_' || c == '.') {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    private String third(String newId) {
        StringBuilder builder = new StringBuilder();
        char last = ' ';

        for(char c : newId.toCharArray()) {
            if(c != '.') {
                if(last == '.') builder.append(".");

                builder.append(c);
            }

            last = c;
        }

        if(last == '.') builder.append(".");

        return builder.toString();
    }

    private String fourth(String newId) {
        StringBuilder builder = new StringBuilder(newId);

        if(builder.charAt(0) == '.') builder.deleteCharAt(0);

        if(builder.length() == 0) return builder.toString();

        if(builder.charAt(builder.length()-1) == '.') builder.deleteCharAt(builder.length()-1);

        return builder.toString();
    }

    public String fifth(String newId) {
        if(newId.equals("")) return "a";

        return newId;
    }

    public String sixth(String newId) {
        int end = Math.min(15, newId.length());
        newId = newId.substring(0, end);

        if(newId.charAt(newId.length()-1)=='.') {
            return newId.substring(0, newId.length()-1);
        }

        return newId;
    }

    public String seventh(String newId) {
        if(newId.length() > 2) {
            return newId;
        }

        StringBuilder builder = new StringBuilder(newId);
        char last = builder.charAt(builder.length()-1);

        while(builder.length() < 3) {
            builder.append(last);
        }

        return builder.toString();
    }

    public String solution(String newId) {
        newId = second(newId.toLowerCase());
        newId = third(newId);
        newId = fourth(newId);
        newId = fifth(newId);
        newId = sixth(newId);

        return seventh(newId);
    }
}