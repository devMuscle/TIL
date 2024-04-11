class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long totalDistance = 0;

        int dIndex = deliveries.length - 1;
        while(dIndex >= 0) {
            if(deliveries[dIndex] != 0) break;
            dIndex--;
        };

        int pIndex = pickups.length - 1;
        while(pIndex >= 0) {
            if(pickups[pIndex] != 0) break;
            pIndex--;
        };

        while(dIndex != -1 || pIndex != -1) {
            int distance = (Math.max(dIndex, pIndex) + 1);
            totalDistance += 2 * distance;

            int delivery = cap;

            while(dIndex >= 0 && deliveries[dIndex] <= delivery) {
                delivery -= deliveries[dIndex];
                deliveries[dIndex] = 0;
                dIndex--;
            }

            if(delivery > 0 && dIndex >= 0) {
                deliveries[dIndex] -= delivery;
                delivery = 0;
            }

            int pickup = cap;

            while(pIndex >= 0 && pickups[pIndex] <= pickup) {
                pickup -= pickups[pIndex];
                pickups[pIndex] = 0;
                pIndex--;
            }

            if(pickup > 0 && pIndex >= 0) {
                pickups[pIndex] -= pickup;
                pickup = 0;
            }
        }

        return totalDistance;
    }
}