package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataApplication {
    public static final LocalDate DATENOWAPLICATION =LocalDate.of(1402,11,27);
    public static LocalDate addDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date,dateTimeFormatter);
    }

}
