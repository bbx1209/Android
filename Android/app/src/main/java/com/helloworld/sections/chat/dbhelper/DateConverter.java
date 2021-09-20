package com.helloworld.sections.chat.dbhelper;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date revertDate(long value) {
        return new Date(value);
    }

    @TypeConverter
    public static long converterDate(Date date) {
        return date.getTime();
    }

}
