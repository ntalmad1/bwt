package com.talmadge.bwt.java2html.client.converter;

import java.io.IOException;

import com.talmadge.bwt.java2html.client.javasource.JavaSourceType;
import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.options.JavaSourceStyleTable;
import com.talmadge.bwt.java2html.client.util.HtmlUtilities;
import com.talmadge.bwt.java2html.client.util.proxy.BufferedWriterProxy;

/**
 * 
 * @author Markus Gebhard
 */
public abstract class AbstractJavaSourceToXmlConverter extends AbstractJavaSourceConverter
{

	// original style sheet by Jan Tisje
	// "td.java, td.java-ln {vertical-align:top;}\n" +
	// "tt.java, tt.java-ln, pre.java, pre.java-ln {line-height:1em; margin-bottom:0em;}\n"
	// +
	// "td.java-ln { text-align:right; }\n"+
	// "tt.java-ln, pre.java-ln { color:#888888 }\n"+
	// "/* UNDEFINED       */ span.java0  { color:black; }\n" +
	// "/* CODE            */ span.java1  { color:black; }\n" +
	// "/* CODE_KEYWORD    */ span.java2  { color:black; font-weight:bold; }\n"
	// +
	// "/* CODE_TYPE       */ span.java3  { color:darkblue ;}\n" +
	// "/* QUOTE           */ span.java4  { color:darkgreen; }\n" +
	// "/* COMMENT_LINE    */ span.java5  { color:#888888; font-style:italic; }\n"
	// +
	// "/* COMMENT_BLOCK   */ span.java6  { color:#888888; font-style:italic; }\n"
	// +
	// "/* COMMENT_JAVADOC */ span.java7  { color:green; font-style:italic; }\n"
	// +
	// "/* COMMENT_KEYWORD */ span.java8  { color:green; font-style:italic; font-weight:bold; }\n"
	// +
	// "/* EMPTY           */ span.java9  {}\n" +
	// "/* NUM_CONSTANT    */ span.java10 { color:orange; }\n" +
	// "/* CHAR_CONSTANT   */ span.java11 { color:red; } ";

	/**
	 */
	protected static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

	/**
	 */
	private static final String TAG_CLOSE = "</span>";

	/**
	 */
	private static final String TAG_END = "\">";

	/**
	 */
	private static final String TAG_START = "<span class=\"java";

	/**
	 * 
	 * @param styleTable JavaSourceStyleTable
	 * @return String
	 */
	protected static String createStyleSheet (JavaSourceStyleTable styleTable)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("td.java, td.java-ln {vertical-align:top;}\n"
				+ "tt.java, tt.java-ln, pre.java, pre.java-ln {line-height:1em; margin-bottom:0em;}\n"
				+ "td.java-ln { text-align:right; }\n"
				+ "tt.java-ln, pre.java-ln { color:#888888 }\n");
	
		JavaSourceType[] types = JavaSourceType.getAll();
		for (int i = 0; i < types.length; i++)
		{
			appendStyle(buffer, types[i], styleTable);
		}
		return buffer.toString();
	}

	
	/**
	 * 
	 * @param buffer StringBuffer
	 * @param type JavaSourceType
	 * @param styleTable JavaSourceStyleTable
	 */
	private static void appendStyle (
			  StringBuffer buffer
			, JavaSourceType type
			, JavaSourceStyleTable styleTable)
	{
		buffer.append("/* " + type.getName() + "       */ ");
		buffer.append("span.java" + type.getID() + "  { ");
		buffer.append("font-size: 10pt; ");
		buffer.append("color:" + styleTable.get(type).getHtmlColor() + "; ");
		if (styleTable.get(type).isBold())
		{
			buffer.append("font-weight:bold; ");
		}
		if (styleTable.get(type).isItalic())
		{
			buffer.append("font-style:italic; ");
		}
		buffer.append("}\n");
	}


	/**
	 */
	private String foot = "";

	/**
	 */
	private String lineEnd = "";

	/**
	 */
	private boolean lineNumbers = true;

	/**
	 */
	private String headEnd = "";

	/**
	 */
	private boolean pre = true;

	/**
	 */
	private String space = " ";

	/**
	 * Constructor 
	 * 
	 * @param metaData ConverterMetaData
	 */
	public AbstractJavaSourceToXmlConverter (ConverterMetaData metaData)
	{
		super(metaData);
		setOptions(false, false);
	}

	
	/**
	 * 
	 * @param options JavaSourceConversionOptions
	 * @return String
	 */
	public String getBlockSeparator (JavaSourceConversionOptions options)
	{
		return "";
	}

	
	/**
	 * 
	 * @param options JavaSourceConversionOptions
	 * @return String
	 */
	public String getDocumentFooter (JavaSourceConversionOptions options)
	{
		return foot;
	}

	
	/**
	 *  
	 * @param options JavaSourceConversionOptions
	 * @param title String
	 * @return String
	 */
	public String getDocumentHeader (
			  JavaSourceConversionOptions options
			, String title)
	{
		return createHeader(options.getStyleTable(), title) + headEnd;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getLineEnd ()
	{
		return this.lineEnd;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean getLineNumbers ()
	{
		return this.lineNumbers;
	}
	
	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean getPre ()
	{
		return this.pre;
	}


	/**
	 * 
	 * @deprecated As of Sep 13, 2004 (Markus Gebhard) Only options in the
	 *             Java2HtmlConversionOptions are available
	 *             
	 * @param lineNumbers boolean
	 * @param pre boolean
	 */
	public void setOptions (boolean lineNumbers, boolean pre)
	{
		this.lineNumbers = lineNumbers;
		this.pre = pre;
		foot = getFooter();
		headEnd = getHeaderEnd();
	
//		if (pre)
//		{
//			lineEnd = "";
//			space = " "; // normal space
//		}
//		else
//		{
//			lineEnd = "<br />";
//			space = "&#xA0;";
//		}
		
		lineEnd = "";
		space = " "; // normal space
	}

	
	/**
	 * 
	 * @param styleTable JavaSourceStyleTable
	 * @param title String
	 * @return String
	 */
	protected abstract String createHeader (JavaSourceStyleTable styleTable, String title);

	
	/**
	 * 
	 * @return String
	 */
	protected abstract String getFooter ();

	
	/**
	 * 
	 * @return String
	 */
	protected abstract String getHeaderEnd ();

	
	/**
	 * 
	 * @param sourceCode String
	 * @param sourceTypes JavaSourceType[]
	 * @param start int
	 * @param end int
	 * @param writer BufferedWriter
	 * @throws IOException e
	 */
	protected void toXml (
			  String sourceCode
			, JavaSourceType[] sourceTypes
			, int start
			, int end
			, BufferedWriterProxy writer) throws IOException
	{
		writer.write(TAG_START + sourceTypes[start].getID() + TAG_END);

		String t = HtmlUtilities.encode(sourceCode, start, end + 1, "\r\n ");

		for (int i = 0; i < t.length(); ++i)
		{
			char ch = t.charAt(i);
			if (ch == ' ')
			{
				if ((i < t.length() - 1) && (t.charAt(i + 1) == ' '))
				{
					writer.write(space);
				}
				else
				{
					writer.write(" ");
				}
			}
			else if (ch == '\n')
			{
				writer.write(lineEnd + "\n");
			}
			else if (ch != '\r')
			{
				writer.write(ch);
			}
		}

		writer.write(TAG_CLOSE);
	}
}