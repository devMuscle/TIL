import java.util.*;

class Solution {

    private static final char[][] PRIORITIES = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '-', '+'},
            {'*', '+', '-'}
    };

    private long calculate(long num1, long num2, char operator) {
        return switch(operator) {
            case '+' ->  num1 + num2;
            case '-' ->  num1 - num2;
            case '*' ->  num1 * num2;
            default -> 0L;
        };
    }

    private long operate(int index, List<Long> operands, List<Character> operators) {
        final char[] priority = PRIORITIES[index];

        for(char operator : priority) {
            for(int i=0; i < operators.size(); i++) {
                if(operator == operators.get(i)) {
                    long result = calculate(operands.get(i), operands.get(i+1),
                            operator);
                    operators.remove(i);
                    operands.remove(i);
                    operands.set(i, result);
                    i--;
                }
            }
        }

        return Math.abs(operands.get(0));
    }

    private void extract(String expression, List<Long> operands,
                         List<Character> operators) {
        int start = 0;
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);

            if(c == '-' || c == '+' || c == '*') {
                operators.add(c);
                operands.add(Long.valueOf(expression.substring(start, i)));

                start = i+1;
            }
        }

        operands.add(Long.valueOf(expression.substring(start,
                expression.length())));
    }

    public long solution(String expression) {
        long answer = 0;
        List<Long> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        extract(expression, operands, operators);

        for(int index=0; index<PRIORITIES.length; index++) {
            long result = operate(index, new ArrayList<>(operands),
                    new ArrayList<>(operators));
            answer = Math.max(answer, result);
        }

        return answer;
    }
}