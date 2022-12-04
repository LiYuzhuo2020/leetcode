package com.leetcode.alg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: drainli
 **/
public class DeliveryTime {


    public static void main(String[] args) throws ParseException {
        String time = "2021-12-01 13:59:00" ;
        Date cur = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time) ;
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(cur);
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(cur);
//        calendar.set(Calendar.MINUTE,((calendar.get(Calendar.MINUTE))/10+1)*10);
//
//        Date date = calendar.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//        System.out.println(calendar.get(Calendar.MONTH)+1);
    }
}
