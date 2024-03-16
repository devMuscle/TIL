import java.util.*;

class Solution {

    private final int[][] mem = new int[101][101];

    private int move(int y, int x) {
        if(y <= 0 || x <= 0) return 0;
        if(y==1 && x==1) return mem[y][x] = 1;

        if(mem[y][x] == -1) {
            mem[y][x] = (move(y, x-1) + move(y-1, x)) % 1000000007;
            return mem[y][x];
        }

        return mem[y][x];
    }

    public int solution(int m, int n, int[][] puddles) {
        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }

        for(int[] puddle : puddles) {
            mem[puddle[1]][puddle[0]] = 0;
        }

        return move(n,m);
    }
}