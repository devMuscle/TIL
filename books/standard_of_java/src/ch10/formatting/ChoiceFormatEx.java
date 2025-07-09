package ch10.formatting;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {

    public static void main(String[] args) {
        double[] limits = {60,70,80,90}; //낮은 값부터 큰 값의 순서로 작성해야 함
        //limits, grades 간의 순서와 개수를 맞추어야 한다.
        String[] grades = {"D", "C", "B", "A"};

        int[] scores = {100, 95, 88, 80, 62, 60, 70};

        ChoiceFormat form = new ChoiceFormat(limits, grades);

        for(int score : scores) {
            System.out.println(score + " : " + form.format(score));
        }

        String pattern = "60#D|70#C|80<B|90#A";

        ChoiceFormat form2 = new ChoiceFormat(pattern);

        System.out.println("= form2 =");
        for(int score : scores) {
            System.out.println(score + " : " + form2.format(score));
        }
    }
}
