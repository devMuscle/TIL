import java.util.*;

class Solution {

    private void delete(List<Integer> trash, PriorityQueue<Integer> PQ) {
        while(!PQ.isEmpty() && trash.contains(PQ.peek())) {
            PQ.poll();
        }

        if(!PQ.isEmpty()) {
            trash.add(PQ.poll());
        }
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascending = new PriorityQueue<>();
        PriorityQueue<Integer> descending = new PriorityQueue<>((a1, a2) -> a2 - a1);
        List<Integer> trash = new ArrayList<>();

        for(String operation : operations) {
            String[] op = operation.split(" ");

            switch(op[0]) {
                case "I" -> {
                    int num = Integer.parseInt(op[1]);
                    ascending.add(num);
                    descending.add(num);
                }
                case "D" -> {
                    if(op[1].equals("1")) {
                        if(descending.isEmpty()) {
                            delete(trash, ascending);
                        }else {
                            delete(trash, descending);
                        }
                    }else {
                        if(ascending.isEmpty()) {
                            delete(trash, descending);
                        }else {
                            delete(trash, ascending);
                        }
                    }
                }
            }
        }

        Set<Integer> left1 = new HashSet<>();
        while(!ascending.isEmpty()) {
            left1.add(ascending.poll());
        }

        Set<Integer> left2 = new HashSet<>();
        while(!descending.isEmpty()) {
            left2.add(descending.poll());
        }

        left1.retainAll(left2);

        int min = left1.stream().min(Integer::compareTo).orElse(0);
        int max = left1.stream().max(Integer::compareTo).orElse(0);

        return new int[] {max, min};
    }
}