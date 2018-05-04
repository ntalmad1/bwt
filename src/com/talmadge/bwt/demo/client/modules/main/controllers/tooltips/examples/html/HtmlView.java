/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.html;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.resources.TooltipsResources;

/**
 * 
 * @author Noah
 *
 */
public class HtmlView extends BwtExampleView
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
	 * @param presenter ButtonBlockPresenter
	 */
	public HtmlView (HtmlExample presenter)
	{
		super(presenter, "HTML, side, fixed size");
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
		Button button = new PrimaryButton("Hover");
		button.setWidth(75);
		
		TooltipConfig tooltipConfig = new TooltipConfig();
		tooltipConfig.setPosition(Position.RIGHT);
		//tooltipConfig.setTrigger(TooltipTrigger.CLICK);
		tooltipConfig.setInteractive(true);
		tooltipConfig.setMaxWidth(400);	
		
		Html table = Html.div().setDisplay(Display.TABLE);
		Html tableRow = Html.div().setDisplay(Display.TABLE_ROW);
		table.add(tableRow);
		
		Html left = Html.div().setDisplay(Display.TABLE_CELL);
		left.add(Html.image(TooltipsResources.INSTANCE.watermellonBoy()).setBorder("#333", BorderStyle.SOLID, 1, Unit.PX));
		
		Html right = Html.div().setDisplay(Display.TABLE_CELL);
		right.add(Html.div("Bacon ipsum dolor amet tri-tip").setFontSize(16).setFontWeight(FontWeight.BOLD));
		right.add(Html.p("Jowl spare ribs drumstick beef ribs, sirloin chicken brisket biltong swine short loin andouille. Bresaola venison tongue turducken pork loin short loin cow fatback turkey cupim. Shoulder rump sirloin prosciutto beef sausage."));
		right.setVerticalAlign(VerticalAlign.TOP);
		
		tableRow.add(left, Padding.right(10));
		tableRow.add(right);
		
		tooltipConfig.setContent(table); 
		
		button.setTooltip(tooltipConfig); 
		
		tab.add(button);
		
    	//<=
	}
}