class Solution {

    public String solution(String newId) {
        //1
        newId = newId.toLowerCase();
        //2
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        //3
        newId = newId.replaceAll("\\.+", ".");
        //4
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        //5
        if(newId.isEmpty()) newId = "a";
        //6
        if(newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }
        //7
        while(newId.length() < 3) {
            newId += newId.charAt(newId.length()-1);
        }

        return newId;
    }
}