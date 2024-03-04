import java.util.*;

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> points = new ArrayList<>();

        for(int i=0; i<line.length; i++) {
            for(int j=i+1; j<line.length; j++) {
                Point point = intersection(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
                if(point != null) {
                    points.add(point);
                }
            }
        }

        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);

        int width = (int)(maxPoint.x - minPoint.x + 1);
        int height = (int)(maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];

        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for(Point p : points) {
            int x = (int)(p.x - minPoint.x);
            int y = (int)(maxPoint.y - p.y);

            arr[y][x] = '*';
        }

        answer = new String[arr.length];

        for(int i=0; i<arr.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }

    public Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point point : points) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }

        return new Point(x,y);
    }

    public Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point point : points) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }

        return new Point(x,y);
    }

    public Point intersection(long a, long b, long e, long c, long d, long f) {
        if((a*d - b*c) == 0) {
            return null;
        }

        double x = (double)(b*f - e*d)/(a*d - b*c);
        double y = (double)(e*c - a*f)/(a*d - b*c);

        if(x%1 != 0 || y%1 != 0) {
            return null;
        }

        return new Point((long) x,(long) y);
    }
}