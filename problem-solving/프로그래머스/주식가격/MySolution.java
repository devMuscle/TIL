import java.util.Stack;

class Solution {

    private class Stock {
        int price;
        int index;

        Stock(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];

            while(!stack.isEmpty() && price < stack.peek().price) {
                int index = stack.pop().index;
                answer[index] = i - index;
            }

            stack.push(new Stock(price, i));
        }

        while(!stack.isEmpty()) {
            int index = stack.pop().index;
            answer[index] = (prices.length - 1) - index;
        }

        return answer;
    }
}