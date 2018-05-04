package com.talmadge.bwt.core.client.ui.widget.container.dialog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.DialogStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.BwtDialogBody;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.BwtDialogContent;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.BwtDialogContentWrapper;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.BwtDialogFooter;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.header.BwtDialogHeader;
import com.talmadge.bwt.core.client.ui.widget.event.afterhide.AfterHideEvent;
import com.talmadge.bwt.core.client.ui.widget.event.afterhide.AfterHideHandler;
import com.talmadge.bwt.core.client.ui.widget.event.afterhide.HasAfterHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.aftershow.AfterShowEvent;
import com.talmadge.bwt.core.client.ui.widget.event.aftershow.AfterShowHandler;
import com.talmadge.bwt.core.client.ui.widget.event.aftershow.HasAfterShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.hide.HasHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.hide.HideEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.event.show.HasShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.show.ShowEvent;

/**
 * 
 */
public class BwtDialog extends BwtWidgetContainer implements HasHideHandlers, HasAfterHideHandlers, HasShowHandlers, HasAfterShowHandlers
{	
	/**
	 * 
	 * @param title String
	 * @return BwtDialog
	 */
	public static BwtDialog confirmDialog (String title)
	{
		BwtDialog dialog = new BwtConfirmDialog(title);
		
		return dialog;
	}

	/**
	 */
	private BwtWidgetContainer parent;
	
	/**
	 */
	private JQueryBridge jQueryBridge;

	/**
	 */
	private BwtDialogContentWrapper contentWrapper;

	/**
	 */
	private BwtDialogContent content;

	/**
	 */
	private BwtDialogHeader header;

	/**
	 */
	private BwtDialogBody body;

	/**
	 */
	private BwtDialogFooter footer;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public BwtDialog ()
	{
		this((BwtDialogAppearance) GWT.create(DefaultBwtDialogAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance
	 */
	protected BwtDialog (BwtDialogAppearance appearance)
	{
		super(appearance);
		
		this.contentWrapper = new BwtDialogContentWrapper();
		this.content = new BwtDialogContent();
		this.header = new BwtDialogHeader();
		this.body   = new BwtDialogBody();
		this.footer   = new BwtDialogFooter();
		
		this.contentWrapper.add(this.content);
		this.content.add(this.header);
		this.content.add(this.body);
		this.content.add(this.footer);
		
		super.add(contentWrapper);
		
		this.jQueryBridge = new JQueryBridge(this);
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param handler AfterHideHandler<W>
	 * @return HandlerRegistration
	 */
	@Override
	public <W extends BwtWidget> HandlerRegistration addAfterHideHandler (AfterHideHandler<W> handler)
	{
		return this.addHandler(handler, AfterHideEvent.getType());
	}

	
	/**
	 * 
	 * @param handler AfterShowHandler<W>
	 * @return HandlerRegistration
	 */
	@Override
	public <W extends BwtWidget> HandlerRegistration addAfterShowHandler (AfterShowHandler<W> handler)
	{
		return this.addHandler(handler, AfterShowEvent.getType());
	}


	/**
	 * 
	 * @return Button
	 */
	public Button getCloseButton ()
	{
		return this.header.getCloseButton();
	}


	/**
	 * 
	 * @return BwtWidgetContainer
	 */
	public BwtWidgetContainer getParent ()
	{
		return this.parent;
	}
	
	
	/**
	 * 
	 */
	public void hide ()
	{
		if (this.isAttached())
		{
			this.getJQueryBridge().hide();
			
			if (this.getParent() == null)
			{
				RootPanel.get().remove(this);
			}
			else
			{
				this.getParent().remove(this);
			}			
		}
		
		
	}
	
	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.header.setIcon(icon);		
	}


	/**
	 * 
	 * @param style DialogStyle
	 */
	public void setDialogStyle (DialogStyle style)
	{
		this.content.setDialogStyle(style);		
	}

	
	/**
	 * 
	 * @param title String
	 */
	public void setTitle (String title)
	{
		this.header.setTitle(title);
	}
	

	/**
	 * 
	 */
	public void show ()
	{
		if (!this.isAttached())
		{
			if (this.getParent() == null)
			{
				RootPanel.get().add(this);
			}
			else
			{
				this.getParent().add(this);
			}
		}
		
		this.getJQueryBridge().show();
	}
	
	
	/**
	 * 
	 */
	protected void bind ()
	{
		this.header.getCloseButton().addSelectHandler(new SelectHandler<Button>()
		{
			public void onSelect (SelectEvent<Button> event)
			{
				BwtDialog.this.hide();
			}
		});
	}
	
	
	/**
	 * 
	 * @return JQueryBridge
	 */
	protected JQueryBridge getJQueryBridge ()
	{
		return this.jQueryBridge;
	}
	
	
	/**
	 * 
	 */
	protected void onAfterHide ()
	{
		
	}
	
	
	/**
	 * 
	 */
	protected void onAfterShow ()
	{
		
	}
	
	
	/**
	 * 
	 */
	protected void onHide ()
	{
		
	}
	
	
	/**
	 * 
	 */
	protected void onShow ()
	{
		
	}
	
	
	/**
	 *
	 */
	protected void onInitialAttach ()
	{
		super.onInitialAttach();
		
		this.jQueryBridge.attach();
	}
	
	
	/**
	 * 
	 */
	protected void _afterHide ()
	{
		AfterHideEvent<BwtDialog> event = new AfterHideEvent<BwtDialog>(this);
		
		this.fireEvent(event);
		
		this.onAfterHide();
	}
	
	
	/**
	 * 
	 */
	protected void _afterShow ()
	{
		AfterShowEvent<BwtDialog> event = new AfterShowEvent<BwtDialog>(this);
		
		this.fireEvent(event);
		
		this.onAfterShow();
	}
	
	
	/**
	 * 
	 */
	protected void _hide ()
	{
		HideEvent<BwtDialog> event = new HideEvent<BwtDialog>(this);
		
		this.fireEvent(event);
		
		this.onHide();
	}
	
	
	/**
	 * 
	 */
	protected void _show ()
	{
		ShowEvent<BwtDialog> event = new ShowEvent<BwtDialog>(this); 
		
		this.fireEvent(event);
		
		this.onShow();
	}
}
