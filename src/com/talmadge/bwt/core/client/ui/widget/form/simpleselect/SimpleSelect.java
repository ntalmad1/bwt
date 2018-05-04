package com.talmadge.bwt.core.client.ui.widget.form.simpleselect;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.talmadge.bwt.core.client.ui.widget.event.change.ChangeEvent;
import com.talmadge.bwt.core.client.ui.widget.event.change.ChangeHandler;
import com.talmadge.bwt.core.client.ui.widget.event.change.HasChangeHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.select.HasSelectHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElement;
import com.talmadge.bwt.core.client.ui.widget.form.option.Item;
import com.talmadge.bwt.core.client.ui.widget.form.option.select.SelectOption;

/**
 * 
 * @author Noah
 * 
 * @param <T>
 */
public class SimpleSelect<T> extends AbstractFormElement<T> implements HasChangeHandlers<T>, HasSelectHandlers<T>
{
	/**
	 */
	private boolean isValidateOnSelect = true;
	
	/**
	 */
	private List<SelectOption<T>> selectOptions = new ArrayList<SelectOption<T>>();
	
	/**
	 */
	private T selectedValue;
	
	
	/**
	 */
	private List<T> values = new ArrayList<T>();


	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance ComboBoxAppearance
	 */
	protected SimpleSelect (SimpleSelectAppearance appearance)
	{
		super(appearance);
		
		this.bindSimpleSelect();
	}
	
	
	/**
	 * Constructor
	 *  
	 */
	public SimpleSelect ()
	{
		this((SimpleSelectAppearance) GWT.create(DefaultSimpleSelectAppearance.class));
	}

	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public SimpleSelect (String label)
	{
		this();
		this.setLabel(label);
	}

	
	/**
	 * 
	 * @param option T
	 */
	public void add (T option)
	{
		this.add(option, false);		
	}


	/**
	 * 
	 * @param option T
	 * @param selected boolean
	 */
	public void add (T option, boolean selected)
	{
		this.values.add(option);
		
		SelectOption<T> selectOption = null;
		
		if (option instanceof Item)
		{
			selectOption = new SelectOption<T>(((Item<?>) option).getName(), option);
			this.addOption(selectOption);
		}
		else
		{
			selectOption = new SelectOption<T>(option.toString(), option);
			this.addOption(selectOption);
		}
		
		if (selected && selectOption != null)
		{
			this.setSelected(option); 
		}
	}
	
	
	/**
	 * 
	 * @param handler ChangeHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addChangeHandler (ChangeHandler<T> handler)
	{
		return this.addHandler(handler, ChangeEvent.getType());		
	}
	
	
	/**
	 * 
	 * @param handler SelectHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (SelectHandler<T> handler)
	{
		return this.addHandler(handler, SelectEvent.getType());		
	}


	/**
	 * 
	 */
	public void clear ()
	{
		this.clearState();
		this.getAppearance().clear();		
	}


	/**
	 *
	 * @return ComboBoxAppearance
	 */
	public SimpleSelectAppearance getAppearance ()
	{
		return (SimpleSelectAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getSelectedItem ()
	{
		return this.getValue();
	}
	
	
	/**
	 * 
	 * @return T
	 */
	public T getValue ()
	{
		return this.selectedValue;
	}


	/**
	 * 
	 */
	public void disable ()
	{
		this.setDisabled(true);		
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isValidateOnSelect ()
	{
		return this.isValidateOnSelect;
	}
	

	/**
	 * 
	 * @param disabled boolean
	 */
	public void setDisabled (boolean disabled)
	{
		this.getAppearance().setDisabled(disabled);
	}
	
	
	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		if (!this.getAppearance().hasPlaceholder())
		{
			this.setPlaceholder(label);
		}
		
		super.setLabel(label);
	}
	
	
	/**
	 * 
	 * @param label String
	 */
	public void setPlaceholder (String label)
	{
		this.getAppearance().setPlaceholder(label);
	}


	/**
	 * 
	 * @param value T
	 */
	public void setSelected (T value)
	{
		if (this.selectedValue != null && this.selectedValue.equals(value))
		{
			return;
		}
		
		for (SelectOption<T> option : this.selectOptions)
		{
			option.setSelected(false);
		}
		
		for (SelectOption<T> option : this.selectOptions)
		{
			if (option.getValue().equals(value))
			{
				this.getAppearance().setPlaceholderSelected(false);
				this.getAppearance().setHasSelection(true);
				option.setSelected(true);
				this.selectedValue = value;
				break;
			}
		}
	}


	/**
	 * 
	 * @param option SelectOption<T>
	 */
	protected void addOption (SelectOption<T> option)
	{
		this.selectOptions.add(option);
		this.getAppearance().addOption(option);
	}


	/**
	 * 
	 */
	protected void bindSimpleSelect ()
	{
		Element selectElement = this.getAppearance().getSelectElement();
		
		Event.sinkEvents(selectElement, Event.ONCHANGE | Event.ONBLUR | Event.ONFOCUS);
		Event.setEventListener(selectElement, new EventListener() {

	        @Override
	        public void onBrowserEvent (Event event) 
	        {
	        	if (Event.ONCHANGE == event.getTypeInt()) 
	            {
	            	SimpleSelect.this._onChange(event);
	            }
	        	else if (Event.ONBLUR == event.getTypeInt()) 
	            {
	            	SimpleSelect.this._onBlur(event);
	            }
	        	else if (Event.ONFOCUS == event.getTypeInt()) 
	            {
	            	SimpleSelect.this._onFocus(event);
	            }
	        }
	    });
	}


	/**
	 * 
	 */
	protected void onInitialAttach ()
	{
		super.onInitialAttach();
		
		if (this.selectedValue == null && this.getAppearance().hasPlaceholder())
		{
			this.getAppearance().setPlaceholderSelected(true);
		}
		
		if (this.selectedValue == null)
		{
			this.getAppearance().setHasSelection(false);
		}
	}


	/**
	 * 
	 * @param changeEvent ChangeEvent<T>
	 */
	protected void onChange (ChangeEvent<T> changeEvent)
	{
		
	}


	/**
	 * 
	 * @param selectEvent SelectEvent<T>
	 */
	protected void onSelect (SelectEvent<T> selectEvent)
	{
		
	}


	/**
	 * 
	 * @param event NativeEvent
	 */
	protected void _onChange (NativeEvent event)
	{
		SelectElement selectElement = (SelectElement) this.getAppearance().getSelectElement();
		
		NodeList<OptionElement> options = selectElement.getOptions();
		
		// get the selected value
		int selectedIndex = selectElement.getSelectedIndex();
		T newValue = null;		
		if (selectedIndex > -1)
		{
			String optionId = options.getItem(selectedIndex).getId();
			
			for (SelectOption<T> selectOption : this.selectOptions)
			{
				if (selectOption.getId().equals(optionId))
				{
					newValue = selectOption.getValue();
					break;
				}
			}
		}
		
		if ((newValue != null && !newValue.equals(selectedValue))
				|| (newValue == null && this.selectedValue != null))
		{
			T oldValue = this.selectedValue;
			this.selectedValue = newValue;
			this.getAppearance().setHasSelection(newValue != null);
			
			if (this.isValidateOnSelect())
			{
				this.validate(true);
			}
			
			ChangeEvent<T> changeEvent = new ChangeEvent<T>(oldValue, newValue);  
			SelectEvent<T> selectEvent = new SelectEvent<T>(newValue);
			
			this.fireEvent(changeEvent);
			this.fireEvent(selectEvent);
			
			this.onSelect(selectEvent);
			this.onChange(changeEvent);
		}
	}
}
