package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.abbreviations.AbbreviationsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.addresses.AddressesPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.alignment.AlignmentPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.blockquotes.BlockquotesPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.headings.HeadingsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.inline.InlineElementsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.lists.ListsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.paragraphs.ParagraphsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.transformations.TransformationsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class TypographyExamples extends BwtExampleGroup
{

	
	/**
	 * Constructor
	 * 
	 */
	public TypographyExamples (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new TypographyView(this)); 
		
		this.addExample(new HeadingsPresenter());
		this.addExample(new InlineElementsPresenter());
		this.addExample(new AlignmentPresenter());
		this.addExample(new TransformationsPresenter());
		this.addExample(new ParagraphsPresenter());
		this.addExample(new AbbreviationsPresenter());
		this.addExample(new AddressesPresenter());
		this.addExample(new BlockquotesPresenter());
		this.addExample(new ListsPresenter());
		
		this.populateSideNav(sidebar);
	}

}
