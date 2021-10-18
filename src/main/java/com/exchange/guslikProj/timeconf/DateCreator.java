package com.exchange.guslikProj.timeconf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Create today date
 *
 */
public class DateCreator {

    private SimpleDateFormat formater;
    private Calendar datetime;

    public DateCreator(){
        this.formater = new SimpleDateFormat("yyyy-MM-dd");
        this.datetime = new GregorianCalendar();
    }

    /**
     * Return today date minus days
     * @param minusDays - how much you want to minus from current date
     * @return
     */
    public String getMinusDate(int minusDays){
        datetime.roll(Calendar.DAY_OF_MONTH, -minusDays);

        return formater.format(datetime.getTime());
    }

    public String getDate() {
        return formater.format(datetime.getTime());
    }
}
