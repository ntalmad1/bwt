package com.talmadge.bwt.core.client.ui.widget.table.renderer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;

/**
 * 
 *
 * @param <T> extends JavaScriptObject
 */
public abstract class WidgetColumnRenderer<T extends JavaScriptObject> extends ColumnRenderer<T>
{
	/**
	 * 
	 * @param data String
	 * @param type String
	 * @param row T
	 */
	@Override
	public String render (String data, String type, T row)
	{
		String content = "";
		
		final Widget widget = this.renderWidget(data, type, row);

        if (widget != null)
        {
            final String domId = BwtWidgetUtils.uniqueId();

            content = "<div id='" + domId + "'></div>";

            Timer timer = new Timer()
            {
                public void run ()
                {
                    if (DOM.getElementById(domId) != null)
                    {
                        DOM.getElementById(domId).appendChild(widget.getElement());
                        BwtWidgetUtils.attachWidget(widget);
                    }
                    else
                    {
                        this.schedule(10);
                    }
                }
            };
            timer.schedule(10);
        }
        
        return content;
	}
	
	
	/**
	 * 
	 * @param data String
	 * @param type String
	 * @param row T
	 */
	public abstract Widget renderWidget (String data, String type, T row);

}
