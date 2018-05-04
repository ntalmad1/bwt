package com.talmadge.bwt.java2html.client.converter;

import java.io.IOException;

import com.talmadge.bwt.java2html.client.javasource.JavaSource;
import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.util.Ensure;
import com.talmadge.bwt.java2html.client.util.proxy.BufferedWriterProxy;

/**
 * Abstract superclass for all converters for converting a
 * JavaSource object to anything else.
 *
 * The Java2html home page is located at: <a
 * href="http://www.java2html.de">http://www.java2html.de</a>
 *
 * @author <a href="mailto:markus@jave.de">Markus Gebhard</a>
 * @version 2.0, 05/07/02
 *
 *          Copyright (C) Markus Gebhard 2000-2002
 *
 *          This program is free software; you can redistribute it and/or modify
 *          it under the terms of the GNU General Public License as published by
 *          the Free Software Foundation; either version 2 of the License, or
 *          (at your option) any later version.
 *
 *          This program is distributed in the hope that it will be useful, but
 *          WITHOUT ANY WARRANTY; without even the implied warranty of
 *          MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *          General Public License for more details.
 * 
 *          You should have received a copy of the GNU General Public License
 *          along with this program; if not, write to the Free Software
 *          Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *          02111-1307, USA.
 */
public abstract class AbstractJavaSourceConverter implements IJavaSourceConverter
{
	/**
	 */
	private final ConverterMetaData metaData;

	
	
	/**
	 * Constructor
	 *  
	 * @param metaData ConverterMetaData
	 */
	public AbstractJavaSourceConverter (ConverterMetaData metaData)
	{
		Ensure.ensureArgumentNotNull(metaData);
		this.metaData = metaData;
	}


//	/**
//	 * Is called to convert the object 'source' to the destination format. The
//	 * result is stored in 'result' and can be retrieved by calling getResult().
//	 * 
//	 * @param source JavaSource
//	 * @param options JavaSourceConversionOptions
//	 * @param writer Writer
//	 * @throws IOException exception e
//	 */
//	public final void convert (
//			  JavaSource source
//			, JavaSourceConversionOptions options
//			, Buffered writer) throws IOException
//	{
//		BufferedWriter bw = null;
//		try
//		{
//			bw = new BufferedWriter(writer);
//			convert(source, options, bw);
//			bw.flush();
//		}
//		catch (IOException e)
//		{
//			throw e;
//		}
//	}

	
	/**
	 * 
	 * @param source JavaSource
	 * @param options JavaSourceConversionOptions
	 * @param writer BufferedWriter
	 * @throws IOException e
	 */
	public abstract void convert (
			  JavaSource source
			, JavaSourceConversionOptions options
			, BufferedWriterProxy writer) throws IOException;


	/**
	 * Returns a header for the result document. This one will be placed before
	 * the first block of converted code. Subclasses can return an empty String
	 * (&quot;&quot;) if there is none neccessary.
	 * 
	 * @param options JavaSourceConversionOptions
	 * @param title String
	 * @return String
	 */
	public abstract String getDocumentHeader (JavaSourceConversionOptions options, String title);


	/**
	 * Returns a footer for the result document. This one will be placed behind
	 * the last block of converted code. Subclasses can return an empty String
	 * (&quot;&quot;) if there is none neccessary.
	 * 
	 * @param options JavaSourceConversionOptions 
	 * @return String
	 */
	public abstract String getDocumentFooter (JavaSourceConversionOptions options);


	/**
	 * Returns the code that has to be placed between two blocks of converted
	 * code. Subclasses can return an empty String (&quot;&quot;) if there is
	 * none neccessary.
	 * 
	 * @param options JavaSourceConversionOptions
	 * @return String
	 */
	public abstract String getBlockSeparator (JavaSourceConversionOptions options);

	
	/**
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @param title String
	 * @throws IOException e
	 */
	public void writeDocumentHeader (
			  BufferedWriterProxy writer
			, JavaSourceConversionOptions options
			, String title)	throws IOException
	{
		writer.write(getDocumentHeader(options, title));
	}

	
	/**
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @throws IOException e
	 */
	public void writeDocumentFooter (
			  BufferedWriterProxy writer
			, JavaSourceConversionOptions options) throws IOException
	{
		writer.write(getDocumentFooter(options));
	}

	
	/**
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @throws IOException e
	 */
	public void writeBlockSeparator (BufferedWriterProxy writer, JavaSourceConversionOptions options) throws IOException
	{
		writer.write(getBlockSeparator(options));
	}

	
	/**
	 * 
	 * @return String
	 */
	public final String getDefaultFileExtension ()
	{
		return metaData.getDefaultFileExtension();
	}

	
	/**
	 * 
	 * @return ConverterMetaData
	 */
	public final ConverterMetaData getMetaData ()
	{
		return metaData;
	}
}