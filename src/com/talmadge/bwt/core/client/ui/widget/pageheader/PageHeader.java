package com.talmadge.bwt.core.client.ui.widget.pageheader;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 *
 */
public class PageHeader extends BwtWidget implements BwtHasText
{
	/**
	 */
	private String text;
	

	
    /**
     * Constructor
     *
     */
    public PageHeader ()
    {
        this((PageHeaderAppearance) GWT.create(DefaultPageHeaderAppearance.class));

       
    }

    
    /**
     * Constructor 
     *
     * @param appearance PageHeaderAppearance
     */
    protected PageHeader (PageHeaderAppearance appearance)
    { 
    	super(appearance);
    	
    	this.bind();
    }
    

    /**
     * Constructor
     *
     * @param text String
     */
    public PageHeader (String text)
    {
        this();

        this.setText(text);
    }


    /**
     * Constructor
     *
     * @param text String
     * @param subtext String
     */
    public PageHeader (String text, String subtext)
    {
        this(text);

        this.setSubtext(subtext);
    }


    /**
     *
     * @return PageHeaderAppearance
     */
    public PageHeaderAppearance getAppearance ()
    {
        return (PageHeaderAppearance) super.getAppearance();
    }


    /**
     * 
     * @return String
     */
	public String getText ()
	{
		return this.text;
	}


	/**
     *
     * @param subtext String
     */
    public void setSubtext (String subtext)
    {
        this.getAppearance().setSubtext(subtext);
    }


    /**
     *
     * @param align SubtextAlign
     */
    public void setSubtextAlign (BwtStyle.SubtextAlign align)
    {
        this.getAppearance().setSubtextAlign(align);
    }


    /**
     *
     * @param text text
     */
    public void setText (String text)
    {
    	this.text = text;
    	
        this.getAppearance().setText(text);
    }


    /**
     *
     */
    protected void bind ()
    {

    }
}
