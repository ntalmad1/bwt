package com.talmadge.bwt.java2html.client.javasource;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An object for iterating a {@link JavaSource} object by getting connected
 * pieces of Java source code having the same type. Line breaks are omitted, but
 * empty lines will be covered.
 * 
 * @see JavaSourceRun
 */
public class JavaSourceIterator implements Iterator<JavaSourceRun>
{
	/**
	 */
	private int startIndex;

	/**
	 */
	private int endIndex;

	/**
	 */
	private JavaSource javaSource;

	/**
	 */
	private boolean finished;

	/**
	 */
	private boolean isNewLine;

	
	/**
	 * 
	 * @param javaSource JavaSource
	 */
	public JavaSourceIterator (JavaSource javaSource)
	{
		this.javaSource = javaSource;
		finished = false;
		isNewLine = false;
		startIndex = 0;
		endIndex = 0;
		if (javaSource.getCode().length() == 0)
		{
			finished = true;
		}
	}

	
	/**
	 * 
	 * @return false
	 */
	public boolean hasNext ()
	{
		return !finished;
	}

	
	/**
	 * 
	 * @return JavaSourceRun
	 * @throws NoSuchElementException e
	 */
	public JavaSourceRun getNext () throws NoSuchElementException
	{
		if (finished)
		{
			throw new NoSuchElementException();
		}
		seekToNext();

		// Sonderfall: Hinter abschliessendem Newline in letzer Zeile ("\r\n")
		if (startIndex >= javaSource.getCode().length())
		{
			--startIndex;
			--endIndex;
		}
		JavaSourceRun run = new JavaSourceRun(javaSource, startIndex, endIndex);
		finished = endIndex == javaSource.getCode().length();
		return run;
	}

	
	/**
	 * 
	 * @return JavaSourceRun
	 * @throws NoSuchElementException e
	 */
	public JavaSourceRun next () throws NoSuchElementException
	{
		return getNext();
	}

	
	/**
	 * 
	 */
	public void remove ()
	{
		// nothing to do
	}

	
	/**
	 * 
	 */
	private void seekToNext ()
	{
		if (isNewLine)
		{
			startIndex = endIndex + 2;
			endIndex = startIndex + 1;
			isNewLine = false;
		}
		else
		{
			startIndex = endIndex;
			endIndex = startIndex + 1;
		}
	
		if (endIndex > javaSource.getCode().length())
		{
			--endIndex;
		}
	
		// System.out.println(startIndex+".."+endIndex);
	
		while (true)
		{
			if (endIndex == javaSource.getCode().length())
			{
				// System.out.println("1");
				break;
			}
			if (endIndex <= javaSource.getCode().length() - 1
					&& javaSource.getCode().charAt(endIndex) == '\n')
			{
				--endIndex;
	
				isNewLine = true;
				// System.out.println("2");
				break;
			}
			if (javaSource.getClassification()[endIndex] != javaSource
					.getClassification()[startIndex]
					&& javaSource.getClassification()[endIndex] != JavaSourceType.BACKGROUND)
			{
				// System.out.println("3");
				break;
			}
			// System.out.println("+");
	
			++endIndex;
		}
		// System.out.println("=>"+startIndex+".."+endIndex);
	}
}