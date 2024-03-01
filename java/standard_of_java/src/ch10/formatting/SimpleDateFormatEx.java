package ch10.formatting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {

    public static void main(String[] args) throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy년-MM월-dd일");
        System.out.println("df.format(today) = " + df.format(today));

        Date date = df.parse("1999년-1월-12일");
        System.out.println(date);
    }
}
