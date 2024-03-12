class Solution {

    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000L * 1000000000L;

        while(start < end) {
            long mid = (start + end) / 2;
            long count = 0;

            for(int time : times) {
                count += mid/time;
            }

            if(count >= n) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }
}