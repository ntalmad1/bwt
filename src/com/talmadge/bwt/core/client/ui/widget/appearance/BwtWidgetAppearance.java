package com.talmadge.bwt.core.client.ui.widget.appearance;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.ResponsiveDisplay;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;

/**
 * 
 * @author Noah
 *
 */
public interface BwtWidgetAppearance
{
	/**
	 * 
	 * @param className String css class name to add
	 */
	void addClassName (String className);
	
	/**
	 * 
	 * @param element Element
	 */
	void append (Element element);
	
	/**
	 * 
	 */
	void clear ();

	/**
	 * 
	 * @param cssName String
	 */
	void ensureCssName (String cssName);

	/**
     * 
     * @return int
     */
	int getAbsoluteHeight ();

	/**
     * 
     * @return int
     */
    int getAbsoluteWidth ();

    /**
	 * 
	 * @return Element
	 */
	Element getElement ();
	
	/**
	 * 
	 * @return int
	 */
	int getHeight ();

	/**
	 * 
	 * @return int
	 */
    int getWidth ();

    /**
	 * 
	 * @param element Element
	 */
	void prepend (Element element);

	/**
	 * 
	 * @param centered boolean
	 */
	void setCentered (boolean centered);
	
	/**
	 * 
	 * @param left String 
	 */
	void setLeft (String left);

	/**
	 * 
	 * @param margin int
	 */
	void setMargin (int margin);

	/**
	 * 
	 * @param marginBottom int
	 */
	void setMarginBottom (int marginBottom);

	/**
	 * 
	 * @param marginLeft int
	 */
	void setMarginLeft (int marginLeft);

	/**
	 * 
	 * @param marginRight int
	 */
	void setMarginRight (int marginRight);

	/**
	 * 
	 * @param marginTop int
	 */
	void setMarginTop (int marginTop);
	
	/**
	 * 
	 * @param position Position
	 */
	void setPosition (Position position);

	/**
	 * 
	 * @param size Size
	 * @param display ResponsiveDisplay
	 */
	void setResponsiveDisplay (Size size, ResponsiveDisplay display);
	
	/**
	 * 
	 * @param top String
	 */
	void setTop (String top);
}
