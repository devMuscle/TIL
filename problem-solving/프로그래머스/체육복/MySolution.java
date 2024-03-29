import java.util.*;

class Solution {

    private void mark(int reserve, int[] losts, boolean[] check) {
        for(int i = 0; i < losts.length; i++) {
            int lost = losts[i];

            if(reserve == lost) {
                check[i] = true;
                return;
            }
        }

        int front = reserve - 1;
        int back = reserve + 1;

        for(int i = 0; i < losts.length; i++) {
            if(check[i]) continue;

            int lost = losts[i];

            if(lost == front || lost == back) {
                check[i] = true;
                break;
            }
        }
    }

    public int solution(int n, int[] losts, int[] reserves) {
        Arrays.sort(losts);
        Arrays.sort(reserves);

        boolean[] check = new boolean[losts.length];

        for(int reserve : reserves) {
            mark(reserve, losts, check);
        }

        for(boolean c : check) {
            if(c == false) n--;
        }

        return n;
    }
}