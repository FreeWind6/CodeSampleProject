package com.javalesson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateAndCalendar {
    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);//установили дату в календарь

        calendar.add(Calendar.MINUTE, 1);//прибавили минуту
        System.out.println(calendar.getTime());//вывели это время

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);//короткий формат вывода
        System.out.println(dateFormat.format(calendar.getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm");//вывести указанным форматом
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        Date newDate = simpleDateFormat.parse("05/12/1985 05:22");//распарсили эту дату (чтобы система ее поняла)
        System.out.println(newDate);

        // пример использования (бот)
        System.out.println("--------------------------");
        int days = getDays();
        int dayOfWeek = getDayOfWeek();
        System.out.println(days);
        System.out.println(dayOfWeek);
    }

    // количество недель от даты date2
    public static int getDays() throws ParseException {
        Date date1 = new Date();
        Date date2;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        date2 = sdf.parse("2019.01.01");
        int days = (int) ((date1.getTime() - date2.getTime()) / 1000 / 3600 / 24 / 7);
        return days;
    }

    public static int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // первый день недели - воскресенье
        return dayOfWeek;
    }
}
