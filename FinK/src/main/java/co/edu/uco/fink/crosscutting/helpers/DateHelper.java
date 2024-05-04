package co.edu.uco.fink.crosscutting.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");

    public static final String defaultDate = LocalDateTime.now().format(dateFormat);

    private DateHelper(){
        super();
    }


}
