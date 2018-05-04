package com.talmadge.bwt.java2html.client.converter;

import java.io.IOException;

import com.talmadge.bwt.java2html.client.javasource.JavaSource;
import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.util.proxy.BufferedWriterProxy;

/**
 * @author Markus Gebhard
 */
public interface IJavaSourceConverter
{
	/**
	 * 
	 * @return ConverterMetaData
	 */
	ConverterMetaData getMetaData ();


	/**
	 * Returns the default filename extension for the output format of this
	 * converter, e.g. "html" or "tex".
	 * 
	 * @deprecated As of 25.01.2006 (Markus Gebhard), replaced by
	 *             {@link #getMetaData()},
	 *             {@link ConverterMetaData#getDefaultFileExtension()}
	 * 
	 * @return String
	 */
	String getDefaultFileExtension ();


	/**
	 * Converts the given source code to the giveen writer, using the specified
	 * conversion options.
	 * 
	 * @param source JavaSource 
	 * @param options JavaSourceConversionOptions
	 * @param writer BufferedWriterProxy
	 * @throws IOException if an output error occures while writing to the given writer.
	 */
	void convert (
			  JavaSource source
			, JavaSourceConversionOptions options
			, BufferedWriterProxy writer) throws IOException;


	/**
	 * 
	 * @param title An optional title (e.g. for the html title tag) or an empty
	 *            string or <code>null</code> if none.
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @throws IOException e
	 */
	void writeDocumentHeader (BufferedWriterProxy writer, JavaSourceConversionOptions options, String title) throws IOException;

	/**
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @throws IOException e
	 */
	void writeDocumentFooter (BufferedWriterProxy writer,
			JavaSourceConversionOptions options) throws IOException;

	
	/**
	 * 
	 * @param writer BufferedWriterProxy
	 * @param options JavaSourceConversionOptions
	 * @throws IOException e
	 */
	void writeBlockSeparator (BufferedWriterProxy writer,
			JavaSourceConversionOptions options) throws IOException;
}