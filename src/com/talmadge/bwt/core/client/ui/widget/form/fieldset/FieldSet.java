package com.talmadge.bwt.core.client.ui.widget.form.fieldset;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.widget.form.BwtForm;
import com.talmadge.bwt.core.client.ui.widget.form.BwtFormPart;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;

/**
 * 
 * @author Noah
 *
 */
public class FieldSet extends BwtForm implements BwtFormPart
{	
	/**
	 */
	private String name;

	

	/**
	 * Constructor
	 * 
	 */
	public FieldSet ()
	{
		this((DefaultFieldSetAppearance) GWT.create(DefaultFieldSetAppearance.class));
	}


	/**
	 * 
	 * @param appearance FieldSetAppearance
	 */
	protected FieldSet (FieldSetAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public FieldSet (String label)
	{
		this();
		
		this.setLabel(label);
	}

	
	/**
	 * 
	 * @param name String
	 * @param label String
	 */
	public FieldSet (String name, String label)
	{
		this(label);
		this.setName(name);
	}


	/**
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param cols int
	 */
	public void addRow (Widget widget, Size size, int cols)
	{
		LayoutRow row = new LayoutRow();
		row.add(new LayoutColumn(widget), size, cols);
		
		this.add(row);
	}

	
	/**
	 * 
	 * @return String
	 */
	@Override
	public String getName ()
	{
		String name = this.name;
		
		if ((name == null || name.isEmpty()) && (this.getLabel() != null))
		{
			name = this.getLabel().toLowerCase().replace(" ", "_");
		}
		
		return name;
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getLabel ()
	{
		return this.getAppearance().getLabel();
	}


	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.getAppearance().setLabel(label);		
	}
	
	
	/**
	 * 
	 * @param name String
	 */
	public void setName (String name)
	{
		this.name = name;
	}


	/**
	 * 
	 * @return FieldSetAppearance
	 */
	protected FieldSetAppearance getAppearance () 
	{
		return (FieldSetAppearance) super.getAppearance();
	}
}
