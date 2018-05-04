package com.talmadge.bwt.java2html.client.options;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.talmadge.bwt.java2html.client.javasource.JavaSourceType;
import com.talmadge.bwt.java2html.client.util.RGB;

/**
 * Table containing style options (
 * {@link de.java2html.options.JavaSourceStyleEntry}) for different types of
 * source code ({@link de.java2html.javasource.JavaSourceType}).
 * 
 * @author Markus Gebhard
 */
public final class JavaSourceStyleTable
{	
	/**
	 */
	private static JavaSourceStyleEntry defaultColorEntry = new JavaSourceStyleEntry(
			RGB.BLACK);

	/**
	 * Gets a default style table.
	 * 
	 * @see #getDefaultEclipseStyleTable()
	 * @see #getDefaultKawaStyleTable()
	 * 
	 * @return  JavaSourceStyleTable
	 */
	public static JavaSourceStyleTable getDefault ()
	{
		return createDefaultEclipseStyleTable();
	}


	/**
	 * Gets a style table similar to the one from the Kawa IDE.
	 * 
	 * @see #getDefault()
	 * @see #getDefaultEclipseStyleTable()
	 * @see #getDefaultMonochromeStyleTable()
	 * 
	 * @return JavaSourceStyleTable
	 */
	public static JavaSourceStyleTable getDefaultKawaStyleTable ()
	{
		return createDefaultKawaStyleTable();
	}


	/**
	 * Gets a style table similar to the one from the IBM Eclipse IDE.
	 * 
	 * @see #getDefault()
	 * @see #getDefaultKawaStyleTable()
	 * @see #getDefaultMonochromeStyleTable()
	 * 
	 * @return JavaSourceStyleTable
	 */
	public static JavaSourceStyleTable getDefaultEclipseStyleTable ()
	{
		return createDefaultEclipseStyleTable();
	}


	/**
	 * Gets a style table for monochromatic output.
	 * 
	 * @see #getDefault()
	 * @see #getDefaultEclipseStyleTable()
	 * @see #getDefaultKawaStyleTable()
	 * 
	 * @return JavaSourceStyleTable
	 */
	public static JavaSourceStyleTable getDefaultMonochromeStyleTable ()
	{
		return createDefaultMonochromeStyleTable();
	}

	
	/**
	 * 
	 * @return JavaSourceStyleTable[]
	 */
	public static JavaSourceStyleTable[] getPredefinedTables ()
	{
		return new JavaSourceStyleTable[] { createDefaultEclipseStyleTable(),
				createDefaultKawaStyleTable(),
				createDefaultMonochromeStyleTable(), };
	}


	/**
	 * Returns the style table with the given name or <code>null</code> if there
	 * is none having the give name.
	 * 
	 * @param name String
	 * @return JavaSourceStyleTable
	 * @throws IllegalArgumentException if the name is null.
	 */
	public static JavaSourceStyleTable getPredefinedTable (String name)
	{
		if (name == null)
		{
			throw new IllegalArgumentException("name is null."); //$NON-NLS-1$
		}
		JavaSourceStyleTable[] tables = getPredefinedTables();
		for (int i = 0; i < tables.length; ++i)
		{
			if (tables[i].getName().equalsIgnoreCase(name))
			{
				return tables[i];
			}
		}
		return null;
	}

	/**
	 * 
	 * @return JavaSourceStyleTable
	 */
	private static JavaSourceStyleTable createDefaultKawaStyleTable ()
	{
		JavaSourceStyleTable table = new JavaSourceStyleTable("Kawa"); //$NON-NLS-1$
		table.put(JavaSourceType.UNDEFINED, new JavaSourceStyleEntry(new RGB(
				255, 97, 0)));
		table.put(JavaSourceType.CODE, new JavaSourceStyleEntry(RGB.BLACK));
		table.put(JavaSourceType.KEYWORD, new JavaSourceStyleEntry(new RGB(0,
				0, 192), true, false));
		table.put(JavaSourceType.CODE_TYPE, new JavaSourceStyleEntry(new RGB(
				192, 0, 0), true, false));
		table.put(JavaSourceType.STRING, new JavaSourceStyleEntry(new RGB(153,
				0, 0))); // darker
		// red
		table.put(JavaSourceType.COMMENT_LINE, new JavaSourceStyleEntry(
				new RGB(0, 128, 0))); // green
		table.put(JavaSourceType.COMMENT_BLOCK, new JavaSourceStyleEntry(
				new RGB(0, 128, 0))); // green
		table.put(JavaSourceType.JAVADOC, new JavaSourceStyleEntry(new RGB(0,
				128, 0))); // green
		table.put(JavaSourceType.JAVADOC_KEYWORD, new JavaSourceStyleEntry(
				new RGB(0, 85, 0)));
		// dark green
		// set.put(JavaSourceType.BACKGROUND, new JavaSourceStyleEntry(new
		// Color(255,251,240)));
		table.put(JavaSourceType.BACKGROUND, new JavaSourceStyleEntry(new RGB(
				255, 255, 255)));
		table.put(JavaSourceType.NUM_CONSTANT, new JavaSourceStyleEntry(
				new RGB(153, 0, 0)));
		// dark red
		table.put(JavaSourceType.CHAR_CONSTANT, new JavaSourceStyleEntry(
				new RGB(153, 0, 0)));
		// dark red
		table.put(JavaSourceType.PARENTHESIS, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.JAVADOC_HTML_TAG, new JavaSourceStyleEntry(
				new RGB(0, 128, 0)));
		table.put(JavaSourceType.JAVADOC_LINKS, new JavaSourceStyleEntry(
				new RGB(0, 128, 0)));
		table.put(JavaSourceType.getLineNumbers(), new JavaSourceStyleEntry(
				new RGB(128, 128, 128)));
		table.put(JavaSourceType.ANNOTATION, new JavaSourceStyleEntry(new RGB(
				100, 100, 100)));
		return table;
	}
	
	/**
	 * 
	 * @return JavaSourceStyleTable
	 */
	private static JavaSourceStyleTable createDefaultEclipseStyleTable ()
	{
		JavaSourceStyleTable table = new JavaSourceStyleTable("Eclipse"); //$NON-NLS-1$
		table.put(JavaSourceType.CODE, new JavaSourceStyleEntry(RGB.BLACK));
		table.put(JavaSourceType.KEYWORD, new JavaSourceStyleEntry(new RGB(127,
				0, 85), true, false));
		table.put(JavaSourceType.CODE_TYPE, new JavaSourceStyleEntry(new RGB(
				127, 0, 85), true, false));
		table.put(JavaSourceType.STRING, new JavaSourceStyleEntry(new RGB(42,
				0, 255)));
		table.put(JavaSourceType.COMMENT_LINE, new JavaSourceStyleEntry(
				new RGB(63, 127, 95)));
		table.put(JavaSourceType.COMMENT_BLOCK, new JavaSourceStyleEntry(
				new RGB(63, 127, 95)));
		table.put(JavaSourceType.JAVADOC, new JavaSourceStyleEntry(new RGB(63,
				95, 191)));
		table.put(JavaSourceType.JAVADOC_KEYWORD, new JavaSourceStyleEntry(
				new RGB(127, 159, 191)));
		table.put(JavaSourceType.NUM_CONSTANT, new JavaSourceStyleEntry(
				new RGB(153, 0, 0)));
		table.put(JavaSourceType.CHAR_CONSTANT, new JavaSourceStyleEntry(
				new RGB(153, 0, 0)));
		table.put(JavaSourceType.PARENTHESIS, new JavaSourceStyleEntry(new RGB(
				0, 0, 0)));
		table.put(JavaSourceType.JAVADOC_HTML_TAG, new JavaSourceStyleEntry(
				new RGB(127, 127, 159)));
		table.put(JavaSourceType.JAVADOC_LINKS, new JavaSourceStyleEntry(
				new RGB(63, 63, 191)));
		table.put(JavaSourceType.UNDEFINED, new JavaSourceStyleEntry(new RGB(
				255, 97, 0)));
		table.put(JavaSourceType.BACKGROUND, new JavaSourceStyleEntry(new RGB(
				255, 255, 255)));
		table.put(JavaSourceType.getLineNumbers(), new JavaSourceStyleEntry(
				new RGB(128, 128, 128)));
		table.put(JavaSourceType.ANNOTATION, new JavaSourceStyleEntry(new RGB(
				100, 100, 100)));
		return table;
	}

	/**
	 * 
	 * @return JavaSourceStyleTable
	 */
	private static JavaSourceStyleTable createDefaultMonochromeStyleTable ()
	{
		JavaSourceStyleTable table = new JavaSourceStyleTable("Monochrome"); //$NON-NLS-1$
		table.put(JavaSourceType.CODE, new JavaSourceStyleEntry(RGB.BLACK));
		table.put(JavaSourceType.KEYWORD, new JavaSourceStyleEntry(RGB.BLACK,
				true, false));
		table.put(JavaSourceType.CODE_TYPE, new JavaSourceStyleEntry(RGB.BLACK,
				true, false));
		table.put(JavaSourceType.STRING, new JavaSourceStyleEntry(RGB.BLACK));
		table.put(JavaSourceType.COMMENT_LINE, new JavaSourceStyleEntry(
				RGB.BLACK, false, true));
		table.put(JavaSourceType.COMMENT_BLOCK, new JavaSourceStyleEntry(
				RGB.BLACK, false, true));
		table.put(JavaSourceType.JAVADOC, new JavaSourceStyleEntry(RGB.BLACK,
				false, true));
		table.put(JavaSourceType.JAVADOC_KEYWORD, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.NUM_CONSTANT, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.CHAR_CONSTANT, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.PARENTHESIS, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.JAVADOC_HTML_TAG, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.JAVADOC_LINKS, new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.UNDEFINED, new JavaSourceStyleEntry(RGB.BLACK));
		table.put(JavaSourceType.BACKGROUND,
				new JavaSourceStyleEntry(RGB.WHITE));
		table.put(JavaSourceType.getLineNumbers(), new JavaSourceStyleEntry(
				RGB.BLACK));
		table.put(JavaSourceType.ANNOTATION,
				new JavaSourceStyleEntry(RGB.BLACK));
		return table;
	}

	
	/**
	 */
	private String name;

	/**
	 */
	@SuppressWarnings("rawtypes")
	private final Map table = new HashMap();

	
	
	/**
	 * Constructor
	 * 
	 * @param name String
	 */
	private JavaSourceStyleTable (String name)
	{
		this.setName(name);
	}

	
	/**
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	public boolean equals (Object obj)
	{
		if (!(obj instanceof JavaSourceStyleTable))
		{
			return false;
		}
		JavaSourceStyleTable other = (JavaSourceStyleTable) obj;

		if (!name.equals(other.name))
		{
			return false;
		}
		if (other.table.size() != table.size())
		{
			return false;
		}

		@SuppressWarnings("rawtypes")
		Iterator iterator = table.keySet().iterator();
		while (iterator.hasNext())
		{
			String key = (String) iterator.next();
			JavaSourceStyleEntry value = get(key);
			if (!value.equals(other.table.get(key)))
			{
				return false;
			}
		}
		return true;
	}

	
	/**
	 * 
	 * @return JavaSourceStyleTable
	 */
	@SuppressWarnings("unchecked")
	public JavaSourceStyleTable getClone ()
	{
		JavaSourceStyleTable clone = new JavaSourceStyleTable(getName());
		
		@SuppressWarnings("rawtypes")
		Iterator iterator = table.keySet().iterator();
		while (iterator.hasNext())
		{
			String key = (String) iterator.next();
			JavaSourceStyleEntry value = get(key);
			clone.table.put(key, value);
		}
		return clone;
	}


	/**
	 * Returns the style for the given source type defined by this styletable.
	 * 
	 * @see #put(JavaSourceType, JavaSourceStyleEntry)
	 * @see #put(JavaSourceType, JavaSourceStyleEntry)
	 * 
	 * @param key JavaSourceType
	 * @return JavaSourceStyleEntry
	 */
	public JavaSourceStyleEntry get (JavaSourceType key)
	{
		return get(key.getName());
	}


	/**
	 * 
	 * @deprecated As of Sep 12, 2004 (Markus Gebhard), replaced by
	 *             {@link #get(JavaSourceType)}
	 * 
	 * @param key String
	 * @return JavaSourceStyleEntry
	 */
	public JavaSourceStyleEntry get (String key)
	{
		JavaSourceStyleEntry e = (JavaSourceStyleEntry) table.get(key);
		return e == null ? defaultColorEntry : e;
	}


	/**
	 * Sets the style for the given source type to the given style.
	 * 
	 * @see #get(JavaSourceType)
	 * 
	 * @param key JavaSourceType
	 * @param javaSourceStyleEntry JavaSourceStyleEntry
	 */ 
	public void put (JavaSourceType key,
			JavaSourceStyleEntry javaSourceStyleEntry)
	{
		put(key.getName(), javaSourceStyleEntry);
	}

	
	/**
	 * 
	 * @param key String
	 * @param javaSourceStyleEntry JavaSourceStyleEntry
	 */
	@SuppressWarnings("unchecked")
	public void put (String key, JavaSourceStyleEntry javaSourceStyleEntry)
	{
		table.put(key, javaSourceStyleEntry);
	}


	/**
	 * 
	 * @return String
	 */
	public String getName ()
	{
		return name;
	}


	/**
	 * @deprecated As of Jan 2, 2004 (Markus Gebhard): Changing the name of a
	 *             style table is not intended
	 * 
	 * @param name String
	 */
	public void setName (String name)
	{
		this.name = name;
	}
}