package com.talmadge.bwt.core.client.ui.widget.button.dropdown;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasText;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Direction;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Mode;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroupCell;
import com.talmadge.bwt.core.client.ui.widget.caret.Caret;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
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
public class DropdownButtonCell extends ButtonGroupCell implements 
	  HasBeforeMenuHideHandlers
	, HasBeforeMenuShowHandlers
	, HasMenuHideHandlers
	, HasMenuShowHandlers
	, HasText 
{	
	/**
	 */
	private Button button;
	
	/**
	 */
	private Caret caret;
	
	/**
	 */
	private DropdownJQueryBridge eventBridge;

	/**
	 */
	private Menu menu;
	
	/**
	 */
	private DropdownButton.Mode mode = Mode.CLICK;
	
	
	/**
	 * Constructor 
	 * 
	 */
	public DropdownButtonCell ()
	{
		super((DropdownButtonAppearance) GWT.create(DefaultDropdownButtonAppearance.class));
		this.build();
	}
	
	
	/**
	 * 
	 * @param handler BeforeMenuHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeMenuHideHandler (BeforeMenuHideHandler handler)
	{
		return this.addHandler(handler, BeforeMenuHideEvent.getType());
	}


	/**
	 * 
	 * @param handler BeforeMenuShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeMenuShowHandler (BeforeMenuShowHandler handler)
	{
		return this.addHandler(handler, BeforeMenuShowEvent.getType());
	}


	/**
	 * 
	 * @param menuItem MenuItem
	 */
	public void addItem (MenuItem menuItem)
	{
		this.menu.add(menuItem);		
	}
	
	
	/**
	 * 
	 * @param menuHeader MenuHeader
	 */
	public void addHeader (MenuHeader menuHeader)
	{
		this.menu.add(menuHeader);		
	}

	
	/**
	 * 
	 * @param handler MenuHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addMenuHideHandler (MenuHideHandler handler)
	{
		return this.addHandler(handler, MenuHideEvent.getType());
	}


	/**
	 * 
	 * @param handler MenuShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addMenuShowHandler (MenuShowHandler handler)
	{
		return this.addHandler(handler, MenuShowEvent.getType());
	}


	/**
	 * 
	 * @param separator MenuSeparator
	 */
	public void addSeparator (MenuSeparator separator)
	{
		this.menu.add(separator);		
	}

	
	/**
	 * 
	 */
	public void collapse ()
	{
		if (!this.isExpanded())
		{
			return;
		}
		
		this.toggle();
	}

	/**
	 * 
	 */
	public void expand ()
	{
		if (this.isExpanded())
		{
			return;
		}
		
		this.toggle();
	}


	/**
	 * 
	 * @return DropdownButtonCellAppearance
	 */
	public DropdownButtonAppearance getAppearance ()
	{
		return (DropdownButtonAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @return Button
	 */
	public Button getButton ()
	{
		return this.button;
	}


	/**
	 * 
	 * @return DropdownButton.Mode 
	 */
	public DropdownButton.Mode getMode ()
	{
		return this.mode;
	}
	
	/**
	 * 
	 * @return Menu
	 */
	public Menu getMenu ()
	{
		return this.menu;
	}


	/**
	 * 
	 * @return String 
	 */
	public String getText () 
	{
		return this.getAppearance().getText();
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isExpanded ()
	{
		return this.getElement().hasClassName("open");
	}


	/**
	 * 
	 * @param direction Direction
	 */
	public void setDirection (Direction direction)
	{
		this.getAppearance().setDirection(direction);		
	}

	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.button.setIcon(icon);
	}

	
	/**
	 * 
	 * @param menuAlign MenuAlign
	 */
	public void setMenuAlign (MenuAlign menuAlign)
	{
		this.menu.setMenuAlign(menuAlign);		
	}


	/**
	 * 
	 * @param mode Mode
	 */ 
	public void setMode (Mode mode)
	{
		this.mode = mode;	
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.getAppearance().setText(text);	
		this.button.getElement().appendChild(this.caret.getElement());
	}
	
	
	/**
	 * 
	 */
	public void toggle ()
	{
		if (this.isExpanded())
		{
			// do collapse
			this._beforeMenuHide(this.getId());
			this.getElement().removeClassName("open");
			this._menuHide(this.getId());
		}
		else
		{
			// do expand
			this._beforeMenuShow(this.getId());
			Scheduler.get().scheduleDeferred(new ScheduledCommand()
			{
				public void execute ()
				{
					DropdownButtonCell.this.ensureCssName("open");
					DropdownButtonCell.this._menuShow(DropdownButtonCell.this.getId());
				}
			});
		}
	}


	/**
	 * 
	 */
	protected void bindButton ()
	{
		final Timer collapseTimer = new Timer()
		{
			public void run ()
			{
				DropdownButtonCell.this.collapse();
				
			}
		};
		
		this.addDomHandler(new MouseOverHandler()
		{
			public void onMouseOver (MouseOverEvent event)
			{
				if (DropdownButton.Mode.HOVER.equals(DropdownButtonCell.this.getMode()))
				{
					collapseTimer.cancel();
					DropdownButtonCell.this.expand();
				}
			}
			
		}, MouseOverEvent.getType());
		
		
		this.addDomHandler(new MouseOutHandler()
		{
			public void onMouseOut (MouseOutEvent event)
			{
				if (DropdownButton.Mode.HOVER.equals(DropdownButtonCell.this.getMode()))
				{
					collapseTimer.schedule(250);
				}
			}
			
		}, MouseOutEvent.getType());
		
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.button = new Button();
		this._add(this.button);
		
		this.caret = new Caret();
		this.button.getElement().appendChild(this.caret.getElement());
		
		this.getChildren().add(this.caret);
		
		this.menu = new Menu();
		this.menu.ensureCssName("dropdown-menu");
		this.menu.getElement().getStyle().setPosition(Position.ABSOLUTE);
		
		this.getElement().appendChild(this.menu.getElement());
		
		this.getChildren().add(this.menu);
		
		this.getAppearance().setButton(this.button);
		
		this.eventBridge = new DropdownJQueryBridge(this);
		
		this.bindButton();
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
	 */
	protected  void onLoad ()
	{
		this.eventBridge.attach();
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


	/**
	 * 
	 */
	protected  void onUnload ()
	{
		this.eventBridge.detach();
	}


	/**
	 * 
	 * @param id String
	 */
	protected void _beforeMenuHide (String id)
	{
		BeforeMenuHideEvent event = new BeforeMenuHideEvent(this.menu);
		this.fireEvent(event);
		this.onBeforeMenuHide(event);
	}
	
	
	/**
	 * 
	 * @param id String
	 */
	protected void _beforeMenuShow (String id)
	{
		BeforeMenuShowEvent event = new BeforeMenuShowEvent(this.menu);
		this.fireEvent(event);
		this.onBeforeMenuShow(event);
	}
	
	
	/**
	 * 
	 * @param id String
	 */
	protected void _menuHide (String id)
	{
		MenuHideEvent event = new MenuHideEvent(this.menu);
		this.fireEvent(event);
		this.onMenuHide(event);
	}
	
	
	/**
	 * 
	 * @param id String
	 */
	protected void _menuShow (String id)
	{
		MenuShowEvent event = new MenuShowEvent(this.menu);
		this.fireEvent(event);
		this.onMenuShow(event);
	}
}
