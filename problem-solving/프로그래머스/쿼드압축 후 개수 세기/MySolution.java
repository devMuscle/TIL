class Solution {

    int totalZeros = 0;
    int totalOnes = 0;

    public int countOnes(int x, int y, int len, int[][] arr) {
        int ones = 0;

        for(int i=y; i<y+len; i++) {
            for(int j=x; j<x+len; j++) {
                ones += arr[i][j];
            }
        }

        return ones;
    }

    public void compress(int x, int y, int len, int[][] arr) {
        int ones = countOnes(x, y, len, arr);
        int zeros = len*len - ones;

        if(zeros == len*len) {
            totalZeros++;
            return;
        }else if(ones == len*len) {
            totalOnes++;
            return;
        }

        compress(x, y, len/2, arr);
        compress(x+len/2, y, len/2, arr);
        compress(x, y+len/2, len/2, arr);
        compress(x+len/2, y+len/2, len/2, arr);
    }

    public int[] solution(int[][] arr) {
        compress(0,0,arr.length, arr);

        return new int[] {totalZeros, totalOnes};
    }
}