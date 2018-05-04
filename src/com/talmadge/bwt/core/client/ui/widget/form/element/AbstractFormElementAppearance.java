package com.talmadge.bwt.core.client.ui.widget.form.element;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.core.client.ui.widget.tooltip.theme.TooltipTheme;

/**
 * 
 * @author Noah
 *
 */
public abstract class AbstractFormElementAppearance extends DefaultBwtWidgetAppearance implements FormElementAppearance 
{
	/**
	 */
	private Element helpBlock;
	
	/**
	 */
	private boolean isRequired;
	
	private Element requiredAsterisk; 

	/**
	 */
	private Element label;
	
	/**
	 */
	private String labelString;

	/**
	 */
	private Position messagePosition = Position.RIGHT;
	
	/**
	 */
	private Tooltip messageTooltip;

	/**
	 * Constructor
	 * 
	 * @param element Element
	 */
	protected AbstractFormElementAppearance (Element element)
	{
		super(element);
	}

	
	/**
	 * Constructor
	 * 
	 */
	protected AbstractFormElementAppearance ()
	{
		this(DOM.createDiv());
	}
	
	
	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("form-group");
		
		this.label = DOM.createLabel();
		this.ensureCssName(label, "control-label");
		this.label.getStyle().setDisplay(Display.NONE);
		
		this.getElement().appendChild(this.label);
		
		this.requiredAsterisk = DOM.createSpan();
		this.requiredAsterisk.setInnerHTML("*");
		this.ensureCssName(this.requiredAsterisk, "bwt-required-asterisk");
	}
	
	
	/**
	 *
	 * @return String
	 */
	public String getLabel ()
	{
		return this.labelString;
	}
	
	
	/**
	 * 
	 * @return Element
	 */
	public Element getLabelElement ()
	{
		return this.label;
	}
	
	
	/**
	 * 
	 * @return Position
	 */
	public Position getMessagePosition ()
	{
		return this.messagePosition;
	}
	
	
	/**
	 * 
	 */
	public void removeLabel ()
	{
		this.getElement().removeChild(this.label);
	}

	
	/**
	 * 
	 * @param position Position
	 */
	public void setMessagePosition (Position position)
	{
		this.messagePosition = position;
	}
	
	
	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.labelString = label; 
		
		this.label.setInnerHTML(label + "&nbsp;");	
		
		if (label == null || (label.trim().isEmpty()))
		{
			this.label.getStyle().setDisplay(Display.NONE);
		}
		else
		{
			this.label.getStyle().setDisplay(Display.INLINE_BLOCK);
		}
		
		this.updateLabel();
	}
	
	
//	/**
//	 * 
//	 * @param size FormElementSize
//	 */
//	public void setSize (FormElementSize size)
//	{
//		this.removeCssNames(FormElementSize.values());
//		this.ensureCssName(size);		
//	}
//	
	
	/**
	 * 
	 * @param isRequired boolean
	 */
	public void setRequired (boolean isRequired)
	{
		this.isRequired = isRequired;
		
		this.updateLabel();
	}
	
	
	/**
	 * 
	 * @param state FormElement.State
	 */
	public void setState (FormElement.State state)
	{
		this.setState(state, null);
	}
	
	
	/**
	 * 
	 * @param state FormElement.State
	 * @param message String
	 */
	public void setState (FormElement.State state, String message)
	{
		// this.setState(state);
		this.removeCssNames(FormElement.State.values());
		this.ensureCssName(state);
		
		if ((message == null && this.helpBlock == null)
		|| (message == null && this.helpBlock != null && !this.getElement().isOrHasChild(this.helpBlock)))
		{
			return;
		}
		
		if (message == null && this.helpBlock != null && this.getElement().isOrHasChild(this.helpBlock))
		{
			this.messageTooltip.close();
			this.detachHelpBlock(this.helpBlock);
			return;
		}
		
		
		if (this.helpBlock == null)
		{
			this.helpBlock = DOM.createSpan();
			this.helpBlock.addClassName("help-block");
			
			this.helpBlock.addClassName("glyphicon");
			this.helpBlock.addClassName("glyphicon-exclamation-sign");
			this.ensureCssName(this.helpBlock, "help-block-right");
			
			TooltipConfig tooltipConfig = new TooltipConfig();
			tooltipConfig.setTheme(TooltipTheme.DANGER);
			
			this.messageTooltip = Tooltip.tooltip(this.helpBlock, tooltipConfig);
		}
		
		this.attachHelpBlock(this.helpBlock);
		this.messageTooltip.update(message);
	}
	
	
	/**
	 * 
	 */
	protected void attachHelpBlock (Element helpBlock)
	{
		this.getElement().appendChild(helpBlock);	
	}
	
	
	/**
	 * 
	 */
	protected void detachHelpBlock (Element helpBlock)
	{
		this.getElement().removeChild(helpBlock);
	}
	
	
	/**
	 * 
	 */
	protected void updateLabel ()
	{
		if (this.isRequired && !this.label.isOrHasChild(this.requiredAsterisk))
		{
			this.label.appendChild(this.requiredAsterisk);
		}
		else if (!this.isRequired && this.label.isOrHasChild(this.requiredAsterisk))
		{
			this.label.removeChild(this.requiredAsterisk);
		}
	}
}
