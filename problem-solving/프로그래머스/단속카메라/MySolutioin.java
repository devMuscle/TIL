import java.util.*;
import java.util.stream.*;

class Solution {

    private static class Car {
        private final int start;
        private final int end;

        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Car[] cars = new Car[routes.length];

        for(int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            cars[i] = new Car(route[0], route[1]);
        }

        Arrays.sort(cars, (c1, c2) -> c1.end - c2.end);

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < cars.length; i++) {
            Car car = cars[i];

            while(!stack.isEmpty() && stack.peek() < car.start) {
                stack.pop();
                count++;
            }

            if(stack.isEmpty()) {
                stack.push(car.end);
            }
        }

        if(!stack.isEmpty()) {
            count++;
        }

        return count;
    }
}