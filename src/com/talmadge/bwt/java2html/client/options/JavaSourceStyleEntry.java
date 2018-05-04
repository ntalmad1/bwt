package com.talmadge.bwt.java2html.client.options;

import com.talmadge.bwt.java2html.client.util.HtmlUtilities;
import com.talmadge.bwt.java2html.client.util.RGB;

/**
 * Object defining color and other style options for output.
 * 
 * @author Markus Gebhard
 */
public class JavaSourceStyleEntry
{	
	/**
	 */
	private RGB color;

	/**
	 */
	private String htmlColor;

	/**
	 */
	private boolean bold;

	/**
	 */
	private boolean italic;

	
	/**
	 * Constructor 
	 *
	 * @param color RGB
	 */
	public JavaSourceStyleEntry (RGB color)
	{
		this(color, false, false);
	}

	
	/**
	 * Constructor 
	 *
	 * @param color RGB
	 * @param bold boolean
	 * @param italic boolean
	 */
	public JavaSourceStyleEntry (RGB color, boolean bold, boolean italic)
	{
		this.color = color;
		this.italic = italic;
		this.bold = bold;
	}

	
	/**
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	public boolean equals (Object obj)
	{
		if (!(obj instanceof JavaSourceStyleEntry))
		{
			return false;
		}
		JavaSourceStyleEntry other = (JavaSourceStyleEntry) obj;
		return color.equals(other.color) && bold == other.bold
				&& italic == other.italic;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int hashCode ()
	{
		return color.hashCode();
	}


	/**
	 * @deprecated As of Dec 21, 2003 (Markus Gebhard): object is immutable and
	 *             cloning not necessary.
	 * 
	 * @return  JavaSourceStyleEntry
	 */
	public JavaSourceStyleEntry getClone ()
	{
		return new JavaSourceStyleEntry(color, bold, italic);
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getHtmlColor ()
	{
		if (htmlColor == null)
		{
			htmlColor = HtmlUtilities.toHTML(getColor());
		}
		return htmlColor;
	}


	/**
	 * 
	 * @return RGB
	 */
	public RGB getColor ()
	{
		return color;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isBold ()
	{
		return bold;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isItalic ()
	{
		return italic;
	}
}