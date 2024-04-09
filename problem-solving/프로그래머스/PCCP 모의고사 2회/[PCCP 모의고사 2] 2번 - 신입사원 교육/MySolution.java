import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : ability) {
            pq.add(a);
        }

        while(number-- > 0) {
            int worker1 = pq.poll();
            int worker2 = pq.poll();

            pq.add(worker1 + worker2);
            pq.add(worker1 + worker2);
        }

        return pq.stream().mapToInt(Integer::intValue).sum();
    }
}