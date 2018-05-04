package com.talmadge.bwt.core.client.ui.widget.html.list;

import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface AbstractListAppearance extends HtmlAppearance
{
	/**
	 * 
	 * @param isInline boolean
	 */
	void setInline (boolean isInline);

	/**
	 * 
	 * @param isStyled boolean
	 */
	void setStyled (boolean isStyled);

}
