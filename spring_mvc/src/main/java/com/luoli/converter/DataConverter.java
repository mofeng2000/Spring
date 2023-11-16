package com.luoli.converter;

import javafx.beans.property.SimpleIntegerProperty;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter implements Converter<String,Date> {

    public Date convert(String dateStr) {
      //将日期字符串转化为日期对象返回
        SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
        Date date=null;
        try {
             date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
