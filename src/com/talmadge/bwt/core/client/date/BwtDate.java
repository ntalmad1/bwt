package com.talmadge.bwt.core.client.date;

import java.util.Date;

//import org.swis.sb.client.constant.TimeList;
//import org.swis.sb.client.constant.type.TimeItem;
//import org.swis.sb.client.service.ServiceLocator;
//import org.swis.sb.i18n.util.date.SBDateI18nConstants;

import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.i18n.client.TimeZoneInfo;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.talmadge.bwt.core.client.json.HasJsonValue;

/**
 * 
 */
public class BwtDate implements Comparable<BwtDate>, HasJsonValue
{
    /**
     */
    public static final Date EPOCH = new Date(28800000);

    /**
     */
    public static final String NULL_DATE = "null date";

    /**
     */
    public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd";

    /**
     */
    public static final String STANDARD_TIME_FORMAT = "HH:mm:ss";

    /**
     */
    public static final String STANDARD_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     */
    private static DateTimeFormat DAY_OF_WEEK_FORMATTER = DateTimeFormat.getFormat("c");

    /**
     */
    private static DateTimeFormat STANDARD_24_TIME_FORMATTER = DateTimeFormat.getFormat(PredefinedFormat.HOUR24_MINUTE);

    /**
     */
    private static DateTimeFormat STANDARD_DATE_FORMATTER = DateTimeFormat.getFormat(STANDARD_DATE_FORMAT);

    /**
     */
    private static DateTimeFormat STANDARD_DATE_TIME_FORMATTER = DateTimeFormat.getFormat(STANDARD_DATE_TIME_FORMAT);

    /**
     */
    private static DateTimeFormat STANDARD_TIME_FORMATTER = DateTimeFormat.getFormat(STANDARD_TIME_FORMAT);

    /**
     */
    private static boolean USE_24_HOUR_TIME = false;



    /**
	 * 
	 * @return int
	 */
	public static int getCurrentYear ()
	{
		return BwtDate.newDate().getYear();
	}


	/**
     *
     * @param format DateTimeFormat
     * @return String
     */
    public static String getDateString (DateTimeFormat format)
    {
        BwtDate date = new BwtDate();
        return date.toFormattedString(format);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getDayOfWeekFormatter ()
    {
        return DAY_OF_WEEK_FORMATTER;
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getMediumDateFormatter ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getMediumDateTimeFormatter ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getMonthDayFormatter ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.MONTH_NUM_DAY);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getShortDateFormatter ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getShortDateTimeFormatter ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_SHORT);
    }


    /**
     *
     * @return DateTimeFormat
     */
    public static DateTimeFormat getShortTimeFormatter ()
    {
        if (BwtDate.use24HourTime())
        {
            return BwtDate.STANDARD_24_TIME_FORMATTER;
        }
        else
        {
            return DateTimeFormat.getFormat(PredefinedFormat.TIME_SHORT);
        }
    }


    /**
     *
     * @return the standardOutputFormater
     */
    public static DateTimeFormat getStandardDateFormatter ()
    {
        return BwtDate.STANDARD_DATE_FORMATTER;
    }


    /**
     *
     * @return the standardOutputFormater
     */
    public static DateTimeFormat getStandardDateTimeFormatter ()
    {
        return BwtDate.STANDARD_DATE_TIME_FORMATTER;
    }


    /**
     *
     * @return the standardOutputFormater
     */
    public static DateTimeFormat getStandardTimeFormatter ()
    {
        if (BwtDate.use24HourTime())
        {
            return BwtDate.STANDARD_24_TIME_FORMATTER;
        }
        else
        {
            return BwtDate.STANDARD_TIME_FORMATTER;
        }
    }


    /**
     *
     * @return SBDate
     */
    public static BwtDate newDate ()
    {
        return new BwtDate();
    }


    /**
     *
     * @param withMaxTime boolean
     * @return SBDate
     */
    public static BwtDate newDate (boolean withMaxTime)
    {
        BwtDate date = BwtDate.newDate();

        if (withMaxTime)
        {
            date.setHours(23);
            date.setMinutes(59);
            date.setSeconds(59);
        }


        return date;
    }


    /**
     *
     * @return SBDate
     */
    public static BwtDate newNullDate ()
    {
        BwtDate date = new BwtDate();
        date.setDate(null);
        return date;
    }


    /**
     *
     * @param use24HourTime boolean
     */
    public static void setUse24HourTime (boolean use24HourTime)
    {
        BwtDate.USE_24_HOUR_TIME = use24HourTime;
    }


    /**
     *
     * @return boolean
     */
    public static boolean use24HourTime ()
    {
        return BwtDate.USE_24_HOUR_TIME;
    }


    /**
     * Sting to return in the case date is null.
     */
    private String altString;


    /**
     * A date supplied by the user
     */
    private Date date;


    /**
     * A date format used for importing a string date.
     */
    private String importFormat;


    /**
     */
    private boolean includeTime;


    /**
     */
    private boolean isNull;


    /**
     * A specified for this date object.
     */
    private TimeZone timeZone;



    /**
     * Constructor
     *
     */
    public BwtDate ()
    {
        this.setDate(new Date());
    }


    /**
     * Constructor
     *
     * @param date Date
     */
    public BwtDate (Date date)
    {
        this.setDate(date);
    }


    /**
     * Constructor
     *
     * @param time long
     */
    public BwtDate (long time)
    {
        this(new Date(time));
    }


    /**
     * Constructor
     *
     * @param standardDateString String
     * @throws BwtDateException e
     */
    public BwtDate (String standardDateString) throws BwtDateException
    {
        if (standardDateString == null || standardDateString.isEmpty())
        {
            this.setDate(null);
        }
        else
        {
            try
            {
                String format = BwtDate.STANDARD_DATE_FORMAT;
                if (standardDateString.length() > 10)
                {
                    format = BwtDate.STANDARD_DATE_TIME_FORMAT;
                    this.setIncludeTime(true);
                }

                Date date = BwtDateUtils.convertStringToDate(standardDateString, format);
                this.setImportFormat(format);
                this.setDate(date);
            }
            catch (Exception e)
            {
                throw new BwtDateException(e);
            }
        }
    }


    /**
     * Constructor
     *
     * @param date Date
     * @param timeZone TimeZone
     */
    public BwtDate (Date date, TimeZone timeZone)
    {
        this(date);
        this.setTimeZone(timeZone);
    }


    /**
     * Constructor
     *
     * @param dateString String
     * @param format String
     * @throws BwtDateException 
     */
    public BwtDate (String dateString, String format) throws BwtDateException
    {
        if (dateString == null)
        {
            this.setDate(null);
        }
        else
        {
            try
            {
                Date date = BwtDateUtils.convertStringToDate(dateString, format);
                this.setImportFormat(format);
                this.setDate(date);
            }
            catch (Exception e)
            {
                throw new BwtDateException(e);
            }
        }
    }


    /**
     * Constructor
     *
     * @param dateString String
     * @param format String
     * @param timeZoneOffsetInMinutes int
     * @throws Exception error
     */
    public BwtDate (String dateString, String format, int timeZoneOffsetInMinutes) throws Exception
    {
        Date date = BwtDateUtils.convertStringToDate(dateString, format);
        this.setImportFormat(format);
        this.setDate(date);
        this.setTimeZone(timeZoneOffsetInMinutes);
    }


    /**
     * Constructor
     *
     * @param dateString String
     * @param format String
     * @param tzJSON  String
     * @throws Exception error
     */
    public BwtDate (String dateString, String format, String tzJSON) throws Exception
    {
        Date date = BwtDateUtils.convertStringToDate(dateString, format);
        this.setImportFormat(format);
        this.setDate(date);
        this.setTimeZone(tzJSON);
    }


    /**
     * Constructor
     *
     * @param dateString String
     * @param format String
     * @param timeZone TimeZone
     * @throws Exception error
     */
    public BwtDate (String dateString, String format, TimeZone timeZone) throws Exception
    {
        Date date = BwtDateUtils.convertStringToDate(dateString, format);
        this.setImportFormat(format);
        this.setDate(date);
        this.setTimeZone(timeZone);
    }


    /**
     * Constructor
     *
     * @param jsonValue JSONValue
     * @throws BwtDateException e
     */
    public BwtDate (JSONValue jsonValue) throws BwtDateException
    {
        super();

        if (jsonValue.isNull() != null)
        {
            this.setDate(null);
        }
        else
        {
            BwtDate date = new BwtDate(jsonValue.isString().stringValue());
            this.setDate(date.getDate());
        }

    }


    /**
     *
     * @param days int
     * @return SBDate
     */
    public BwtDate addDays (int days)
    {
        return BwtDateUtils.addDaysToDate(this, days);
    }


    /**
     * Adds x number of years to the date.
     *
     * @param years int
     * @return SBDate
     */
    public BwtDate addYears (int years)
    {
        return BwtDateUtils.addYearsToDate(this, years);
    }


    /**
    *
    * @param compareTo SBDate
    * @return boolean
    */
    public boolean after (BwtDate compareTo)
    {
        if (this.isNull() || compareTo == null || compareTo.isNull())
        {
            return false;
        }

        return this.getDate().after(compareTo.getDate());
    }


    /**
     * 
     * @return HasJsonValue
     */
	public JSONValue asJsonValue ()
	{
		return new JSONString(this.toStandardDateString());
	}


	/**
     *
     * @param compareTo SBDate
     * @return boolean
     */
    public boolean before (BwtDate compareTo)
    {
        if (this.isNull() || compareTo == null || compareTo.isNull())
        {
            return false;
        }

        return this.getDate().before(compareTo.getDate());
    }


    /**
    *
    * @param before SBDate
    * @param after SBDate
    * @return boolean
    */
    public boolean between (BwtDate before, BwtDate after)
    {
        return (before.before(this) && after.after(this));
    }


    /**
     *
     * @return SBDate
     */
    public BwtDate clearTime ()
    {
        this.setHours(0);
        this.setMinutes(0);
        this.setSeconds(0);

        this.setIncludeTime(false);

        return this;
    }


    /**
     *
     * @param date SBDate
     * @return int
     */
    public int compareTo (BwtDate date)
    {
        int val = 0;

        if (!this.equals(date))
        {
            val = this.toStandardString().compareToIgnoreCase(date.toStandardString());
        }

        return val;
    }


    /**
     * Returns whether the date is between the start and end date arguments, including equal to either of those dates
     * @param start SBDate
     * @param end SBDate
     * @return boolean
     */
    public boolean containedWithin (BwtDate start, BwtDate end)
    {
    	return (start.getDate().compareTo(this.getDate()) <= 0 && end.getDate().compareTo(this.getDate()) >= 0);
    }


    /**
     *
     * @return SBDate
     * @throws BwtDateException e
     */
    public BwtDate copy () throws BwtDateException
    {
        return new BwtDate(this.toStandardDateTimeString(), BwtDate.STANDARD_DATE_TIME_FORMAT);
    }


    /**
     *
     * @param dateToCompare SBDate
     * @return boolean
     */
    public boolean dateEquivalentTo (BwtDate dateToCompare)
    {
        return this.toStandardDateString().equalsIgnoreCase(dateToCompare.toStandardDateString());
    }


    /**
     *
     * @param compareTo SBDate
     * @return boolean
     */
    public boolean equals (BwtDate compareTo)
    {
        if (this.isNull() && compareTo.isNull())
        {
            return true;
        }

        if (this.isNull() && !compareTo.isNull())
        {
            return false;
        }

        if (!this.isNull() && compareTo.isNull())
        {
            return false;
        }

        return this.getDate().equals(compareTo.getDate());
    }


    /**
     *
     * @param compareTo Date
     * @return boolean
     */
    public boolean equals (Date compareTo)
    {
        return this.equals(new BwtDate(compareTo));
    }


    /**
     *
     * @param compareTo SBDate
     * @return boolean
     */
    public boolean equivalentTo (Date compareTo)
    {
        return this.equivalentTo(new BwtDate(compareTo));
    }


    /**
     *
     * @param compareTo SBDate
     * @return boolean
     */
    public boolean equivalentTo (BwtDate compareTo)
    {
        return (this.compareTo(compareTo) == 0);
    }


    /**
     * @return the date
     */
    public Date getDate ()
    {
        return this.date;
    }


    /**
     * @return int
     */
    @SuppressWarnings("deprecation")
    public int getDay ()
    {
        return this.getDate().getDay();
    }


    /**
     * Returns the Java representation of the day of week (0 = Sunday, 6 = Saturday)
     *
     * @return int
     */
    public int getDayOfWeek ()
    {
        String day = this.toFormattedString("c");

        return Integer.parseInt(day);
    }


    /**
     *
     * @return Integer
     */
    public Integer getHours ()
    {
        return Integer.parseInt(this.toFormattedString("H"));
    }


    /**
     * @return importFormat
     */
    public String getImportFormat ()
    {
        return this.importFormat;
    }


    /**
     *
     * @return boolean
     */
    public boolean getIncludeTime ()
    {
        return this.includeTime;
    }


    /**
     *
     * @return Integer
     */
    public Integer getMinutes ()
    {
        return Integer.parseInt(this.toFormattedString("m"));
    }


    /**
     *
     * @return int
     */
    public int getMonth ()
    {
        DateTimeFormat monthFormat = DateTimeFormat.getFormat("M");

        return Integer.parseInt(monthFormat.format(this.date));
    }


    /**
     *
     * @return long
     */
    public long getTimeStamp ()
    {
        return this.getDate().getTime();
    }


    /**
     * @return TimeZone
     */
    public TimeZone getTimeZone ()
    {
        return this.timeZone;
    }


    /**
     *
     * @return int
     */
    public int getTimezoneOffset ()
    {
        return BwtDateUtils.getTimezoneOffset(this);
    }


    /**
     *
     * @return int
     */
    public int getYear ()
    {
        DateTimeFormat yearFormat = DateTimeFormat.getFormat(PredefinedFormat.YEAR);

        String year = yearFormat.format(this.date);

        if (year.length() > 4)
        {
            // This returns some additional characters in some languages, namely Chinese (zh).
            year = year.substring(0, 4);
        }

        return Integer.parseInt(year);
    }


    /**
     * @return boolean
     */
    public boolean isNull ()
    {
        return this.isNull;
    }


    /**
     *
     * @param compareTo SBDate
     * @return boolean
     */
    public boolean lessThan (BwtDate compareTo)
    {
        return this.getDate().before(compareTo.getDate());
    }


    /**
     * @param string String
     */
    public void setAltString (String string)
    {
        this.altString = string;
    }


    /**
     *
     * @param date the date to set
     */
    public void setDate (Date date)
    {
        if (date == null)
        {
            this.isNull = true;
        }

        this.date = date;
    }


    /**
     * Sets the calendar date of the date
     * @param day int
     */
    public void setDay (int day)
    {
        BwtDateUtils.setDateOnDate(this, day);
    }


    /**
     *
     * @param hours int
     */
    public void setHours (int hours)
    {
        BwtDateUtils.setHoursOnDate(this,  hours);
    }


    /**
     *
     * @param importFormat String
     */
    public void setImportFormat (String importFormat)
    {
        this.importFormat = importFormat;
    }


    /**
     *
     * @param includeTime boolean
     */
    public void setIncludeTime (boolean includeTime)
    {
        this.includeTime = includeTime;
    }


    /**
     *
     * @param minutes int
     */
    public void setMinutes (int minutes)
    {
        BwtDateUtils.setMinutesOnDate(this, minutes);
    }


    /**
     *
     * @param month int
     */
    public void setMonth (int month)
    {
        BwtDateUtils.setMonthOnDate(this, month);
    }


    /**
     *
     * @param seconds int
     */
    public void setSeconds (int seconds)
    {
        BwtDateUtils.setSecondsOnDate(this, seconds);
    }


    /**
     *
     * @param timeStamp long
     */
    public void setTimeStamp (long timeStamp)
    {
        this.date.setTime(timeStamp);
    }


    /**
     *
     * @param timeZoneOffsetInMinutes int
     */
    public void setTimeZone (int timeZoneOffsetInMinutes)
    {
        this.timeZone = TimeZone.createTimeZone(timeZoneOffsetInMinutes);
    }


    /**
     *
     * @param json String
     */
    public void setTimeZone (String json)
    {
        this.timeZone = TimeZone.createTimeZone(json);
    }


    /**
     *
     * @param timeZone TimeZone
     */
    public void setTimeZone (TimeZone timeZone)
    {
        this.timeZone = timeZone;
    }


    /**
     *
     * @param timezoneData TimeZoneInfo
     */
    public void setTimeZone (TimeZoneInfo timezoneData)
    {
        this.timeZone = TimeZone.createTimeZone(timezoneData);
    }


    /**
     *
     * @param year int
     */
    public void setYear (int year)
    {
        BwtDateUtils.setYearOnDate(this, year);
    }


    /**
     *
     * @param days int
     * @return SBDate
     */
    public BwtDate subtractDays (int days)
    {
        return this.addDays(-1 * days);
    }


    /**
     *
     * @param dateToCompare SBDate
     * @return boolean
     */
    public boolean timeEquivalentTo (BwtDate dateToCompare)
    {
        return this.toStandardTimeString().equalsIgnoreCase(dateToCompare.toStandardTimeString());
    }


    /**
     *
     * @return String
     */
    public String toDayOfWeekAbbrvString ()
    {
        return this.toFormattedString(DateTimeFormat.getFormat("E"));
    }


    /**
     *
     * @return String
     */
    public String toDayOfWeekString ()
    {
        return this.toFormattedString(DateTimeFormat.getFormat("EEEE"));
    }


    /**
     * Returns the date string in the supplied format.
     *
     * @param format String
     * @return String
     */
    public String toFormattedString (String format)
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(format);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     *
     * @param dateTimeFormatter DateTimeFormat
     * @return String
     */
    public String toFormattedString (DateTimeFormat dateTimeFormatter)
    {
        String altString = null;

        if (this.altString != null)
        {
            altString = this.altString;
        }
       
        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     *
     * @param dateTimeFormatter DateTimeFormat
     * @param altString String
     * @return String
     */
    public String toFormattedString (DateTimeFormat dateTimeFormatter, String altString)
    {
        return this.toFormattedString(dateTimeFormatter, altString, null);
    }


    /**
     *
     * @param dateTimeFormatter DateTimeFormat
     * @param altString String
     * @param timeZone TimeZone
     * @return String
     */
    public String toFormattedString (DateTimeFormat dateTimeFormatter, String altString, TimeZone timeZone)
    {
        if (this.isNull())
        {
            return altString;
        }

        if (this.getTimeZone() != null)
        {
            return dateTimeFormatter.format(this.getDate(), this.getTimeZone());
        }

        return dateTimeFormatter.format(this.getDate(), timeZone);
    }


    /**
     * Returns the date string in full date format.
     *
     * @return String
     */
    public String toFullDateString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_FULL);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in full date/time format.
     *
     * @return String
     */
    public String toFullDateTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_FULL);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in full date/time format.
     *
     * @param altString String
     * @return String
     */
    public String toFullDateTimeString (String altString)
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_FULL);

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date string in full time format.
     *
     * @return String
     */
    public String toFullTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.TIME_FULL);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * @return JSONValue
     */
    public JSONValue toJSONValue ()
    {
        if (this.isNull())
        {
            return JSONNull.getInstance();
        }

        return new JSONString(this.toStandardDateString());
    }


    /**
     * Returns the date string in long date format.
     *
     * @return String
     */
    public String toLongDateString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_LONG);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in long date/time format.
     *
     * @return String
     */
    public String toLongDateTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_LONG);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in long date/time format.
     *
     * @param altString String
     * @return String
     */
    public String toLongDateTimeString (String altString)
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_LONG);

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date string in long time format.
     *
     * @return String
     */
    public String toLongTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.TIME_LONG);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in medium date format.
     *
     * @return String
     */
    public String toMediumDateString ()
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getMediumDateFormatter();

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in medium date format.
     *
     * @param altString String
     * @return String
     */
    public String toMediumDateString (String altString)
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getMediumDateFormatter();

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date string in medium date/time format.
     *
     * @return String
     */
    public String toMediumDateTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in medium date/time format.
     *
     * @param altString String
     * @return String
     */
    public String toMediumDateTimeString (String altString)
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM);

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date string in medium time format.
     *
     * @return String
     */
    public String toMediumTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.TIME_MEDIUM);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     *
     * @return String
     */
    public String toMonthDayString ()
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getMonthDayFormatter();
        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     *
     * @param altString String
     * @return String
     */
    public String toMonthDayString (String altString)
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getMonthDayFormatter();
        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     *
     * @return String
     */
    public String toMonthString ()
    {
        DateTimeFormat format = DateTimeFormat.getFormat(PredefinedFormat.MONTH);
        return this.toFormattedString(format);
    }


    /**
     *
     * @return String
     */
    public String toMonthYearString ()
    {
        DateTimeFormat format = DateTimeFormat.getFormat(PredefinedFormat.YEAR_MONTH);
        return this.toFormattedString(format);
    }


    /**
     * Returns the date string in short date format.
     *
     * @return String
     */
    public String toShortDateString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in short date format.
     *
     * @param altString String
     * @return String
     */
    public String toShortDateString (String altString)
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);

        return this.toFormattedString(dateTimeFormatter, "--");
    }


    /**
     * Returns the date string in short date/time format.
     *
     * @return String
     */
    public String toShortDateTimeString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_SHORT);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     *
     * @return String
     */
    public String toShortMonthString ()
    {
        DateTimeFormat dateTimeFormatter = DateTimeFormat.getFormat(PredefinedFormat.MONTH_ABBR);

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in short time format.
     *
     * @return String
     */
    public String toShortTimeString ()
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getShortTimeFormatter();

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date string in short time format.
     *
     * @param altString String
     * @return String
     */
    public String toShortTimeString (String altString)
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getShortTimeFormatter();

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date as a String in standard output form
     *
     * @return String
     */
    public String toStandardDateString ()
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getStandardDateFormatter();

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     * Returns the date as a String in standard output form
     *
     * @param altString String
     * @return String
     */
    public String toStandardDateString (String altString)
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getStandardDateFormatter();

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     * Returns the date & time as a String in standard output form
     *
     * @return String
     */
    public String toStandardDateTimeString ()
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getStandardDateTimeFormatter();

        return this.toFormattedString(dateTimeFormatter);
    }


    /**
     *
     * @param altString String
     * @return String
     */
    public String toStandardDateTimeString (String altString)
    {
        DateTimeFormat dateTimeFormatter = BwtDate.getStandardDateTimeFormatter();

        return this.toFormattedString(dateTimeFormatter, altString);
    }


    /**
     *
     * @return String
     */
    public String toStandardString ()
    {
        if (this.includeTime)
        {
            return this.toStandardDateTimeString();
        }
        else
        {
            return this.toStandardDateString();
        }
    }


    /**
     * Returns the time as a String in standard output form
     *
     * @return String
     */
    public String toStandardTimeString ()
    {
        return BwtDate.getStandardTimeFormatter().format(this.getDate());
    }
}
