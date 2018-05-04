package com.talmadge.bwt.core.client.config.ini;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.talmadge.bwt.core.client.config.ConfigException;
import com.talmadge.bwt.core.client.config.ini.dataobject.DataObject;


/**
 * 
 */
public abstract class Config
{
    /**
     */
    public static final String DATE_DISPLAY = "display";



    /**
     */
    private DataObject data;



    /**
     * Constructor
     */
    public Config ()
    {
        super();
    }


    /**
     *
     * @param config Config
     * @throws ConfigException error
     */
    public abstract void add (Config config) throws ConfigException;


    /**
     *
     * @param data JSONObject
     * @throws ConfigException error
     */
    public abstract void add (JSONObject data) throws ConfigException;


    /**
     *
     * @param key String
     * @return JSONArray
     */
    public abstract JSONArray getArray (String key);


    /**
     * @param key String
     * @return boolean
     */
    public abstract boolean getBool (String key);


    /**
     * @param key String
     * @return int
     */
    public abstract int getInt (String key);


    /**
     * @return String[]
     */
    public abstract String[] getKeys ();


    /**
     * Return the short date format.
     *
     * @return DateTimeFormat
     */
    public DateTimeFormat getDateFormat ()
    {
        return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
    }


    /**
     * Return the format based on the requested format.
     *
     * @param format String
     * @return DateTimeFormat
     */
    public DateTimeFormat getDateFormat (String format)
    {
        if (format == Config.DATE_DISPLAY)
        {
            return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
        }

        return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
    }


    /**
     * @param keys String
     * @return String
     */
    public abstract String getString (String keys);


    /**
     *
     * @param key String
     * @return boolean
     */
    public boolean hasKey (String key)
    {
        if (this.getData() == null)
        {
            return false;
        }

        return this.getData().hasKey(key);
    }


    /**
     * @param keys String
     * @param value String
     * @throws ConfigException e
     */
    public abstract void set (String keys, String value) throws ConfigException;


    /**
     * @param keys String
     * @param value int
     * @throws ConfigException e
     */
    public abstract void set (String keys, int value) throws ConfigException;


    /**
     * @param keys String
     * @param value boolean
     * @throws ConfigException e
     */
    public abstract void set (String keys, boolean value) throws ConfigException;


    /**
     *
     * @param key String
     */
    public abstract void removeKey (String key);


    /**
     *
     * @return JSONObject
     */
    public JSONObject toJson ()
    {
       return this.getData().toJson().isObject();
    }


    /**
     *
     * @param data DataObject
     * @throws ConfigException error
     */
    protected abstract void add (DataObject data) throws ConfigException;


    /**
     * @param keys String
     * @return DataObject
     * @throws ConfigException e
     */
    protected abstract DataObject get (String keys) throws ConfigException;


    /**
     * @return DataObject
     */
    protected DataObject getData ()
    {
        return this.data;
    }


    /**
     * @param data DataObject
     */
    protected void setData (DataObject data)
    {
        this.data = data;
    }


    /**
     * @param key String
     * @param data DataObject
     * @throws ConfigException e
     */
    protected abstract void set (String key, DataObject data) throws ConfigException; 
}
