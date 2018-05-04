package com.talmadge.bwt.template.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTML;
import com.talmadge.bwt.core.client.json.JsonObject;


/**
 * @author Noah
 *
 */
public class Template extends JavaScriptObject
{
    /**
     *
     * @return String
     */
    public final String render ()
    {
        return this.render(JsonObject.create());
    }


    /**
     *
     * @param json Json the parameters
     * @return String
     */
    public final String render (JsonObject json)
    {
        return this._render(json.getJavaScriptObject());
    }
    
    
    /**
     *
     * @return HTML
     */
    public final HTML renderHtml ()
    {
        return new HTML(this.render());
    }


    /**
     *
     * @param  json Json
     * @return HTML
     */
    public final HTML renderHtml (JsonObject json)  
    {
        return new HTML(this.render(json));
    }


    /**
     * Hidden Constructor
     *
     */
    protected Template ()
    {

    }


    /**
     *
     * @param params JavaScriptObject
     * @return String
     */
    private native String _render (JavaScriptObject params) /*-{
        return this(params);
    }-*/;
}
