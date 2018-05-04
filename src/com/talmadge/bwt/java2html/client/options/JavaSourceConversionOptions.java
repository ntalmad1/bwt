package com.talmadge.bwt.java2html.client.options;

import com.talmadge.bwt.java2html.client.util.Ensure;
import com.talmadge.bwt.java2html.client.util.IllegalConfigurationException;

/**
 * Conversion options for customizing the output result. You can adjust the
 * output style of a {@link de.java2html.converter.AbstractJavaSourceConverter}
 * by changing the attributes of this object. The color and font style are
 * defined by the {@link de.java2html.options.JavaSourceStyleTable} associated
 * with this options.
 * 
 * @see #setStyleTable(JavaSourceStyleTable)
 * @see #getStyleTable()
 * @see de.java2html.converter.AbstractJavaSourceConverter
 * 
 * @author <a href="mailto:markus@jave.de">Markus Gebhard</a>
 * 
 *         <code>Copyright (C) Markus Gebhard 2000-2003
 * 
 * This program is free software; you can redistribute it and/or
 *  * modify it under the terms of the GNU General Public License
 *  * as published by the Free Software Foundation; either version 2
 *  * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 *  * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.</code>
 */
public final class JavaSourceConversionOptions
{
	/**
	 * @deprecated As of Dec 21, 2003 (Markus Gebhard), replaced by
	 *             {@link IConversionOptionsConstants#TAB_SIZE}
	 */
	public static final String TAB_SIZE = IConversionOptionsConstants.TAB_SIZE;

	/**
	 * @deprecated As of Dec 21, 2003 (Markus Gebhard), replaced by
	 *             {@link IConversionOptionsConstants#SHOW_LINE_NUMBERS}
	 */
	public static final String SHOW_LINE_NUMBERS = IConversionOptionsConstants.SHOW_LINE_NUMBERS;

	/**
	 * @deprecated As of Dec 21, 2003 (Markus Gebhard), replaced by
	 *             {@link IConversionOptionsConstants#SHOW_FILE_NAME}
	 */
	public static final String SHOW_FILE_NAME = IConversionOptionsConstants.SHOW_FILE_NAME;

	/**
	 * @deprecated As of Dec 21, 2003 (Markus Gebhard), replaced by
	 *             {@link IConversionOptionsConstants#SHOW_TABLE_BORDER}
	 */
	public static final String SHOW_TABLE_BORDER = IConversionOptionsConstants.SHOW_TABLE_BORDER;

	/**
	 */
	private static JavaSourceConversionOptions defaultOptions;


	/**
	 * 
	 * @return JavaSourceConversionOptions
	 */
	public static JavaSourceConversionOptions getRawDefault ()
	{
		return new JavaSourceConversionOptions();
	}

	/**
	 * 
	 * @return JavaSourceConversionOptions
	 * @throws IllegalConfigurationException e
	 */
	public static JavaSourceConversionOptions getDefault ()
			throws IllegalConfigurationException
	{
		if (defaultOptions == null)
		{
			defaultOptions = createDefaultOptions();
		}
		return defaultOptions.getClone();
	}

	
	/**
	 * 
	 * @return JavaSourceConversionOptions
	 * @throws IllegalConfigurationException e
	 */
	private static JavaSourceConversionOptions createDefaultOptions () throws IllegalConfigurationException
	{
		return new JavaSourceConversionOptions();
	}
	
	/**
	 */
	private JavaSourceStyleTable styleTable = JavaSourceStyleTable.getDefault();
	
	/**
	 */
	private int tabSize = 2;

	/**
	 */
	private boolean showLineNumbers = false;

	/**
	 */
	private boolean showFileName = false;

	/**
	 */
	private boolean showTableBorder = false;

	/**
	 * Flag indication whether html output contains a link to the
	 * Java2Html-Homepage or not.
	 */
	private boolean showJava2HtmlLink = false;

	/**
	 */
	private boolean addLineAnchors = false;

	/**
	 */
	private String lineAnchorPrefix = ""; //$NON-NLS-1$

	/**
	 */
	private HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEFT;

	
	/**
	 * Hidden Constructor 
	 *
	 */
	private JavaSourceConversionOptions ()
	{
		
	}

	
	/**
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	public boolean equals (Object obj)
	{
		if (!(obj instanceof JavaSourceConversionOptions))
		{
			return false;
		}
		JavaSourceConversionOptions other = (JavaSourceConversionOptions) obj;
		return (other.tabSize == tabSize && other.styleTable.equals(styleTable)
				&& other.showFileName == showFileName
				&& other.showJava2HtmlLink == showJava2HtmlLink
				&& other.showLineNumbers == showLineNumbers
				&& other.showTableBorder == showTableBorder && other.horizontalAlignment == horizontalAlignment);
	}

	
	/**
	 * 
	 * @return int
	 */
	public int hashCode ()
	{
		return styleTable.hashCode() + tabSize;
	}

	
	/**
	 * 
	 * @return JavaSourceConversionOptions
	 */
	public JavaSourceConversionOptions getClone ()
	{
		JavaSourceConversionOptions options = new JavaSourceConversionOptions();
		options.styleTable = styleTable.getClone();
		options.tabSize = tabSize;
		options.showLineNumbers = showLineNumbers;
		options.showFileName = showFileName;
		options.showJava2HtmlLink = showJava2HtmlLink;
		options.showTableBorder = showTableBorder;
		options.horizontalAlignment = horizontalAlignment;
		return options;
	}

	
	/**
	 * 
	 * @param styleTable JavaSourceStyleTable
	 */
	public void setStyleTable (JavaSourceStyleTable styleTable)
	{
		Ensure.ensureArgumentNotNull(styleTable);
		this.styleTable = styleTable;
	}

	
	/**
	 * 
	 * @return JavaSourceStyleTable
	 */
	public JavaSourceStyleTable getStyleTable ()
	{
		return styleTable;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getTabSize ()
	{
		return tabSize;
	}

	
	/**
	 * 
	 * @param tabSize int
	 */
	public void setTabSize (int tabSize)
	{
		this.tabSize = tabSize;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isShowLineNumbers ()
	{
		return showLineNumbers;
	}

	
	/**
	 * 
	 * @param showLineNumbers boolean
	 */
	public void setShowLineNumbers (boolean showLineNumbers)
	{
		this.showLineNumbers = showLineNumbers;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isShowFileName ()
	{
		return showFileName;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isShowTableBorder ()
	{
		return showTableBorder;
	}

	
	/**
	 * 
	 * @param showFileName boolean
	 */
	public void setShowFileName (boolean showFileName)
	{
		this.showFileName = showFileName;
	}

	
	/**
	 * 
	 * @param showTableBorder boolean
	 */
	public void setShowTableBorder (boolean showTableBorder)
	{
		this.showTableBorder = showTableBorder;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAddLineAnchors ()
	{
		return addLineAnchors;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLineAnchorPrefix ()
	{
		return lineAnchorPrefix;
	}

	
	/**
	 * 
	 * @param addLineAnchors boolean
	 */
	public void setAddLineAnchors (boolean addLineAnchors)
	{
		this.addLineAnchors = addLineAnchors;
	}

	
	/**
	 * 
	 * @param lineAnchorPrefix String
	 */
	public void setLineAnchorPrefix (String lineAnchorPrefix)
	{
		this.lineAnchorPrefix = lineAnchorPrefix;
	}

	
	/**
	 * 
	 * @return HorizontalAlignment
	 */
	public HorizontalAlignment getHorizontalAlignment ()
	{
		return horizontalAlignment;
	}

	
	/**
	 * 
	 * @param horizontalAlignment HorizontalAlignment
	 */
	public void setHorizontalAlignment (HorizontalAlignment horizontalAlignment)
	{
		Ensure.ensureArgumentNotNull(horizontalAlignment);
		this.horizontalAlignment = horizontalAlignment;
	}

	
	/**
	 * 
	 * @return isShowJava2HtmlLink
	 */
	public boolean isShowJava2HtmlLink ()
	{
		return showJava2HtmlLink;
	}

	
	/**
	 * 
	 * @param isShowJava2HtmlLink boolean
	 */
	public void setShowJava2HtmlLink (boolean isShowJava2HtmlLink)
	{
		this.showJava2HtmlLink = isShowJava2HtmlLink;
	}
}