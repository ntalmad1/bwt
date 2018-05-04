package com.talmadge.bwt.demo.client.lib.example;

import java.io.IOException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.pre.Pre;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.java2html.client.converter.JavaSource2XhtmlConverter;
import com.talmadge.bwt.java2html.client.javasource.JavaSource;
import com.talmadge.bwt.java2html.client.javasource.JavaSourceParser;
import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.util.proxy.BufferedWriterProxy;



/**
 * 
 * @author Noah
 *
 */
public abstract class BwtExampleView extends BwtExampleGroupView
{
	/**
	 */
	protected interface Resources 
	{
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code (); 
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param presenter BwtExamplePresenter
	 */
	public BwtExampleView (BwtExamplePresenter presenter)
	{
		this(presenter, null);
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param presenter BwtExamplePresenter
	 * @param header String
	 */
	public BwtExampleView (BwtExamplePresenter presenter, String header)
	{
		super(presenter, header);
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setBodyPadding(0);
		
		Tab expTab = new Tab("Example");
		expTab.setPadding(new Padding(20, 10, 20, 10));
		
		this.populateExamplesTab(expTab);
		
		tabPanel.add(expTab);
		
		Tab codeTab = new Tab("Code");
		codeTab.addClassName("bwt-code");
		codeTab.setPadding(new Padding(15, 10, 10, 10));
		
		this.populateCode(codeTab);
		
		tabPanel.add(codeTab);
		
		this.add(tabPanel);
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasId ()
	{
		return this.getId() != null && !this.getId().isEmpty();
	}


	/**
	 * 
	 * @param header String
	 * @return BwtHasText
	 */
	protected BwtHasText createHeader (String header)
	{
		return Html.h2(header);		
	}
	
		
	/**
	 * 
	 * @return String
	 */
	protected abstract String getCodeRawText ();


	/**
	 * 
	 * @param tab Tab
	 */
	protected void populateCode (Tab tab)
	{
		try
		{
			String code = this.getCodeRawText();
			
			if (code == null)
			{
				code = "";
			}
			
			JavaSourceParser parser = new JavaSourceParser();
			JavaSource source = parser.parse(code);
			JavaSource2XhtmlConverter converter = new JavaSource2XhtmlConverter();
			BufferedWriterProxy writer = new BufferedWriterProxy();
			converter.convert(source, JavaSourceConversionOptions.getRawDefault(), writer);
			
			String convertedText = writer.getStringBuilder().toString();
			
			Pre pre = new Pre(convertedText).setScrollable(true);
			pre.getElement().getStyle().setOverflowX(Overflow.SCROLL);
			
			tab.add(pre);
		}
		catch (IOException e)
		{
			GWT.log("An error occured while generating example code.", e);
		}
	}
	
	
	/**
	 * 
	 * @param tab Tab
	 */
	protected abstract void populateExamplesTab (Tab tab);
}
