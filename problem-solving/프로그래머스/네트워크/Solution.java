import java.util.Stack;

class Solution {

    private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);

        while(!stack.isEmpty()) {
            int c = stack.pop();

            if(isVisited[c]) continue;
            isVisited[c] = true;

            for(int next = 0; next < computers[c].length; next++) {
                if(computers[c][next] == 0) continue;
                stack.push(next);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(isVisited[i]) continue;
            visitAll(i, computers, isVisited);
            answer++;
        }

        return answer;
    }
}