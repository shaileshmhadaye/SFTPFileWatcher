package com.neo.demoSftpFileWatcher.mapStructDemo.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MfgDateMapper {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date toDate(String dateString) throws ParseException {

        Date date = null;
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                throw e;
            }
        return date;
    }

    public String toDateString(Date date) {
        String dateString = "";
        if (date != null) {
            dateString = dateFormat.format(date);
        }
        return dateString;
    }
}
