package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONValue;
import com.talmadge.bwt.core.client.config.ConfigException;



/**
 * 
 */
public interface DataObject
{
    /**
     * @param sourceData DataObject
     * @throws ConfigException error
     */
    void absorb (DataObject sourceData) throws ConfigException;


    /**
     * @param sourceData DataObject
     * @param force boolean
     * @throws ConfigException error
     */
    void absorb (DataObject sourceData, boolean force) throws ConfigException;


    /**
     * @param key String
     * @return DataObject
     */
    DataObject get (String key);


    /**
     * @param keys String
     * @param value DataObject
     * @throws ConfigException error
     */
    void add (String keys, DataObject value)throws ConfigException;


    /**
     * @param key String
     * @param data DataObject
     * @return DataObject
     */
    DataObject get (String key, DataObject data);


    /**
     * @param keys String
     * @param value String
     * @throws ConfigException error
     */
    void add (String keys, String value) throws ConfigException;


    /**
     * @return String[]
     */
    String[] getKeys ();


    /**
     * @return String
     */
    String getRawValue ();

    /**
     * @return boolean
     */
    boolean isNull ();


    /**
     * @return boolean
     */
    boolean isValue ();


    /**
     * @param key String
     * @return boolean
     */
    boolean hasKey (String key);


    /**
     * @param key String
     */
    void removeKey (String key);


    /**
     *
     * @return JSONValue
     */
    JSONValue toJson ();
}
