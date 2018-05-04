package com.talmadge.bwt.java2html.client.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Markus Gebhard
 */
public final class JavaSourceConverterProvider
{
	/**
	 */
	@SuppressWarnings("serial")
	private static final List<IJavaSourceConverter> CONVERTERS = new ArrayList<IJavaSourceConverter>()
	{
		{
			add(new JavaSource2Xhtml11Converter());
		}
	};

	
	/**
	 * 
	 * @return String
	 */
	public static String getDefaultConverterName ()
	{
		return ((IJavaSourceConverter) CONVERTERS.get(0)).getMetaData()
				.getName().toLowerCase();
	}

	
	/**
	 * 
	 * @param name String
	 * @return IJavaSourceConverter
	 */
	public static IJavaSourceConverter getJavaSourceConverterByName (String name)
	{
		for (int i = 0; i < CONVERTERS.size(); ++i)
		{
			final IJavaSourceConverter converter = (IJavaSourceConverter) CONVERTERS
					.get(i);
			if ((converter).getMetaData().getName().equalsIgnoreCase(name))
			{
				return converter;
			}
		}
		return null;
	}


	/** 
	 * @see #getAllConverters()
	 * 
	 * @return String[]
	 */
	public static String[] getAllConverterNames ()
	{
		String[] names = new String[CONVERTERS.size()];
		for (int i = 0; i < names.length; ++i)
		{
			names[i] = ((IJavaSourceConverter) CONVERTERS.get(i)).getMetaData()
					.getName();
		}
		return names;
	}

	
	/**
	 * 
	 * @return IJavaSourceConverter[]
	 */
	public static IJavaSourceConverter[] getAllConverters ()
	{
		return (IJavaSourceConverter[]) CONVERTERS.toArray(new IJavaSourceConverter[CONVERTERS.size()]);
	}

	
	/**
	 * 
	 * @return String[]
	 */
	public static String[] getAllConverterPrintNames ()
	{
		String[] printNames = new String[CONVERTERS.size()];
		for (int i = 0; i < printNames.length; ++i)
		{
			printNames[i] = ((IJavaSourceConverter) CONVERTERS.get(i))
					.getMetaData().getPrintName();
		}
		return printNames;
	}
	
	
	/**
	 * Hidden Constructor
	 */
	private JavaSourceConverterProvider ()
	{
		
	}
}