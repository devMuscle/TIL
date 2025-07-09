package ch10.formatting;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatEx {

    public static void main(String[] args) throws ParseException {
        String msg = "Name: {0} \nTel: {1} \nAge:{2} \nBirthday: {3}";

        Object[] arguments = {"홍지표", "010-1234-5678", "25", "03-01"};

        String result = MessageFormat.format(msg, arguments);
        System.out.println(result);

        //같은 형식에서 우너하는 값 추출
        String[] data = {"INSERT ('홍지표', '010-123-456', '25', '12-25')", "INSERT ('김자바', '010-456-789', '99', '03-01')"};

        String pattern = "INSERT ({0}, {1}, {2}, {3})";
        MessageFormat mf = new MessageFormat(pattern);

        System.out.println("= parse example =");
        for(String datum : data) {
            Object[] extractData = mf.parse(datum);

            for(Object extractDatum : extractData) {
                System.out.print(extractDatum + " ");
            }
            System.out.println();
        }
    }
}
