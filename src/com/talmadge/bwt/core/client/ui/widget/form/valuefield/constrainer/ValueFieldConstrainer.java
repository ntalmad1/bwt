package com.talmadge.bwt.core.client.ui.widget.form.valuefield.constrainer;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.util.BwtEventUtils;

/**
 * 
 *
 */
public class ValueFieldConstrainer 
{
	/**
	 */
	private int lastKeyCode;

	/**
	 */
	private String pattern;

	/**
	 */
	private InputElement target;
	
	/**
	 */
	private List<Character> allowedChars;
	

	
	/**
	 * Constructor
	 * 
	 * @param target Element
	 */
	public ValueFieldConstrainer ()
	{
		this.allowedChars = new ArrayList<Character>();
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getPattern ()
	{
		if (this.pattern == null)
		{
			this.pattern = ".*";
		}
		
		return this.pattern;
	}
	
	
	/**
	 * 
	 * @return Element
	 */
	public InputElement getTarget ()
	{
		return this.target;
	}

	
	/**
	 * 
	 * @param event Event
	 * @return boolean
	 */
	public boolean onKeyDown (Event event)
	{
		this.lastKeyCode = event.getKeyCode();
		return true;
	}


	/**
	 * 
	 * @param event Event
	 */
	public boolean onKeyPress (Event event)
	{
		if (((this.lastKeyCode != KeyCodes.KEY_BACKSPACE)
		&&  (this.lastKeyCode != KeyCodes.KEY_DELETE))
	    &&  (BwtEventUtils.isSpecialKey(event.getKeyCode())
		||  event.getCtrlKey()))
	    {
	        return true;
	    }
		
	
	    if ((this.lastKeyCode != KeyCodes.KEY_BACKSPACE)
	    &&  (this.lastKeyCode != KeyCodes.KEY_DELETE)
	    &&  !this.isCharAllowed(event.getCharCode()))
	    {
	       event.stopPropagation();
	       event.preventDefault();
	       return false;
	    }
	    
	    
	    else
	    {
	    	char key = (char) event.getCharCode();
	    	
	        String value = this.getTarget().getValue();
	        int pos = BwtElementUtils.getCursorPos(this.getTarget());
	
	        int selectionLength = BwtElementUtils.getSelectionLength(this.getTarget());
	        if (selectionLength > 0)
	        {
	            // Go ahead and delete out any selected (highlighted) text since we should be replacing it with whatever they've entered.
	            value = value.substring(0, pos) + value.substring(pos + selectionLength);
	        }
	
	        if (this.lastKeyCode == KeyCodes.KEY_BACKSPACE)
	        {
	            if (value != null && !value.isEmpty() && pos > 0)
	            {
	                value = value.substring(0, pos - 1) + value.substring(pos, value.length());
	            }
	        }
	        else if (this.lastKeyCode == KeyCodes.KEY_DELETE)
	        {
	            if (value != null && !value.isEmpty() && pos < value.length())
	            {
	                value = value.substring(0, pos) + value.substring(pos + 1, value.length());
	            }
	        }
	        else
	        {
	            if (pos == 0)
	            {
	                value = key + value;
	            }
	            else if (pos == value.length())
	            {
	                value = value + key;
	            }
	            else
	            {
	                value = value.substring(0, pos) + key + value.substring(pos + 1, value.length());
	            }
	        }
	        
	        
	        if (!this.isAllowed(value))
	        {
	        	Window.alert("HERE");
	        	event.stopPropagation();
	        	event.preventDefault();
	        	return false;
	        }
	        else
	        {
	        	return true;
	        }
	    }		
	}


	/**
	 * 
	 * @param event Event
	 */
	public boolean onPaste (Event event)
	{
		final String oldValue = this.getTarget().getValue();
		
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
	        public void execute() {
	        	String newValue = ValueFieldConstrainer.this.getTarget().getValue();
	            if (!ValueFieldConstrainer.this.isAllowed(newValue)) {
	            	ValueFieldConstrainer.this.getTarget().setValue(oldValue);
	            }
	        }
	    });
		
		return true;
	}


	/**
	 * 
	 * @param chars String
	 */
	public void setAllowedChars (String chars)
	{
		this.allowedChars.clear();
		
		for (int i = 0; i < chars.length(); i++)
		{
			this.allowedChars.add(chars.charAt(i));
		}
	}
	
	
	/**
	 * 
	 * @param pattern String
	 */
	public void setPattern (String pattern)
	{
		this.pattern = pattern;		
	}

	
	/**
	 * 
	 * @param target InputElement
	 */
	public void setTarget (InputElement target)
	{
		this.target = target;
	}
	
	
	/**
	 * 
	 * @param value String
	 * @return boolean 
	 */
	protected boolean isAllowed (String value)
	{
		if (value == null)
		{
			return true;
		}
		
		return value.trim().matches(this.getPattern());
	}
	

	/**
	 * 
	 * @param charCode
	 * @return boolean
	 */
	protected boolean isCharAllowed (int charCode)
	{
		if (this.allowedChars.isEmpty())
		{
			return true;
		}
		else
		{
			return this.allowedChars.contains(new Character((char) charCode));
		}
	}

	
	/**
	 * 
	 * @param obj Element
	 * @return int
	 */
	private native int getSelectionStart (Element obj) /*-{
	               
		return obj.selectionStart;
		
	}-*/;

	
	
}
