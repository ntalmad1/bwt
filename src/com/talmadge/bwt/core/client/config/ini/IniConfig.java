package com.talmadge.bwt.core.client.config.ini;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.talmadge.bwt.core.client.config.ConfigException;
import com.talmadge.bwt.core.client.config.ini.dataobject.DataObject;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBBoolean;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBDataObject;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBDouble;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBInteger;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBJSONArray;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBNull;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBString;
import com.talmadge.bwt.core.client.config.ini.dataobject.SBValue;


/**
 * 
 */
public class IniConfig extends Config
{
    /**
     */
    public IniConfig ()
    {
        super();
    }


    /**
     *
     * @param data SBDataObject
     */
    public IniConfig (SBDataObject data)
    {
        super();
        this.setData(data);
    }


    /**
     *
     * @param jsonString String
     * @throws ConfigException error
     */
    public IniConfig (String jsonString) throws ConfigException
    {
        this(JSONParser.parseStrict(jsonString).isObject());
    }


    /**
     *
     * @param json JSONObject
     * @throws ConfigException 
     */
    public IniConfig (JSONObject json) throws ConfigException
    {
        this(new SBDataObject(json));
    }


    /**
     *
     * @param config Config
     * @throws ConfigException error
     */
    public void add (Config config) throws ConfigException
    {
        this.add(config.getData());
    }


    /**
     *
     * @param data DataObject
     * @throws ConfigException error
     */
    public void add (DataObject data) throws ConfigException
    {
        this.add(data, false);
    }


    /**
     *
     * @param data DataObject
     * @param force boolean
     * @throws ConfigException error
     */
    public void add (DataObject data, boolean force) throws ConfigException
    {
        if (this.getData() == null)
        {
            this.setData(data);
        }
        else
        {
             this.getData().absorb(data, force);
        }
    }


    /**
     *
     * @param data JSONObject
     * @throws ConfigException error
     */
    public void add (JSONObject data) throws ConfigException
    {
        this.add(data, false);
    }


    /**
     *
     * @param data JSONObject
     * @param force boolean
     * @throws ConfigException error
     */
    public void add (JSONObject data, boolean force) throws ConfigException
    {
        this.add(new SBDataObject(data), force);
    }



    /**
     * @return String[]
     */
    public String[] getKeys ()
    {
        if (this.getData() != null)
        {
            return ((SBDataObject) this.getData()).getKeys();
        }
        else
        {
            return new String[]{};
        }
    }


    /**
     * @param key String
     * @return int
     * @throws SBException
     */
    public int getInt (String key)
    {
        SBValue value = (SBValue) this.get(key);

        if (value.getClass() == SBString.class)
        {
            Double intObj = Double.parseDouble(((SBString) value).stringValue());
            return intObj.intValue();
        }
        else if (value instanceof SBDouble)
        {
            return ((SBDouble) value).intValue();
        }
        else
        {
            return ((SBInteger) value).intValue();
        }
    }


    /**
     * @param key String
     * @return JSONArray
     */
    public JSONArray getArray (String key)
    {
        JSONArray value = ((SBJSONArray) this.get(key)).getArray();

        return value;
    }


    /**
     * @param key String
     * @return boolean
     */
    public boolean getBool (String key)
    {
        SBValue value = (SBValue) this.get(key);

        if (value.getClass() == SBString.class)
        {
            Boolean boolObj = Boolean.valueOf(((SBString) value).stringValue());
            return boolObj.booleanValue();
        }
        else if (value.getClass() == SBNull.class)
        {
            // This was added to deal with items that are being returned as null. They will
            // always return a false. --SM/BA 20140923 (bug 5696)
            return false;
        }
        else
        {
            return ((SBBoolean) value).booleanValue();
        }
    }


    /**
     * @param key String
     * @return String
     */
    public String getString (String key)
    {
        DataObject value = this.get(key);

        if (value != null && !value.isNull())
        {
            return this.get(key).getRawValue() + "";
        }
        else
        {
            return null;
        }
    }


    /**
     *
     * @param event GwtEvent<?>
     */
    public void onEvent (GwtEvent<?> event)
    {

    }


    /**
     *
     * @param key String
     */
    public void removeKey (String key)
    {
        this.getData().removeKey(key);
    }


    /**
     * @param key String
     * @param value int
     * @throws ConfigException e
     */
    public void set (String key, int value) throws ConfigException 
    {
        this.set(key, new SBInteger(value));
    }


    /**
     * @param key String
     * @param value boolean
     * @throws ConfigException e
     */
    public void set (String key, boolean value) throws ConfigException
    {
        this.set(key, new SBBoolean(value));
    }


    /**
     * @param key String
     * @param value String
     * @throws ConfigException e
     */
    public void set (String key, String value) throws ConfigException
    {
        this.set(key, new SBString(value));
    }


    /**
     * @param key String
     * @return DataObject
     */
    protected DataObject get (String key)
    {
        try
        {
            if (this.getData() != null)
            {
                return this.getData().get(key);
            }
            else
            {
                return new SBNull();
            }
        }
        catch (NullPointerException e)
        {
           return new SBNull();
        }
    }


    /**
     * @param key String
     * @param data DataObject
     * @throws ConfigException e
     */
    protected void set (String key, DataObject data) throws ConfigException
    {
        if (this.getData() == null)
        {
            this.setData(new SBDataObject());
        }

        this.getData().add(key, data);
    }
}
