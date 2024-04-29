import java.util.*;

class Solution {

    private void turn(int[][] key) {
        int[][] copy = new int[key.length][key.length];

        for(int i = 0; i < key.length; i++) {
            int[] row = key[i];
            copy[i] = Arrays.copyOf(row, copy[i].length);
            Arrays.fill(row, 0);
        }

        for(int i = 0; i < copy.length; i++) {
            for(int j = 0; j < copy[i].length; j++) {
                key[j][key.length - 1 - i] = copy[i][j];
            }
        }
    }

    private void match(int[][] largeLock, int[][] key, int r, int c) {
        int m = key.length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                largeLock[r + i][c + j] += key[i][j];
            }
        }
    }

    private boolean check(int[][] arr, int offset, int n) {
        for(int i = offset; i < offset + n; i++) {
            for(int j = offset; j < offset + n; j++) {
                if(arr[i][j] != 1) return false;
            }
        }

        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;

        for(int rot = 0; rot < 4; rot++) {
            turn(key);

            for(int r = 0; r < offset + lock.length; r++) {
                for(int c = 0; c < offset + lock.length; c++) {
                    int[][] largeLock = new int[58][58];

                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            largeLock[offset + i][offset + j] = lock[i][j];
                        }
                    }

                    match(largeLock, key, r, c);

                    if(check(largeLock, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }
}