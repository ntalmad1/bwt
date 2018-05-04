package com.talmadge.bwt.core.client.ui.widget.html;

/**
 * 
 * @author Noah
 *
 */
public enum HtmlTag
{
	/**
	 */
	BR("br"),
	
	/**
	 */
	BUTTON("button"),
	
	/**
	 */
	CITE("cite"),
	
	/**
	 */
	CODE("code"),
	
	/**
	 */
	DEL("del"),
	
	/**
	 */
	DIV("div"), 
	
	/**
	 */
	DT("dt"), 
	
	/**
	 */
	DD("dd"), 
	
	/**
	 */
	EM("em"), 
	
	/**
	 */
	FOOTER("footer"), 
	
	/**
	 */
	H1("h1"),
	
	/**
	 */
	H2("h2"),
	
	/**
	 */
	H3("h3"),
	
	/**
	 */
	H4("h4"),
	
	/**
	 */
	H5("h5"),
	
	/**
	 */
	H6("h6"),
	
	/**
	 */
	INS("ins"), 
	
	/**
	 */
	KBD("kbd"), 
	
	/**
	 */
	MARK("mark"),
	
	/**
	 */
	P("p"), 
	
	/**
	 * Strikethrough
	 */
	S("s"), 
	
	/**
	 * Sample Text 
	 */
	SAMP("samp"), 
	
	/**
	 */
	SMALL("small"), 
	
	/**
     */
    SPAN("span"), 
	
	/**
	 */
	STRONG("strong"), 
	
	/**
	 */
	U("u"),	
	
	/**
	 */
	VAR("var");	
	
	
	/**
	 */
	private String tagName;
	
	
	
	
	/**
	 * Constructor
	 * 
	 * @param tagName String
	 */
	HtmlTag (String tagName)
	{
		this.tagName = tagName;
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public Html create (String html)
	{
		return new Html(this, html);
	}


	/**
	 * 
	 * @return String
	 */
	public String getTagName ()
	{
		return this.tagName;
	}
}
