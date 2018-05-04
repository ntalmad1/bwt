package com.talmadge.bwt.core.client.ui.widget.pageheader;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;


/**
 * @author Noah
 *
 */
public interface PageHeaderAppearance extends BwtWidgetAppearance
{
	/**
     * @param subtext String
     */
    void setSubtext (String subtext);

    /**
	 * @param align SubtextAlign
	 */
	void setSubtextAlign (BwtStyle.SubtextAlign align);

	/**
     * @param text String
     */
    void setText (String text);
}
