package com.talmadge.bwt.core.client.config.ini.dataobject;

import java.util.HashMap;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.talmadge.bwt.core.client.config.ConfigException;

/**
 * 
 */
@SuppressWarnings("serial")
public class SBDataObject extends HashMap<String, SBDataObject> implements DataObject
{
    /**
     * Constructor
     */
    public SBDataObject ()
    {
        super();
    }


    /**
     * Constructor
     * @param json JSONObject
     * @throws ConfigException e
     */
    public SBDataObject (JSONObject json) throws ConfigException
    {
        this();
        this.convert(json);
    }


    /**
     * Constructor
     * @param json JSONValue
     * @throws ConfigException error
     */
    public SBDataObject (JSONValue json) throws ConfigException
    {
        this((JSONObject) (json));
    }


    /**
     * @param data DataObject
     * @throws ConfigException error
     */
    public void absorb (DataObject data) throws ConfigException
    {
        this.absorb(data, false);
    }


    /**
     * @param incomingData DataObject
     * @param forceOverwrite boolean
     * @throws ConfigException error
     */
    public void absorb (DataObject incomingData, boolean forceOverwrite) throws ConfigException
    {
        if (incomingData == null)
        {
            return;
        }

        // these are the keys from the incoming data object
        String[] incomingKeys = incomingData.getKeys();

        // take each incoming key in step
        for (int i = 0; i < incomingKeys.length; ++i)
        {
            // key incoming from the dataobject to absorb
            String incomingKey = incomingKeys[i];

            /*
             * cases:
             *  1) this does not contain the incoming key - resolution: add the incoming key and done
             *  2) this contains the incoming key and both are object - resolution: recurse call absorb
             *  3) this contains the incoming key and force overwrite is true - resolution: replace exisiting with incoming
             *  4) this contains the incoming key, but force overwrite is false - resolution: do nothing
             *
             */
            if (!this.containsKey(incomingKey))
            {
                this.add(incomingKey, incomingData.get(incomingKey));
            }
            else if (this.containsKey(incomingKey)
                 && (!this.get(incomingKey).isValue() && !((SBDataObject) incomingData).get(incomingKey).isValue()))
            {
                // When this bad boy is a keyless array, just write it.
                if (incomingData.get(incomingKey).getClass().getName().equals(SBJSONArray.class.getName()))
                {
                    this.put(incomingKey, (SBDataObject) incomingData.get(incomingKey));
                }
                else
                {
                    this.get(incomingKey).absorb(incomingData.get(incomingKey), forceOverwrite);
                }
            }
            else if (this.containsKey(incomingKey) && forceOverwrite)
            {
                this.put(incomingKey, (SBDataObject) incomingData.get(incomingKey));
            }
            else
            {
                continue;
            }
        }
    }


    /**
     * @param keys String
     * @param value String
     * @throws ConfigException error
     */
    public void add (String keys, String value) throws ConfigException
    {
        if (keys.contains("."))
        {
            String[] parts = keys.split("\\.", 2);

            String left = parts[0];
            String right = parts[1];

            if (this.containsKey(left))
            {
                SBDataObject subData = (SBDataObject) (this.get(left));

                if (subData.isValue())
                {
                    throw new ConfigException("Trying to replace leaf with node.");
                }
                else
                {
                    subData.add(right, value);
                }
            }
            else
            {
                SBDataObject subData = new SBDataObject();
                subData.add(right, value);

                super.put(left, subData);
            }
        }
        else
        {
            super.put(keys, this.wrap(value));
        }
    }


    /**
     * @param keys String
     * @param value String
     * @throws ConfigException error
     */
    public void add (String keys, DataObject value) throws ConfigException
    {
        if (keys.contains("."))
        {
            String[] parts = keys.split("\\.", 2);

            String left = parts[0];
            String right = parts[1];

            if (this.containsKey(left))
            {
                SBDataObject subData = (SBDataObject) (this.get(left));

                if (subData.isValue())
                {
                    throw new ConfigException("Trying to replace leaf with node.");
                }
                else
                {
                    subData.add(right, value);
                }
            }
            else
            {
                SBDataObject subData = new SBDataObject();
                subData.add(right, value);

                super.put(left, subData);
            }
        }
        else
        {
            super.put(keys, (SBDataObject) value);
        }
    }

    /**
     * @param keys String
     * @return DataObject
     */
    public DataObject get (String keys)
    {
        return this.get(keys, this);
    }


    /**
     * @param keys String
     * @param data DataObjectdata
     * @return DataObject
     */
    public DataObject get (String keys, DataObject data)
    {
        try
        {
            if (keys.contains("."))
            {
                String[] parts = keys.split("\\.", 2);

                String left = parts[0];
                String right = parts[1];

                if (data.get(left) != null)
                {
                    return (data.get(left)).get(right, data.get(left));
                }
                else
                {
                    return new SBNull();
                }
            }
            else
            {
                return super.get(keys);
            }
        }
        catch (Exception e)
        {
            GWT.log(keys + " is not set.", e);

            return new SBNull();
        }

    }


    /**
     * @return String[]
     */
    public String[] getKeys ()
    {
        Set<String> keys = super.keySet();
        return keys.toArray(new String[]{});
    }


    /**
     * @return String
     */
    public String getRawValue ()
    {
        return null;
    }


    /**
     * @param key String
     * @return boolean
     */
    public boolean hasKey (String key)
    {
        try
        {
            if (key.contains("."))
            {
                String[] parts = key.split("\\.", 2);

                String left = parts[0];
                String right = parts[1];

                if (this.containsKey(left))
                {
                    return (this.get(left)).hasKey(right);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return super.containsKey(key);
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    
    /**
     * @return boolean
     */
    public boolean isNull ()
    {
        String className = this.getClass().getName();
        className = className.substring((className.lastIndexOf(".") + 1), className.length());

        return (className.equals("IniNull") || this instanceof SBNull);
    }


    /**
     * @return boolean
     */
    public boolean isValue ()
    {
        String className = this.getClass().getName();
        className = className.substring((className.lastIndexOf(".") + 1), className.length());

        return (className.equals("IniNull")
                || className.equals("IniDouble")
                || className.equals("IniInteger")
                || className.equals("IniString"));
    }


    /**
     *
     * @param key String
     */
    public void removeKey (String key)
    {
        if (this.containsKey(key))
        {
            this.remove(key);
        }
    }


    /**
     *
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        JSONObject json = new JSONObject();

        String[] keys = this.getKeys();

        for (int i = 0; i < keys.length; ++i)
        {
            String key = keys[i];

            SBDataObject dataObject = (SBDataObject) this.get(key);

            JSONValue jsonValue = JSONNull.getInstance();

            if (dataObject != null)
            {
                jsonValue = dataObject.toJson();
            }

            json.put(key, jsonValue);
        }

        return json;
    }


    /**
     * @param json JSONObject
     * @throws ConfigException e
     */
    protected void convert (JSONObject json) throws ConfigException
    {
        if (json == null)
        {
            return;
        }

        String[] keys = json.keySet().toArray(new String[]{});

        for (int i = 0; i < keys.length; ++i)
        {
            String key = keys[i];

            JSONValue jsonValue = json.get(key);

            if (jsonValue.isObject() != null)
            {
                this.add(key, new SBDataObject((JSONObject) jsonValue));
            }
            else
            {
                if (jsonValue.isString() != null)
                {
                    this.add(key, ((JSONString) jsonValue).stringValue());
                }
                else if (jsonValue.isNumber() != null)
                {
                    String numberString = jsonValue.isNumber() + "";

                    if (numberString.contains("."))
                    {
                        this.add(key, SBValue.newINIValue(((JSONNumber) jsonValue).doubleValue()));
                    }
                    else
                    {
                        this.add(key, SBValue.newINIValue((int) ((JSONNumber) jsonValue).doubleValue()));
                    }
                }
                else if (jsonValue.isBoolean() != null)
                {
                    this.add(key, SBValue.newINIValue(((JSONBoolean) jsonValue).booleanValue()));
                }
                else if (jsonValue.isNull() != null)
                {
                    this.add(key, new SBNull());
                }
                else if (jsonValue.isArray() != null)
                {
                    this.add(key, SBValue.newINIValue(jsonValue.isArray()));
                }

            }
        }
    }


    /**
     * @param value String
     * @return SBDataObject
     */
    protected SBDataObject wrap (String value)
    {
        return SBValue.newINIValue(value);
    }
}
