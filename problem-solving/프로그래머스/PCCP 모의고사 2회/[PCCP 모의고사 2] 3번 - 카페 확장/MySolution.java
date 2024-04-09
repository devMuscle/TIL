import java.util.*;

class Solution {

    private static class Order {
        private final int start;
        private final int time;

        public Order(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;

        int index = 0;
        Queue<Order> q = new LinkedList<>();
        int time = 0;
        int result = 0;

        while(index < order.length) {
            if(!q.isEmpty() && (q.peek().start + q.peek().time) == time) {
                q.poll();
            }

            int arriveTime = index * k;

            if(index * k <= time) {
                int waitTime = 0;

                for(Order o : q) {
                    waitTime += o.time;
                }

                if(waitTime == 0) {
                    waitTime = time;
                }else {
                    waitTime += q.peek().start;
                }

                q.add(new Order(waitTime, menu[order[index]]));
                index++;
            }

            result = Math.max(result, q.size());

            time++;
        }

        return result;
    }
}