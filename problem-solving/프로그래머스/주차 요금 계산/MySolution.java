import java.util.*;
import java.util.stream.*;

class Solution {

    private static class Record {
        private final String enterTime;
        private String leaveTime = "23:59";

        public Record(String enterTime) {
            this.enterTime = enterTime;
        }
    }

    private int toMinute(String time) {
        String[] timeArr = time.split(":");

        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }

    private int calculateFee(List<Record> recordList, int[] fees) {
        int fee = fees[1];
        int totalTime = 0;

        for(Record record : recordList) {
            totalTime += toMinute(record.leaveTime) - toMinute(record.enterTime);
        }

        totalTime -= fees[0];

        if(totalTime > 0) {
            fee += Math.ceil((double)totalTime/fees[2]) * fees[3];
        }

        return fee;
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Record>> parking = new HashMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] recordArr = records[i].split(" ");
            String time = recordArr[0];
            String car = recordArr[1];
            String move = recordArr[2];

            switch(move) {
                case "IN" -> {
                    parking.putIfAbsent(car, new ArrayList<>());
                    parking.get(car).add(new Record(time));
                }

                case "OUT" -> {
                    List<Record> recordList = parking.get(car);
                    recordList.get(recordList.size()-1).leaveTime = time;
                }
            }
        }

        List<String> cars = new ArrayList<>(parking.keySet());
        Collections.sort(cars);

        int[] result = new int[cars.size()];

        for(int i = 0; i < cars.size(); i++){
            String car = cars.get(i);
            List<Record> recordList = parking.get(car);

            result[i] = calculateFee(recordList, fees);
        }

        return result;
    }
}