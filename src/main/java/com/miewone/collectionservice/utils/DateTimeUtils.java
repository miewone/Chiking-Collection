package com.miewone.collectionservice.utils;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 * Created by wgPark on 2023-08-05.
 */
public class DateTimeUtils {

    public static Timestamp timestampOf(LocalDateTime time) {
        return time == null ? null : Timestamp.valueOf(time);
    }

    public static LocalDateTime dateTimeOf(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

}
