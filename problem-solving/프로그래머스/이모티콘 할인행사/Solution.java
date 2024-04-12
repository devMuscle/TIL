import java.util.*;
import java.util.stream.*;

class Solution {

    private static class Emoticon {
        private int discountPercent;
        private final int cost;
        private int currentPrice;

        public Emoticon(int discountPercent, int cost) {
            this.discountPercent = discountPercent;
            this.cost = cost;
            updateCurrentPrice();
        }

        public void updateCurrentPrice() {
            currentPrice = (int)(cost * (100 - discountPercent)/100);
        }
    }

    private int[] discountPolicy(int index, Emoticon[] arr, int[][] users) {
        int plusCount = 0;
        int totalPrice = 0;

        if(index == arr.length) {
            for(int[] user : users) {
                int boughtPrice = 0;

                for(Emoticon emoticon : arr) {
                    if(user[0] <= emoticon.discountPercent) {
                        boughtPrice += emoticon.currentPrice;
                    }
                }

                if(boughtPrice >= user[1]) {
                    plusCount++;
                }else {
                    totalPrice += boughtPrice;
                }
            }
        }else if(index < arr.length) {
            for(int i = 0; i <= 40; i+=10) {
                Emoticon emoticon = arr[index];
                emoticon.discountPercent = i;
                emoticon.updateCurrentPrice();
                int[] result = discountPolicy(index+1, arr, users);

                if(result[0] >= plusCount) {
                    if(plusCount == result[0]) {
                        totalPrice = Math.max(result[1], totalPrice);
                    }else {
                        plusCount = result[0];
                        totalPrice = result[1];
                    }
                }
            }
        }

        return new int[] {plusCount, totalPrice};
    }

    public int[] solution(int[][] users, int[] emoticons) {
        Emoticon[] arr = Arrays.stream(emoticons)
                .mapToObj(emoticon -> new Emoticon(0, emoticon))
                .toArray(Emoticon[]::new);

        return discountPolicy(0, arr, users);
    }
}