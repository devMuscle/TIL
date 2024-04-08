import java.util.*;

class Solution {

    private static class Program {
        public final int score;
        public final int start;
        public final int time;

        public Program(int score, int start, int time) {
            this.score = score;
            this.start = start;
            this.time = time;
        }
    }

    public long[] solution(int[][] programs) {
        long[] answer = new long[11];

        PriorityQueue<Program> left = new PriorityQueue<>((p1, p2) -> {
            return p1.start - p2.start;
        });

        for(int[] pro : programs) {
            Program program = new Program(pro[0], pro[1], pro[2]);
            left.add(program);
        }

        PriorityQueue<Program> progressing = new PriorityQueue<>((p1, p2) -> {
            if(p1.score == p2.score) {
                return p1.start - p2.start;
            }

            return p1.score - p2.score;
        });

        long now = 0;

        while(!left.isEmpty()) {
            while(!left.isEmpty() && left.peek().start <= now) {
                Program newProgram = left.poll();
                progressing.add(newProgram);
            }

            if(!progressing.isEmpty() && progressing.peek().start <= now) {
                Program endProgram = progressing.poll();

                answer[endProgram.score] += (now - endProgram.start);
                now += endProgram.time;
                continue;
            }

            now++;
        }

        while(!progressing.isEmpty()) {
            Program endProgram = progressing.poll();
            answer[endProgram.score] += (now - endProgram.start);
            now += endProgram.time;
        }

        answer[0] = now;

        return answer;
    }
}