import java.util.*;

class Solution {

    private void countCase(int index, boolean[] check, String[] bannedIds,
                           List<String> bannedUserIds, Set<String> idCase) {

        if(index >= bannedIds.length) {
            StringBuilder builder = new StringBuilder();

            for(int i=0; i<bannedUserIds.size(); i++) {
                if(check[i]) {
                    builder.append(bannedUserIds.get(i));
                }
            }
            idCase.add(builder.toString());
            return;
        }

        String bannedId = bannedIds[index];

        for(int i=-0; i<bannedUserIds.size(); i++) {
            if(check[i]) continue;

            String bannedUserId = bannedUserIds.get(i);

            if(isSame(bannedUserId, bannedId)) {
                check[i] = true;
                countCase(index+1, check, bannedIds, bannedUserIds, idCase);
                check[i] = false;
            }
        }
    }

    private boolean isSame(String userId, String bannedId) {
        StringBuilder builder = new StringBuilder(userId);

        if(userId.length() != bannedId.length()) return false;

        for(int i=0; i<bannedId.length(); i++) {
            if(bannedId.charAt(i) == '*') {
                builder.setCharAt(i, '*');
            }
        }

        if(bannedId.equals(builder.toString())) return true;

        return false;
    }

    public int solution(String[] userIds, String[] bannedIds) {
        int[] cases = new int[bannedIds.length];
        boolean[] banned = new boolean[userIds.length];
        List<String> bannedUserIds = new ArrayList<>();

        for(int i=0; i<bannedIds.length; i++) {
            for(int j=0; j<userIds.length; j++) {
                if(banned[j]) continue;

                if(isSame(userIds[j], bannedIds[i])) {
                    bannedUserIds.add(userIds[j]);
                    banned[j] = true;
                }
            }

            System.out.println();
        }

        Set<String> idCase = new HashSet<>();

        countCase(0, new boolean[bannedUserIds.size()],
                bannedIds, bannedUserIds, idCase);

        return idCase.size();
    }
}