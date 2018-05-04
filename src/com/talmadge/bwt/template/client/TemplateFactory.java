/**
 *
 */
package com.talmadge.bwt.template.client;

import com.google.gwt.resources.client.TextResource;




/**
 * @author Noah
 *
 */
public final class TemplateFactory
{
    /**
     *
     * @param source String
     * @return Template
     */
    public static Template compile (String source)
    {
        Template template = TemplateFactory._compile(source);
        return template;
    }

    
	/**
	 * 
	 * @param source TextResource
	 * @return Template
	 */
	public static Template compile (TextResource source)
	{
		return TemplateFactory.compile(source.getText());
	}


    /**
     *
     * @param source String
     * @return Template
     */
    private static native Template _compile (String source) /*-{
        return $wnd.Handlebars.compile(source);
    }-*/;





    /**
     * Hidden Constructor
     *
     */
    private TemplateFactory ()
    {

    }
}
