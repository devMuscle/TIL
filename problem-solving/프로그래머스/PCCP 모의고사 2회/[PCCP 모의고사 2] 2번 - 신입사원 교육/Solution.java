import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = Arrays.stream(ability)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        for(int i = 0 ; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a+b);
            pq.add(a+b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }
}