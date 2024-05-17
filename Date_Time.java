package Time_Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Date_Time {
    public static void main(String args[]) {

        LocalDate localDate = LocalDate.of(2024,11,21);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String p = "2014-09-12";
        LocalDate date = LocalDate.parse(p);
        System.out.println(date);

    }
}
