/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;
import com.talmadge.bwt.core.client.ui.widget.pageheader.PageHeader;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.Demo;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class ImagesView extends BwtExampleView
{
	/**
	 */
	protected interface Resources extends ClientBundle, BwtExampleView.Resources
	{
		/**
		 */
		Resources INSTANCE = GWT.create(Resources.class); 
		
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code ();
	}
	
	
	
	/**
	 * Constructor 
	 *
	 * @param presenter ImagesView
	 */
	public ImagesView (ImagesExamples presenter)
	{
		super(presenter, "Images");
	}

	
	/**
	 * 
	 * @param header String
	 * @return Html
	 */
	protected BwtHasText createHeader (String header)
	{
		return new PageHeader(header);
		
	}
	
	
	/**
	 * 
	 * @return String
	 */
	protected String getCodeRawText ()
	{
		return Resources.INSTANCE.code().getText();
	}


	/**
	 * 
	 * @param tab Tab
	 */
	protected void populateExamplesTab (Tab tab)
	{
		//=>
		/* Inline */
		tab.add(Html.h3("Responsive images")); 
		
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExampleWide.jpg").setResponsive(true));
		
		
		/* Image shapes */
		tab.add(Html.h3("Image shapes")); 
		
		tab.add(Html.h4("Rounded"));
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExample.jpg").setRounded(true));
		tab.add(Html.h4("Circle"));
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExample.jpg").setCircle(true));
		
		
		/* Thumbnails */
		tab.add(Html.h3("Thumbnails")); 
		
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExampleWide.jpg").setResponsive(true).setThumbnail(true));
		tab.br();
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExample.jpg").setRounded(true).setThumbnail(true), new Margins(10, 10, 0, 0));
		tab.add(new BwtImage(Demo.getAppUrl() + "images/imageExample.jpg").setCircle(true).setThumbnail(true), new Margins(10, 0, 0, 0));
		//<=
	}
}