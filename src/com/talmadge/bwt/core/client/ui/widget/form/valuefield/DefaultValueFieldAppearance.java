package com.talmadge.bwt.core.client.ui.widget.form.valuefield;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.InputGroupSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.InputSize;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElementAppearance;

/**
 * 
 * @author Noah
 *
 */
abstract public class DefaultValueFieldAppearance extends AbstractFormElementAppearance implements ValueFieldAppearance
{
	/**
	 */
	private FormElementSize formElementSize = FormElementSize.NORMAL;
	
	/**
	 */
	private InputElement inputElement;
	
	/**
	 */
	private Element inputGroup;
	
	/**
	 */
	private Element leftAddon;
	
	/**
	 */
	private Element rightAddon;
	
	
	
	/**
	 * Constructor
	 *  
	 */
	public DefaultValueFieldAppearance ()
	{
		super();
	}



	/**
	 * 
	 */
	public void clear ()
	{
		this._clear(this.inputElement);
	}



	/**
	 * 
	 * @return InputElement
	 */
	public InputElement getInputElement ()
	{
		return this.inputElement;
	}



	/**
	 *
	 * @return String
	 */
	public String getInputGroupId ()
	{
		return this.inputGroup.getId();
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getValue ()
	{
		return this._getValue(this.inputElement);
	}



	/**
	 * 
	 */
	public void focus ()
	{
		this._focus(this.inputElement);		
	}



	/**
	 * 
	 * @param icon Glyphicon
	 * @param pos AddonPos
	 */
	public void setAddon (Glyphicon icon, AddonPos pos)
	{
		this.convertToInputGroup();	
		
		Element addon = this.getAddon(pos);
		addon.removeAllChildren();
		addon.setInnerHTML("");
		
		Element iconElement = DOM.createSpan();
		iconElement.addClassName("glyphicon");
		iconElement.addClassName(icon.getCssName());
		
		addon.appendChild(iconElement);
		
		this.populateInputGroup();
	}



	/**
	 * 
	 * @param string String
	 * @param pos AddonPos
	 */
	public void setAddon (String string, AddonPos pos)
	{
		this.convertToInputGroup();
		
		Element addon = this.getAddon(pos);
		addon.removeAllChildren();
		
		addon.setInnerHTML(string);
		
		this.populateInputGroup();
	}



	/**
	 * 
	 * @param widget Widget
	 * @param pos AddonPos
	 */
	public void setAddon (Widget widget, AddonPos pos)
	{
		this.convertToInputGroup();	
		
		Element addon = this.getAddon(pos);
		addon.removeAllChildren();
		addon.setInnerHTML("");
		
		addon.appendChild(widget.getElement());
		
		this.populateInputGroup();
	}


	/**
	 * 
	 * @param placeholder String
	 */
	public void setPlaceholder (String placeholder)
	{
		this.inputElement.setAttribute("placeholder", placeholder);		
	}



	/**
	 * 
	 * @param id String
	 */
	public void setInputGroupId (String id)
	{
		this.inputGroup.setId(id);		
	}

	
	/**
	 * 
	 * @param maxLength int
	 */
	public void setMaxLength (int maxLength)
	{
		this.inputElement.setMaxLength(maxLength);
	}
	
	
	/**
	 * 
	 * @param size FormElementSize
	 */
	public void setSize (FormElementSize size)
	{
		this.formElementSize = size;
		this._setSize();
	}
	
	
//	/**
//	 * 
//	 * @param state FormElement.State
//	 * @param message String
//	 */
//	@Override
//	public void setState (FormElement.State state, String message)
//	{
//		if (message != null)
//		{
//			this.convertToInputGroup();
//		}
//		
//		super.setState(state, message);
//	}
	
	
//	/**
//	 * 
//	 */
//	protected void attachHelpBlock (Element helpBlock)
//	{
//		if (this.inputGroup != null)
//		{
//			this.inputGroup.appendChild(helpBlock);
//		}
//		else
//		{
//			this.getElement().appendChild(helpBlock);	
//		}
//	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		super.build(); 
		
		this.inputElement = this.createInputElement();
		this.ensureCssName(this.inputElement, "form-control");
		
		this.getElement().appendChild(this.inputElement);
	}

	
	/**
	 * 
	 * @return InputElement
	 */
	abstract protected InputElement createInputElement ();
	

	/**
	 * 
	 */
	protected void convertToInputGroup ()
	{
		if (this.inputGroup == null)
		{
			this.getElement().removeChild(this.inputElement);
			
			this.inputGroup = DOM.createDiv();
			this.ensureCssName(this.inputGroup, "input-group");
			this.inputGroup.appendChild(this.inputElement);
			
			this.getElement().appendChild(this.inputGroup);
			
			this._setSize();
		}
	}



	/**
	 * 
	 * @param pos AddonPos
	 * @return Element
	 */
	protected Element getAddon (AddonPos pos)
	{
		Element addon = null;
		
		switch (pos)
		{
			case LEFT:
				if (this.leftAddon == null)
				{
					this.leftAddon = DOM.createDiv();
					this.leftAddon.addClassName("input-group-addon");
				}
				addon = this.leftAddon;
				break;
			case RIGHT:
				if (this.rightAddon == null)
				{
					this.rightAddon = DOM.createSpan();
					this.rightAddon.addClassName("input-group-addon");
				}
				addon = this.rightAddon;
				break;
			default:
				addon = null;
		}
		
		
		return addon;
		
	}



	/**
	 * 
	 * @return Element
	 */
	protected Element getInputGroup ()
	{
		return this.inputGroup;
	}
	

	/**
	 * 
	 */
	protected void populateInputGroup ()
	{
		this.inputGroup.removeAllChildren();
		
		if (this.leftAddon != null)
		{
			this.inputGroup.appendChild(this.leftAddon);
		}
		
		this.inputGroup.appendChild(this.inputElement);
		
		if (this.rightAddon != null)
		{
			this.inputGroup.appendChild(this.rightAddon);
		}
	}
	
	
	/**
	 * 
	 */
	protected void _setSize ()
	{
		if (this.formElementSize == null)
		{
			this.formElementSize = FormElementSize.NORMAL;
		}
		
		if (this.inputGroup != null)
		{	
			BwtElementUtils.removeCssNames(this.inputGroup, InputGroupSize.values());
			BwtElementUtils.ensureCssName(this.inputGroup, InputGroupSize.map(this.formElementSize).getCssName());
		}
		
		if (this.inputElement != null)
		{
			BwtElementUtils.removeCssNames(this.inputElement, InputSize.values());
			BwtElementUtils.ensureCssName(this.inputElement, InputSize.map(this.formElementSize).getCssName());
		}
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void attachHelpBlock (Element helpBlock)
	{
		super.attachHelpBlock(helpBlock);
		
		int selectWidth = this.inputElement.getClientWidth();
		int parentWidth = this.inputElement.getParentElement().getClientWidth();
		int helpWidth = helpBlock.getClientWidth();
		
		if ((parentWidth - selectWidth) < helpWidth)
		{
			int pct = (100 * (selectWidth - (helpWidth + 3))) / selectWidth;
			
			this.inputElement.getStyle().setWidth(pct, Unit.PCT);
		}
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void detachHelpBlock (Element helpBlock)
	{
		super.detachHelpBlock(helpBlock);
		this.inputElement.getStyle().setWidth(100, Unit.PCT);
	}


	/**
	 * 
	 * @param object JavaScriptObject
	 */
	private native void _clear (JavaScriptObject object) /*-{
	
		$wnd.$(object).val('');
		
	}-*/;
	
	
	/**
	 * 
	 * @param object JavaScriptObject
	 */
	private native void _focus (JavaScriptObject object) /*-{
	
		$wnd.$(object).focus();
		
	}-*/;



	/**
	 * 
	 * @param object JavaScriptObject
	 * @return String
	 */
	private native String _getValue (JavaScriptObject object) /*-{
	
		return $wnd.$(object).val();
		
	}-*/;
}
