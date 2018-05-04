package com.talmadge.bwt.core.client.date;

import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * 
 */
public class BwtDateUtils
{
    /**
     */
    private static String[][][] PHP_FORMAT_CONVERSION_TABLE = new String[][][]
    {
        { // Year
            { "yyyy", "Y" },
            { "yy", "y" }
        },
        { // Month
            { "MMMMM", "F" },
            { "MMMM", "F" },
            { "MMM", "M" },
            { "MM", "m" },
            { "M", "n" }
        },
        { // Day
            { "EEEEEE", "l" },
            { "EEEEE", "l" },
            { "EEEE", "l" },
            { "EEE", "D" },
            { "dd", "d" },
        },
        {{ "HH", "H" }},
        {{ "mm", "i" }},
        {{ "ss", "s" }},
        {{ "hh", "h" }},
        {{ "A", "a" }},
        {{ "S", "u" }}
    };


    /**
     * Adds the given number of days to the current date.
     *
     * @param date SBDate
     * @param days int
     * @return SBDate
     */
    public static BwtDate addDaysToDate (BwtDate date, int days)
    {
        CalendarUtil.addDaysToDate(date.getDate(), days);

        return date;
    }


    /**
     * Adds the given number of months to the current date.
     *
     * @param date SBDate
     * @param months int
     */
    public static void addMonthsToDate (BwtDate date, int months)
    {
        CalendarUtil.addMonthsToDate(date.getDate(), months);
    }


    /**
     * Adds x number of years to the date.
     *
     * @param date SBDate
     * @param years int
     * @return SBDate
     */
    public static BwtDate addYearsToDate (BwtDate date, int years)
    {
        CalendarUtil.addMonthsToDate(date.getDate(), (years * 12));

        return date;
    }

    /**
     * Returns -1 if date range one is before date range two.
     * Returns 0 if the date ranges collide.
     * Returns 1 if date range one is after date range two.
     *
     * Takes into account isNull() end dates as open ended date ranges
     *
     * @param rangeOneStartDate SBDate
     * @param rangeOneEndDate SBDate
     * @param rangeTwoStartDate SBDate
     * @param rangeTwoEndDate SBDate
     * @return int
     */
    public static int compareDateRanges (BwtDate rangeOneStartDate, BwtDate rangeOneEndDate, BwtDate rangeTwoStartDate, BwtDate rangeTwoEndDate)
    {
        // check if both ranges are openEnded
        if (rangeOneEndDate.isNull() && rangeTwoEndDate.isNull())
        {
            return 0;
        }

        // check if range one is open ended and range two is not
        if (rangeOneEndDate.isNull())
        {
            // if range one is open ended range two must end before range one starts
            if (rangeTwoEndDate.before(rangeOneStartDate))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // check if range two is open ended and range one is not
        if (rangeTwoEndDate.isNull())
        {
            if (rangeOneEndDate.before(rangeTwoEndDate))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        // check for overlap
        if (rangeOneStartDate.between(rangeTwoStartDate, rangeTwoEndDate)
        ||  rangeOneEndDate.between(rangeTwoStartDate, rangeTwoEndDate)
        ||  rangeOneStartDate.equals(rangeTwoStartDate)
        ||  rangeOneStartDate.equals(rangeTwoEndDate)
        ||  rangeOneEndDate.equals(rangeTwoStartDate)
        ||  rangeOneEndDate.equals(rangeTwoEndDate))
        {
            return 0;
        }
        else if (rangeOneEndDate.before(rangeTwoStartDate))
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }


    /**
     * A function for converting strings for date objects.
     *
     * @param dateString String
     * @param format String
     * @return Date
     * @throws Exception error
     */
    public static Date convertStringToDate (String dateString, String format) throws Exception
    {
        Date date = null;
        try
        {
            DateTimeFormat dateFormater = DateTimeFormat.getFormat(format);
            date = dateFormater.parse(dateString);
        }
        catch (Exception e)
        {
            throw e;
        }

        return date;
    }


    /**
     * Returns the number of days between the two dates. Time is ignored.
     *
     * @param date SBDate
     * @param checkDate Date
     * @return int
     */
    public static int getDaysBetween (BwtDate date, Date checkDate)
    {
        return CalendarUtil.getDaysBetween(date.getDate(), checkDate);
    }


    /**
     * Returns the number of days between the two dates. Time is ignored.
     *
     * @param date SBDate
     * @param checkDate SBDate
     * @return int
     */
    public static int getDaysBetween (BwtDate date, BwtDate checkDate)
    {
        return CalendarUtil.getDaysBetween(date.getDate(), checkDate.getDate());
    }


    /**
     *
     * @param d1 SBDate
     * @param d2 SBDate
     * @return SBDate
     */
    public static BwtDate getEarlier (BwtDate d1, BwtDate d2)
    {
        if (d1 != null && d1.before(d2))
        {
            return d1;
        }
        else
        {
            return d2;
        }
    }


    /**
     *
     * @param dates SBDate
     * @return SBDate
     */
    public static BwtDate getEarliest (BwtDate... dates)
    {
        BwtDate earliest = null;
        for (BwtDate date : dates)
        {
            earliest = BwtDateUtils.getEarlier(earliest, date);
        }

        return earliest;
    }


    /**
     *
     * @param d1 SBDate
     * @param d2 SBDate
     * @return SBDate
     */
    public static BwtDate getLater (BwtDate d1, BwtDate d2)
    {
        if (d1 != null && d1.after(d2))
        {
            return d1;
        }
        else
        {
            return d2;
        }
    }


    /**
     *
     * @param dates SBDate
     * @return SBDate
     */
    public static BwtDate getLatest (BwtDate... dates)
    {
        BwtDate latest = null;
        for (BwtDate date : dates)
        {
            latest = BwtDateUtils.getLater(latest, date);
        }

        return latest;
    }


    /**
     *
     * @param format DateTimeFormat
     * @return String
     */
    public static String getPhpFormat (DateTimeFormat format)
    {
        String pattern = format.getPattern();

        for (String[][] group : PHP_FORMAT_CONVERSION_TABLE)
        {
            for (String[] item : group)
            {
                if (pattern.contains(item[0]))
                {
                    pattern = pattern.replaceAll(item[0], item[1]);
                    break;
                }
            }
        }

        return pattern;
    }


    /**
     *
     * @return int
     */
    @SuppressWarnings("deprecation")
    public static int getTimezoneOffset ()
    {
        Date date = new Date();

        return date.getTimezoneOffset();
    }


    /**
     *
     * @param date SBDate
     * @return int
     */
    @SuppressWarnings("deprecation")
    public static int getTimezoneOffset (BwtDate date)
    {
        return date.getDate().getTimezoneOffset();
    }


    /**
     * Check if two dates represent the same date of the same year, even if they have different times.
     *
     * @param date SBDate
     * @param checkDate Date
     * @return int
     */
    public static boolean isSameDate (BwtDate date, Date checkDate)
    {
        return CalendarUtil.isSameDate(date.getDate(), checkDate);
    }


    /**
     * Check if two dates represent the same date of the same year, even if they have different times.
     *
     * @param date SBDate
     * @param checkDate SBDate
     * @return int
     */
    public static boolean isSameDate (BwtDate date, BwtDate checkDate)
    {
        return CalendarUtil.isSameDate(date.getDate(), checkDate.getDate());
    }


    /**
     *
     * @param date SBDate
     * @param day int
     */
    @SuppressWarnings("deprecation")
    public static void setDateOnDate (BwtDate date, int day)
    {
        date.getDate().setDate(day);
    }


    /**
     *
     * @param date SBDate
     * @param hours int
     */
    @SuppressWarnings("deprecation")
    public static void setHoursOnDate (BwtDate date, int hours)
    {
        date.getDate().setHours(hours);
    }


    /**
     *
     * @param date SBDate
     * @param minutes int
     */
    @SuppressWarnings("deprecation")
    public static void setMinutesOnDate (BwtDate date, int minutes)
    {
        date.getDate().setMinutes(minutes);
    }


    /**
     *
     * @param date SBDate
     * @param month int
     */
    @SuppressWarnings("deprecation")
    public static void setMonthOnDate (BwtDate date, int month)
    {
        date.getDate().setMonth(month);
    }


    /**
     *
     * @param date SBDate
     * @param seconds int
     */
    @SuppressWarnings("deprecation")
    public static void setSecondsOnDate (BwtDate date, int seconds)
    {
        date.getDate().setSeconds(seconds);
    }


    /**
     * Sets a date object to be at the beginning of the month and no time specified.
     *
     * @param date SBDate
     */
    public static void setToFirstDayOfMonth (BwtDate date)
    {
        CalendarUtil.setToFirstDayOfMonth(date.getDate());
    }


    /**
     *
     * @param date SBDate
     * @param year int
     */
    public static void setYearOnDate (BwtDate date, int year)
    {
        date.addYears(year - date.getYear());
    }


    /**
     *
     * @param date SBDate
     * @param days int
     * @return SBDate
     */
    public static BwtDate subtractDaysFromDate (BwtDate date, int days)
    {
        CalendarUtil.addDaysToDate(date.getDate(), (days * -1));

        return date;
    }


    /**
     * Constuctor
     */
    protected BwtDateUtils ()
    { }
}

