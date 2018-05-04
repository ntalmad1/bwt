/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.lists;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.list.dl.Dl;
import com.talmadge.bwt.core.client.ui.widget.html.list.dl.DlItem;
import com.talmadge.bwt.core.client.ui.widget.html.list.ol.Ol;
import com.talmadge.bwt.core.client.ui.widget.html.list.ul.Ul;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class ListsView extends BwtExampleView
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
	 * @param presenter ListsPresenter
	 */
	public ListsView (ListsPresenter presenter)
	{
		super(presenter, "Lists");
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
		/* Ordered Lists */
		tab.add(Html.h3("Ordered"));
		
		Ol ol = new Ol();
		ol.add("Lorem ipsum dolor sit amet");
		ol.add("Consectetur adipiscing elit");
		ol.add("Integer molestie lorem at massa");
		ol.add("Facilisis in pretium nisl aliquet");
		ol.add("Nulla volutpat aliquam velit");
		ol.add("Faucibus porta lacus fringilla vel");
		ol.add("Aenean sit amet erat nunc");
		ol.add("Eget porttitor lorem");
		
		tab.add(ol);
		
		/* Unordered Lists */
		tab.add(Html.h3("Unordered"));
		
		Ul ul = new Ul();
		ul.add("Lorem ipsum dolor sit amet");
		ul.add("Consectetur adipiscing elit");
		ul.add("Integer molestie lorem at massa");
		ul.add("Facilisis in pretium nisl aliquet");
		
		Ul subUl = new Ul();
		subUl.add("Phasellus iaculis neque");
		subUl.add("Purus sodales ultricies");
		subUl.add("Vestibulum laoreet porttitor sem");
		subUl.add("Ac tristique libero volutpat at");
		
		ul.add(Html.li("Nulla volutpat aliquam velit").add(subUl));
		ul.add("Faucibus porta lacus fringilla vel");
		ul.add("Aenean sit amet erat nunc");
		ul.add("Eget porttitor lorem");
		
		tab.add(ul);
		
		/* Unstyled Lists */
		tab.add(Html.h3("Unstyled"));
		
		Ul ul2 = new Ul();
		ul2.add("Lorem ipsum dolor sit amet");
		ul2.add("Consectetur adipiscing elit");
		ul2.add("Integer molestie lorem at massa");
		ul2.add("Facilisis in pretium nisl aliquet");
		
		Ul subUl2 = new Ul();
		subUl2.add("Phasellus iaculis neque");
		subUl2.add("Purus sodales ultricies");
		subUl2.add("Vestibulum laoreet porttitor sem");
		subUl2.add("Ac tristique libero volutpat at");
		
		ul2.add(Html.li("Nulla volutpat aliquam velit").add(subUl2));
		ul2.add("Faucibus porta lacus fringilla vel");
		ul2.add("Aenean sit amet erat nunc");
		ul2.add("Eget porttitor lorem");
		
		ul2.setStyled(false);
		
		tab.add(ul2);
		
		
		/* Inline Lists */
		tab.add(Html.h3("Inline"));
		
		Ul ul3 = new Ul();
		ul3.add("Lorem ipsum");
		ul3.add("Phasellus iaculis");
		ul3.add("Nulla volutpat ");
		
		ul3.setInline(true);
		
		tab.add(ul3);
		
		/* Description Lists */
		tab.add(Html.h3("Description"));
		
		Dl dl = new Dl();
		
		dl.add(new DlItem("Description lists", "A description list is perfect for defining terms."));
		dl.add(new DlItem("Euismod", "Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit."
				+ " Donec id elit non mi porta gravida at eget metus."));
		dl.add(new DlItem("Malesuada porta", "Etiam porta sem malesuada magna mollis euismod."));
		
		tab.add(dl);
		
		/* Horizintal Description Lists */
		tab.add(Html.h4("Horizintal Description"));
		
		Dl dl2 = new Dl();
		
		dl2.add(new DlItem("Description lists", "A description list is perfect for defining terms."));
		dl2.add(new DlItem("Euismod", "Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit."
				+ " Donec id elit non mi porta gravida at eget metus."));
		dl2.add(new DlItem("Malesuada porta", "Etiam porta sem malesuada magna mollis euismod."));
		dl2.add(new DlItem("Felis euismod semper eget lacinia", "Fusce dapibus, tellus ac cursus commodo, tortor mauris"
				+ " condimentum nibh, ut fermentum massa justo sit amet risus."));

		dl2.setHorizontal(true);
		
		tab.add(dl2);
		//<= 
	}
}