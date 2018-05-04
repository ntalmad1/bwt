package com.talmadge.bwt.java2html.client.converter;

import java.io.IOException;

import com.talmadge.bwt.java2html.client.javasource.JavaSource;
import com.talmadge.bwt.java2html.client.javasource.JavaSourceType;
import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.options.JavaSourceStyleTable;
import com.talmadge.bwt.java2html.client.util.proxy.BufferedWriterProxy;


/**
 * @author Markus Gebhard
 * @author Christian Hujer (adaption to XHTML 1.1)
 */
public class JavaSource2Xhtml11Converter extends AbstractJavaSourceToXmlConverter
{
	/**
	 */
	private static final String XHTML_FOOTER = "</body>\n</html>";

	/**
	 */
	private static final String XHTML_HEADER_END = "</head>\n<body>\n";

	
	/**
	 * Constructor
	 * 
	 */
	public JavaSource2Xhtml11Converter ()
	{
		super(new ConverterMetaData("xhtml11", "XHTML 1.1 (with stylesheet)",
				"xhtml"));
	}

	
	/**
	 * 
	 * @param source JavaSource
	 * @param options JavaSourceConversionOptions
	 * @param writer BufferedWriter
	 * @throws IOException e
	 */
	public void convert (
			  JavaSource source
			, JavaSourceConversionOptions options
			, BufferedWriterProxy writer) throws IOException 
	{
		if (source == null)
		{
			throw new IllegalStateException(
					"Trying to write out converted code without having source set.");
		}
	
		String sourceCode = source.getCode();
		JavaSourceType[] sourceTypes = source.getClassification();
	
		if (this.getLineNumbers())
		{
			writer.write("<table class=\"java\">\n<tr class=\"java\">\n<td valign=\"top\" class=\"java-ln\">");
			writer.newLine();
	
			if (this.getPre())
			{
				writer.write("<pre class=\"java-ln\">");
			}
			else
			{
				writer.write("<code class=\"java-ln\">");
			}
			for (int i = 1; i <= source.getLineCount(); i++)
			{
				writer.write(String.valueOf(i) + this.getLineEnd());
				writer.newLine();
			}
			
			// sb.append(new Integer(source.getLineCount()).toString());
	
			if (this.getPre())
			{
				writer.write("</pre>\n");
			}
			else
			{
				writer.write("</code>\n");
			}
			writer.write("</td>\n");
			writer.write("<td valign=\"top\" class=\"java\">");
			writer.newLine();
		}
	
		else if (this.getPre())
		{
			writer.write("<pre class=\"java\">");
		}
		else
		{
			writer.write("<div class=\"java\"><code class=\"java\">");
		}
	
		int start = 0;
		int end = 0;
	
		while (start < sourceTypes.length)
		{
			while (end < sourceTypes.length - 1
					&& (sourceTypes[end + 1] == sourceTypes[start] || sourceTypes[end + 1] == JavaSourceType.BACKGROUND))
			{
				++end;
			}
			toXml(sourceCode, sourceTypes, start, end, writer);
			start = end + 1;
			end = start;
		}
	
		if (this.getPre())
		{
			writer.write("</pre>");
		}
		else
		{
			writer.write("</code>");
		}
	
		if (this.getLineNumbers())
		{
			writer.write("</td>\n</tr>\n</table>");
			writer.newLine();
		}
		else if (!this.getPre())
		{
			writer.write("</div>");
		}
	}

	
	/**
	 * 
	 * @return String
	 */
	protected String getFooter ()
	{
		return XHTML_FOOTER;
	}

	
	/**
	 * 
	 * @return String
	 */
	protected String getHeaderEnd ()
	{
		return XHTML_HEADER_END;
	}

	
	/**
	 * 
	 * @param styleTable JavaSourceStyleTable
	 * @param title String
	 * @return String
	 */
	protected String createHeader (JavaSourceStyleTable styleTable, String title)
	{
		return XML_HEADER + createHeaderStart(styleTable, title);
	}

	
	/**
	 * 
	 * @param styleTable JavaSourceStyleTable
	 * @param title String
	 * @return String
	 */
	private String createHeaderStart (JavaSourceStyleTable styleTable, String title)
	{
		if (title == null)
		{
			title = ""; //$NON-NLS-1$
		}
		return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\n"
				+ "<head>\n<style type=\"text/css\">\n"
				+ createStyleSheet(styleTable)
				+ "</style>\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=UTF-8\" />\n"
				+ "<title>" + title + "</title>\n";
	}
}