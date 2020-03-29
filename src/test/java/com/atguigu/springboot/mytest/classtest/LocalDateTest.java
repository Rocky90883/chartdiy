package com.atguigu.springboot.mytest.classtest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ValueRange;

public class LocalDateTest {

    public static void main(String[] args){

        util();
        localtime();
        jisuan();
    }

    public static void util(){

        System.out.println("of---------------------");
        LocalDate of = LocalDate.of(2020, 03, 28);
        LocalDate of1 = LocalDate.of(2020, Month.AUGUST, 1);
        System.out.println(of);
        System.out.println(of1);

        System.out.println("parse------------------");
        LocalDate parse = LocalDate.parse("2020-03-28");
        LocalDate parse1 = LocalDate.parse("2020/02/23", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(parse);
        System.out.println(parse1);

        System.out.println("now--------------------");
        LocalDate now = LocalDate.now();
        LocalDate now1 = LocalDate.now(Clock.systemDefaultZone());
        System.out.println(now);
        System.out.println(now1);

    }

    public static void localtime(){

        System.out.println("localtime----------------");
        LocalTime of = LocalTime.of(15, 42 ,38);
        System.out.println("of = " + of);

        LocalTime parse = LocalTime.parse("15/42/58", DateTimeFormatter.ofPattern("HH/mm/ss"));
        System.out.println("parse = " + parse);

        System.out.println("ofSecondOfDay--------------");
        LocalTime localTime = LocalTime.ofSecondOfDay(10 * 60 * 60);
        System.out.println("localTime = " + localTime);

        System.out.println("LocalDateTime---------------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime of1 = LocalDateTime.of(now1, now2);
        System.out.println("of1 = " + of1);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now.format(dateTimeFormatter));


        System.out.println("get-----------------------");
        LocalDateTime datetimenow = LocalDateTime.now();
        Month month = datetimenow.getMonth();
        int monthValue = datetimenow.getMonthValue();
        DayOfWeek dayOfWeek = datetimenow.getDayOfWeek();
        System.out.println(month);
        System.out.println(monthValue);
        System.out.println(dayOfWeek.getValue());          //获取周几


        //获取时间戳
        System.out.println("toEpochDay---------------");
        long l = LocalDate.now().toEpochDay();              //1970 1 1
        System.out.println("l = " + l);

        long l1 = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println("l1 = " + l1);


        //获取当月多少天  获取当年多少天
        System.out.println("range---------------");
        ValueRange range = now.range(ChronoField.DAY_OF_MONTH);
        System.out.println("range = " + range);
        ValueRange rangeyeat = now.range(ChronoField.DAY_OF_YEAR);
        System.out.println("rangeyeat = " + rangeyeat);

        System.out.println("lengthofYear or month----------------------");
        System.out.println(LocalDate.now().lengthOfYear());
        System.out.println(LocalDate.now().lengthOfMonth());
    }


    public static void jisuan(){

        //时间的计算
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("加---------------------");
        LocalDateTime dateTime = now.plusDays(5);               //加五天
        System.out.println(dateTime.format(dateTimeFormatter));

        now.plus(10, ChronoUnit.DAYS);           //加五天
        System.out.println("dateTime = " + dateTime.format(dateTimeFormatter));

        System.out.println("减---------------------");
        System.out.println(now.minusMonths(10).format(dateTimeFormatter));          //减十个月
        System.out.println(now.minus(10, ChronoUnit.MONTHS).format(dateTimeFormatter));     //减十个月



        //时间比较
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = LocalDateTime.now();
        LocalDateTime dateTime1 = t1.plusDays(1);
        LocalDateTime dateTime2 = t1.minusDays(1);
        boolean after = t2.isAfter(dateTime2);
        System.out.println("after = " + after);
        boolean equal = t1.isEqual(t2);
        System.out.println("equal = " + equal);




    }

}
