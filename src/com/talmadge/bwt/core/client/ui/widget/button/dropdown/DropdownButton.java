package com.talmadge.bwt.core.client.ui.widget.button.dropdown;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.HasCssName;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.Disableable;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide.BeforeMenuHideEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide.BeforeMenuHideHandler;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide.HasBeforeMenuHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow.BeforeMenuShowEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow.BeforeMenuShowHandler;
import com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow.HasBeforeMenuShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.menu.event.hide.HasMenuHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.menu.event.hide.MenuHideEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.event.hide.MenuHideHandler;
import com.talmadge.bwt.core.client.ui.widget.menu.event.show.HasMenuShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.menu.event.show.MenuShowEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.event.show.MenuShowHandler;
import com.talmadge.bwt.core.client.ui.widget.menu.header.MenuHeader;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.menu.separator.MenuSeparator;

/**
 * 
 * @author Noah
 *
 */
public class DropdownButton extends BwtComposite implements 
	  Disableable 
	, HasBeforeMenuHideHandlers
	, HasBeforeMenuShowHandlers
	, HasMenuHideHandlers
	, HasMenuShowHandlers 
	, HasText
{
	/**
	 */
	public enum Direction
	{
		/**
		 */
		DOWN,
		
		/**
		 */
		UP;
	}
	
	
	/**
	 */
	public enum MenuAlign implements HasCssName
	{
		/**
		 */
		LEFT("dropdown-menu-left"),
		
		/**
		 */
		RIGHT("dropdown-menu-right");

		
		/**
		 */
		private String cssName;
		
		
		/**
		 * Constructor
		 * 
		 * @param cssName String
		 */
		MenuAlign (String cssName)
		{
			this.cssName = cssName;
		}
		
		
		/**
		 * 
		 * @return String
		 */
		public String getCssName ()
		{
			return this.cssName;
		}
	}
	
	
	/**
	 */
	public enum Mode
	{
		/**
		 */
		HOVER,
		
		/**
		 */
		CLICK;
	}


	/**
	 */
	private DropdownButtonCell cell;
	
	
	/**
	 * 
	 */
	public DropdownButton ()
	{
		this(new DropdownButtonCell());
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public DropdownButton (String text)
	{
		this();
		
		this.setText(text);
	}

	/**
	 * Constructor
	 * 
	 * @param icon Glyphicon
	 * @param text String
	 */
	public DropdownButton (Glyphicon icon, String text)
	{
		this();
		
		this.setText(text);
		this.setIcon(icon);
	}
	
	
	/**
	 * 
	 * @param cell DropdownButtonCell
	 */
	protected DropdownButton (DropdownButtonCell cell)
	{
		this.cell = cell;
		
		this.cell.addBeforeMenuHideHandler(new BeforeMenuHideHandler()
		{
			/**
			 * @param event BeforeMenuHideEvent
			 */
			public void onBeforeMenuHide (BeforeMenuHideEvent event)
			{
				DropdownButton.this.onBeforeMenuHide(event);
			}
		});
		
		this.cell.addBeforeMenuShowHandler(new BeforeMenuShowHandler()
		{
			/**
			 * @param event BeforeMenuShowEvent
			 */
			public void onBeforeMenuShow (BeforeMenuShowEvent event)
			{
				DropdownButton.this.onBeforeMenuShow(event);
			}
		});
			
		
		this.cell.addMenuHideHandler(new MenuHideHandler()
		{
			/**
			 * @param event MenuHideEvent
			 */
			public void onMenuHide (MenuHideEvent event)
			{
				DropdownButton.this.onMenuHide(event);
			}
		});
			
		
		this.cell.addMenuShowHandler(new MenuShowHandler()
		{
			/**
			 * @param event MenuShowEvent
			 */
			public void onMenuShow (MenuShowEvent event)
			{
				DropdownButton.this.onMenuShow(event);
			}
		});
		
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param menuHeader MenuHeader
	 */
	public void add (MenuHeader menuHeader)
	{
		this.addHeader(menuHeader);		
	}

	
	/**
	 * 
	 * @param menuItem MenuItem
	 */
	public void add (MenuItem menuItem)
	{
		this.addItem(menuItem);
	}

	/**
	 * 
	 * @param menuSeparator MenuSeparator
	 */
	public void add (MenuSeparator menuSeparator)
	{
		this.addSeparator(menuSeparator); 
	}


	/**
	 * 
	 * @param handler BeforeMenuHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeMenuHideHandler (BeforeMenuHideHandler handler)
	{
		return this.getCell().addHandler(handler, BeforeMenuHideEvent.getType());
	}


	/**
	 * 
	 * @param handler BeforeMenuShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeMenuShowHandler (BeforeMenuShowHandler handler)
	{
		return this.getCell().addHandler(handler, BeforeMenuShowEvent.getType());
	}


	/**
	 * 
	 * @param header MenuHeader
	 */
	public void addHeader (MenuHeader header)
	{
		this.getCell().addHeader(header);
	}


	/**
	 * 
	 * @param string String
	 */
	public void addHeader (String string)
	{
		this.addHeader(new MenuHeader(string));
		
	}


	/**
	 * 
	 * @param menuItem MenuItem
	 */
	public void addItem (MenuItem menuItem)
	{
		this.getCell().addItem(menuItem);
	}
	
	
	/**
	 * 
	 * @param handler MenuHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addMenuHideHandler (MenuHideHandler handler)
	{
		return this.getCell().addHandler(handler, MenuHideEvent.getType());
	}


	/**
	 * 
	 * @param handler MenuShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addMenuShowHandler (MenuShowHandler handler)
	{
		return this.getCell().addHandler(handler, MenuShowEvent.getType());
	}


	/**
	 * 
	 */
	public void addSeparator ()
	{
		this.addSeparator(new MenuSeparator());
	}
	
	
	/**
	 * 
	 * @param separator MenuSeparator
	 */
	public void addSeparator (MenuSeparator separator)
	{
		this.getCell().addSeparator(separator);
	}


	/**
	 * 
	 */
	public void collapse ()
	{
		this.getCell().collapse();
		
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
	 */
	public void enable ()
	{
		this.setDisabled(false);	
		
	}


	/**
	 * 
	 */
	public void expand ()
	{
		this.getCell().expand();
	}


	/**
	 * 
	 * @param isDisabled boolean
	 */
	public void setDisabled (boolean isDisabled)
	{
		this.getCell().setDisabled(true);
	}

	
	/**
	 * 
	 * @param display Display
	 */
	public void setDisplay (Display display)
	{
		this.getCell().setDisplay(display);		
	}


	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.getCell().getText();
	}

	
	/**
	 * 
	 * @param direction Direction
	 */
	public void setDirection (Direction direction)
	{
		this.getCell().setDirection(direction);		
	}


	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.getCell().setIcon(icon);
	}

	
	/**
	 * 
	 * @param menuAlign MenuAlign
	 */
	public void setMenuAlign (MenuAlign menuAlign)
	{
		this.getCell().setMenuAlign(menuAlign);		
	}


	/**
	 * 
	 * @param mode Mode
	 */
	public void setMode (Mode mode)
	{
		this.getCell().setMode(mode);
	}
	
	
	/**
	 * 
	 * @param size ButtonSize
	 */
	public void setButtonSize (ButtonSize size)
	{
		this.getCell().setButtonSize(size);
	}


	/**
	 * 
	 * @param style ButtonStyle
	 */
	public void setStyle (ButtonStyle style)
	{
		this.getCell().setButtonStyle(style);
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.getCell().setText(text);
	}


	/**
	 * 
	 * @return DropdownButtonCell
	 */
	protected DropdownButtonCell getCell ()
	{
		return this.cell;
	}


	/**
	 * 
	 * @param event BeforeMenuHideEvent
	 */
	protected void onBeforeMenuHide (BeforeMenuHideEvent event)
	{
		
	}


	/**
	 * 
	 * @param event BeforeMenuShowEvent
	 */
	protected void onBeforeMenuShow (BeforeMenuShowEvent event)
	{
		
	}


	/**
	 * 
	 * @param event MenuHideEvent
	 */
	protected void onMenuHide (MenuHideEvent event)
	{
		
	}


	/**
	 * 
	 * @param event MenuShowEvent
	 */
	protected void onMenuShow (MenuShowEvent event)
	{
		
	}	
}
