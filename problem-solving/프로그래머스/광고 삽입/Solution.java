import java.util.*;

class Solution {

    private static class Video {
        private final int start;
        private final int end;

        public Video(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String toHour(long seconds) {
        long hour = seconds / (60 * 60);
        long minute = (seconds % (60 * 60)) / 60;
        long second = seconds % 60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    private static int toSeconds(String time) {
        String[] arr = time.split(":");

        return Integer.parseInt(arr[0]) * 60 * 60 + Integer.parseInt(arr[1]) * 60
                + Integer.parseInt(arr[2]);
    }

    public String solution(String playTime, String advTime, String[] logs) {
        int playTimeSec = toSeconds(playTime);
        int advTimeSec = toSeconds(advTime);

        Video[] videos = Arrays.stream(logs)
                .map(log -> log.split("-"))
                .map(arr -> new Video(toSeconds(arr[0]), toSeconds(arr[1])))
                .toArray(Video[]::new);

        long[] totalTime = new long[playTimeSec + 1];

        for(Video video : videos) {
            for(int i = video.start; i < video.end; i++) {
                totalTime[i]++;
            }
        }

        for(int i = 1; i < playTimeSec; i++) {
            totalTime[i] = totalTime[i] + totalTime[i-1];
        }

        long maxTime = totalTime[advTimeSec];
        int maxTimePoint = 0;

        for (int i = advTimeSec + 1; i < playTimeSec; i++) {
            long currentTime;

            currentTime = totalTime[i] - totalTime[i - advTimeSec];

            if (currentTime > maxTime) {
                maxTime = currentTime;
                maxTimePoint = i - advTimeSec + 1;
            }
        }

        return toHour(maxTimePoint);
    }
}