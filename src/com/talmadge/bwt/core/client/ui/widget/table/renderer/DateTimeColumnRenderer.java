package com.talmadge.bwt.core.client.ui.widget.table.renderer;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.Window;


/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class DateTimeColumnRenderer<T extends JavaScriptObject> extends ColumnRenderer<T>
{
    /**
     */
    private static boolean toggle = true;
   
    
    /**
     * 2014-04-29T14:48:48.5000000
     */
    private static final DateTimeFormat defaultParser = DateTimeFormat.getFormat("yyyy-MM-ddTHH:mm:ss.SSS");
    
    /**
     * 
     */
    private static final DateTimeFormat defaultFormatter = DateTimeFormat.getFormat("MM/dd/yy h:mm a");

    
    
    /**
     * 
     * @param data String
     * @param type String
     * @param row T
     * @return String
     */
    public String render (String data, String type, T row)
    {
        if (toggle && !type.equals("display") && !type.equals("search") && !type.equals("filter"))
        {
            toggle = false;
            Window.alert(type);
        }
        
        
        Date date = defaultParser.parse(data);
        return defaultFormatter.format(date);
    }
    
    
}
