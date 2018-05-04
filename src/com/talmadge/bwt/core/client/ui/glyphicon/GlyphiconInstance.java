package com.talmadge.bwt.core.client.ui.glyphicon;

import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.HtmlTag;

/**
 *
 */
public class GlyphiconInstance extends Html
{
	/**
	 * 
	 * @param icon Glyphicon
	 */
	public GlyphiconInstance (Glyphicon icon)
	{
		super(HtmlTag.SPAN);
		
		this.ensureCssName("glyphicon");
		this.ensureCssName(icon.getCssName());
	}
}
