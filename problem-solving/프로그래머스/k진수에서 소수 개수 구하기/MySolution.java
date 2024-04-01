class Solution {

    private boolean isPrimeNumber(String number) {
        long n = Long.valueOf(number);

        if(n <= 1) return false;

        for(long i = 2; i*i <= n; i++) {
            if(n%i == 0) return false;
        }

        return true;
    }

    public int solution(int n, int k) {
        String number = Integer.toString(n, k);

        int count = 0;

        for(String token : number.split("0+")) {
            if(isPrimeNumber(token)) count++;
        }

        return count;
    }
}