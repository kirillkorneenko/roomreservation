package by.korneenko.reservation.util;

import by.korneenko.reservation.beans.BookingEntity;

import java.sql.Time;
import java.util.List;

public class TimeCheck {

    private static Time startWork = new Time(18000000);
    private static Time endWork = new Time(64800000);

    public static Boolean timeCheck(List<BookingEntity> list, Time start, Time end){
        Boolean flag = new Boolean(true);
        for (BookingEntity booking : list) {
            if(startWork.before(start)&& endWork.after(end)){
            if(start.after(booking.getTimeStart())){
                if(start.before(booking.getTimeEnd())) flag =false;
                } else {
                if(end.after(booking.getTimeStart())) flag = false;
            }}
            else flag= false;
        }
        return flag;
    }

    public static List<BookingEntity> timeEntry(List<BookingEntity> list, Time start, Time end ){

        for (BookingEntity booking : list) {
            if(start.after(booking.getTimeStart())){
                if(start.after(booking.getTimeEnd())) list.remove(booking);
            } else {
                if(end.before(booking.getTimeStart())) list.remove(booking);
            }
        }

        return list;
    }

}
