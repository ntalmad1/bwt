package com.talmadge.bwt.core.client.ui.widget.container;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.style.Border;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface BwtWidgetContainerAppearance extends BwtWidgetAppearance
{
	/**
	 * @param widget Widget
	 */
	void add (Widget widget);
	
	/**
	 * @param widget Widget
	 * @param index int
	 */
	void insert (Widget widget, int index);

	/**
	 */
	void mask ();
	
	/**
	 */
	void mask (String message);
	
	/**
	 * @param widget Widget
	 * @return boolean true if the widget exists
	 */
	boolean remove (Widget widget);
	
	/**
	 * @param affix Affix
	 */
	void setAffix (Affix affix);
	
	/**
	 * 
	 * @param color String
	 */
    void setBackgroundColor (String color);

    /**
	 * @param border Border
	 */
	void setBorderBottom (Border border);

	/**
	 * @param border Border
	 */
	void setBorderLeft (Border border);

	/**
	 * @param border Border
	 */
	void setBorderRight (Border border);

	/**
	 * @param border Border
	 */
	void setBorderTop (Border border);

	/**
	 * @param centered boolean
	 */
	void setCentered (boolean centered);
	
	/**
	 * 
	 * @param align ContentAlign
	 */
	void setContentAlign (ContentAlign align);

    /**
	 * @param radius int
	 */
	void setCornerRadiusBottomLeft (int radius);

	/**
     * @param radius int
     */
    void setCornerRadiusBottomRight (int radius);

    /**
     * @param radius int
     */
    void setCornerRadiusTopLeft (int radius);

    /**
     * @param radius int
     */
    void setCornerRadiusTopRight (int radius);

    /**
	 * 
	 * @param display Display
	 */
	void setDisplay (Display display);

	/**
	 * @param width int
	 */
	void setMaxWidth (int width);
	
	/**
	 * @param height int
	 */
	void setMinHeight (int height);
	
	/**
	 * @param height String
	 */
	void setMinHeight (String height);

	/**
	 * 
	 * @param padding int
	 */
	void setPadding (int padding);
	
	/**
	 * 
	 * @param paddingBottom int
	 */
	void setPaddingBottom (int paddingBottom);
	
	/**
	 * @param paddingLeft int
	 */
	void setPaddingLeft (int paddingLeft);
	
	/**
	 * @param paddingRight int
	 */
	void setPaddingRight (int paddingRight);
	
	/**
	 * @param paddingTop int
	 */
	void setPaddingTop (int paddingTop);
	
	/**
	 * @param config ShadowConfig
	 */
	void setShadow (ShadowConfig config);

	/**
	 * @param alignment TextAlign
	 */
	void setTextAlign (TextAlign alignment);
	
	/**
	 * @param align VerticalAlign
	 */
	void setVerticalAlign (VerticalAlign align);
	
	/**
	 * 
	 */
	void unmask ();
}
