package co.edu.uco.fink.crosscutting.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateHelper {

    private static final DateHelper instance = new DateHelper();

    private DateHelper(){
        super();
    }

    public static final LocalDateTime getDate(final LocalDateTime Fecha){
        return ObjectHelper.getObjectHelper().isNUll(Fecha) ? LocalDateTime.now() : Fecha;
    }

}
