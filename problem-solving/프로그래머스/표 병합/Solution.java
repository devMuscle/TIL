import java.util.*;

class Solution {

    private static final List<Set<String>> merged = new ArrayList<>();

    private void updateValue(String[][] chart, String value1, String value2) {
        for(int i = 0; i < chart.length; i++) {
            for(int j = 0; j < chart[i].length; j++) {
                if(chart[i][j] != null && chart[i][j].equals(value1)) {
                    chart[i][j] = value2;
                }
            }
        }
    }

    private void insertValue(String[][] chart, String y, String x, String value) {
        chart[Integer.parseInt(y)][Integer.parseInt(x)] = value;

        for(Set<String> m : merged) {
            if(m.contains(toString(Integer.parseInt(y), Integer.parseInt(x)))) {
                for(String key : m) {
                    int[] position = toPosition(key);
                    chart[position[0]][position[1]] = value;
                }
            }
        }
    }

    private String printValue(String[][] chart, String y, String x) {
        String value = chart[Integer.parseInt(y)][Integer.parseInt(x)];

        if(value == null) {
            return "EMPTY";
        }

        return value;
    }

    private int[] toPosition(String key) {
        String[] arr = key.split(",");

        return new int[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
    }

    private String toString(int y, int x) {
        return y + "," + x;
    }

    private void mergeCell(String[][] chart, String y1, String x1, String y2, String x2) {
        int r1 = Integer.parseInt(y1);
        int c1 = Integer.parseInt(x1);
        int r2 = Integer.parseInt(y2);
        int c2 = Integer.parseInt(x2);
        String value1 = chart[r1][c1];
        String value2 = chart[r2][c2];
        String value = value1;
        Set<String> m1 = null;
        Set<String> m2 = null;

        if(value1 == null && value2 != null){
            value = value2;
        }

        boolean contained = false;
        for(Set<String> m : merged) {
            if(m.contains(toString(r1,c1))) {
                m1 = m;
            }else if(m.contains(toString(r2,c2))) {
                m2 = m;
            }
        }

        if(m1 == null && m2 == null) {
            insertNewMerge(chart, r1, c1, r2, c2, value);
        }else if(m1 != null && m2 == null) {
            m1.add(toString(r2, c2));
            updateMergeValue(chart, m1, value);
        }else if(m1 == null && m2 != null){
            m2.add(toString(r1,c1));
            updateMergeValue(chart, m2, value);
        }else {
            m1.addAll(m2);
            merged.remove(m2);
            updateMergeValue(chart, m1, value);
        }

        if(m1 != null) {
            for(String key : m1) {
                int[] position = toPosition(key);
                chart[position[0]][position[1]] = value;
            }
        }

        if(m2 != null) {
            for(String key : m2) {
                int[] position = toPosition(key);
                chart[position[0]][position[1]] = value;
            }
        }
    }

    private void insertNewMerge(String[][] chart, int r1, int c1, int r2, int c2, String value) {
        Set<String> newMerge = new HashSet<>();
        newMerge.add(toString(r1,c1));
        newMerge.add(toString(r2,c2));
        merged.add(newMerge);

        chart[r1][c1] = value;
        chart[r2][c2] = value;
    }

    private void updateMergeValue(String[][] chart, Set<String> m, String value) {
        for(String key : m) {
            int[] position = toPosition(key);

            chart[position[0]][position[1]] = value;
        }
    }

    private void unMerge(String[][] chart, String r, String c) {
        for(int i = 0; i < merged.size(); i++) {
            Set<String> m = merged.get(i);

            if(m.contains(toString(Integer.parseInt(r), Integer.parseInt(c)))) {
                for(String key : m) {
                    int[] position = toPosition(key);
                    if(position[0] == Integer.parseInt(r) && position[1] == Integer.parseInt(c)) continue;
                    chart[position[0]][position[1]] = null;
                }

                merged.remove(i);
            }
        }
    }

    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        String[][] chart = new String[51][51];

        for(String command : commands) {
            String[] arr = command.split(" ");

            switch(arr[0]) {
                case "UPDATE" -> {
                    if(arr.length == 3) {
                        updateValue(chart, arr[1], arr[2]);
                    }else if(arr.length == 4) {
                        insertValue(chart, arr[1], arr[2], arr[3]);
                    }
                }

                case "MERGE" -> {
                    mergeCell(chart, arr[1], arr[2], arr[3], arr[4]);
                }

                case "UNMERGE" -> {
                    unMerge(chart, arr[1], arr[2]);
                }

                case "PRINT" -> {
                    String value = printValue(chart, arr[1], arr[2]);
                    answer.add(value);
                }
            }
        }

        return answer.toArray(String[]::new);
    }
}