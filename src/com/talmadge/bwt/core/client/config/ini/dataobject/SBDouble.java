package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBDouble extends SBValue
{
    /**
     */
    public SBDouble ()
    {
        this(null);
    }


    /**
     * @param rawValue double
     */
    public SBDouble (double rawValue)
    {
        this(rawValue + "");
    }


    /**
     * @param rawValue String
     */
    public SBDouble (String rawValue)
    {
        super(rawValue);
    }


    /**
     * @return double
     */
    public double doubleValue ()
    {
        Double value = Double.parseDouble(this.getRawValue());

        return value.doubleValue();
    }


    /**
     * @return int
     */
    public int intValue ()
    {
        Double value = Double.parseDouble(this.getRawValue());

        return value.intValue();
    }


    /**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return new JSONNumber(this.doubleValue());
    }
}
