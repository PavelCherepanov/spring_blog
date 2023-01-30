package com.blog.blog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Pavel
 * @version 1.0
 * @date 26.01.2023 13:30
 */
public class LocalDate {
        public Date getNowDate(){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            try {
                date = formatter.parse(formatter.format(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return date;
        }
}
