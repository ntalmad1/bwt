package com.talmadge.bwt.java2html.client.options;

/**
 * @author Markus Gebhard
 */
public final class ConversionOptionsUtilities
{
	/**
	 * 
	 * @return String[]
	 */
	public static String[] getPredefinedStyleTableNames ()
	{
		JavaSourceStyleTable[] tables = JavaSourceStyleTable
				.getPredefinedTables();
		String[] names = new String[tables.length];
		for (int i = 0; i < tables.length; i++)
		{
			names[i] = tables[i].getName();
		}
		return names;
	}

	/**
	 * 
	 * @return String
	 */
	public static String getPredefinedStyleTableNameString ()
	{
		String[] names = getPredefinedStyleTableNames();
		return ConversionOptionsUtilities.getCommaSeparatedString(names);
	}

	/**
	 * 
	 * @return String[]
	 */
	public static String[] getAvailableHorizontalAlignmentNames ()
	{
		HorizontalAlignment[] tables = HorizontalAlignment.getAll();
		String[] names = new String[tables.length];
		for (int i = 0; i < tables.length; i++)
		{
			names[i] = tables[i].getName();
		}
		return names;
	}


	/**
	 * 
	 * @return String
	 */
	public static String getAvailableHorizontalAlignmentNameString ()
	{
		String[] names = getAvailableHorizontalAlignmentNames();
		return ConversionOptionsUtilities.getCommaSeparatedString(names);
	}

	
	/**
	 * 
	 * @param names String[]
	 * @return String
	 */
	private static String getCommaSeparatedString (String[] names)
	{
		return getSeparatedString(names, ", ");
	}

	
	/**
	 * 
	 * @param strings String[]
	 * @param separator String
	 * @return String
	 */
	public static String getSeparatedString (String[] strings, String separator)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strings.length; i++)
		{
			if (i > 0)
			{
				sb.append(separator);
			}
			sb.append(strings[i]);
		}
		return sb.toString();
	}

	
	/**
	 * Hidden Constructor
	 * 
	 */
	private ConversionOptionsUtilities ()
	{
		// nothing to do
	}
}