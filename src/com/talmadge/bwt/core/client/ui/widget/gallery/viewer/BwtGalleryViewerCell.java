package com.talmadge.bwt.core.client.ui.widget.gallery.viewer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.HasLeftHandlers;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.LeftEvent;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.LeftHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.HasRightHandlers;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.RightEvent;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.RightHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;

/**
 * 
 *
 */
public class BwtGalleryViewerCell extends BwtWidgetContainer implements HasLeftHandlers, HasRightHandlers
{
    /**
     */
    private LayoutColumn contentCol;

    /**
     */
    private LayoutColumn left;
    
    /**
     */
    private LayoutColumn right;
    
    /**
     */
    private Html leftButton;

    /**
     */
    private Html rightButton;

    /**
     * Contructor
     * 
     */
    protected BwtGalleryViewerCell ()
    {
        this((BwtGalleryViewerAppearance) GWT.create(DefaultBwtGalleryViewerAppearance.class));
    }
    
    
    /**
     * 
     * @param appearance BwtGalleryAppearance
     */
    protected BwtGalleryViewerCell (BwtGalleryViewerAppearance appearance)
    {
       super(appearance);
       
       this.build();
    }
    
    
    /**
     * 
     * @return handler LeftHandler
     */
    @Override
    public HandlerRegistration addLeftHandler (LeftHandler handler)
    {
        return this.addHandler(handler, LeftEvent.getType());
    }

    
    /**
     * 
     * @return handler RightHandler
     */
    @Override
    public HandlerRegistration addRightHandler (RightHandler handler)
    {
        return this.addHandler(handler, RightEvent.getType());
    }


    /**
     * 
     */
    public void layout ()
    {
        this.layoutLeftRightButtons();
    }


    /**
     * 
     * @param item BwtGalleryItem
     */
    public void update (final BwtGalleryItem item)
    {
        BwtImage img = item.getImg();
        if (!img.isLoaded())
        {
            img.addLoadHandler(new LoadHandler()
            {
                public void onLoad (LoadEvent event)
                {
                    BwtGalleryViewerCell.this.updateContent(item);
                    
                }
            });
        }
        else 
        {
            BwtGalleryViewerCell.this.updateContent(item);
        }
    }
        
       


    /**
     * 
     */
    protected void build ()
    {
        LayoutRow layout = new LayoutRow();
        
        LayoutColumn left = this.createLeft();
        LayoutColumn right = this.createRight(); 
        
        this.contentCol = new LayoutColumn();
        this.contentCol.setContentAlign(ContentAlign.CENTER);
        BwtWidgetUtils.ensureCssName(this.contentCol, "bwt-gallery-content-col");
        
        layout.add(left, Size.XS, 1);
        layout.add(this.contentCol, Size.XS, 10);
        layout.add(right, Size.XS, 1);
        
        this.add(layout);
    }


    /**
     * 
     */
    protected void layoutLeftRightButtons ()
    {
        int height = this.getContentCol().getHeight();
       
        
        this.left.getElement().getStyle().setPaddingTop((height / 2) - (this.leftButton.getHeight() / 2), Unit.PX);
        this.right.getElement().getStyle().setPaddingTop((height / 2) - (this.rightButton.getHeight() / 2), Unit.PX);
    }


    /**
     * 
     */
    protected void onAttach ()
    {
        super.onAttach();
    }


    /**
     * 
     * @return BwtGalleryAppearance
     */
    protected BwtGalleryViewerAppearance getAppearance ()
    {
        return (BwtGalleryViewerAppearance) super.getAppearance();
    }

    
    /**
     * 
     * @return LayoutColumn
     */
    protected LayoutColumn getContentCol ()
    {
        return this.contentCol;
    }
    
    
    /**
     * 
     */
    protected void onLeft ()
    {
        this.fireEvent(new LeftEvent());        
    }

    
    /**
     * 
     */
    protected void onRight ()
    {
        this.fireEvent(new RightEvent());        
    }


    /**
     * 
     * @param item BwtGalleryItem
     */
    protected void updateContent (BwtGalleryItem item)
    {
        this.getContentCol().clear();
        this.getContentCol().add(item.getImg());
        
        this.layoutLeftRightButtons();
      
    }
    
    
    /**
     * 
     * @return LayoutColoumn
     */
    private LayoutColumn createLeft ()
    {
        this.left = new LayoutColumn();
        BwtWidgetUtils.ensureCssName(this.left, "bwt-gallery-left-col");
        
        
        
        this.leftButton = new A();
        Html arrow = Html.span();
        arrow.ensureCssName("glyphicon").ensureCssName("glyphicon-chevron-left");
        
        this.leftButton.add(arrow);
        
        this.leftButton.getElement().getStyle().setCursor(Cursor.POINTER);
        
        this.left.add(this.leftButton);
        
        this.leftButton.addDomHandler(new ClickHandler()
        {
            public void onClick (ClickEvent event)
            {
                BwtGalleryViewerCell.this.onLeft();                
            }
        }, ClickEvent.getType());
        
        return this.left;
    }
    
    
    /**
     * 
     * @return LayoutColumn
     */
    private LayoutColumn createRight ()
    {
        this.right = new LayoutColumn();
        BwtWidgetUtils.ensureCssName(this.right, "bwt-gallery-right-col");
        
        this.rightButton = new A();
       
        Html arrow = Html.span();
        arrow.ensureCssName("glyphicon").ensureCssName("glyphicon-chevron-right");
        
        this.rightButton.add(arrow);
        
        this.rightButton.getElement().getStyle().setCursor(Cursor.POINTER);
        
        this.right.add(this.rightButton);
        
        this.rightButton.addDomHandler(new ClickHandler()
        {
            public void onClick (ClickEvent event)
            {
                BwtGalleryViewerCell.this.onRight();                
            }
        }, ClickEvent.getType());
        
        return this.right;
    }
}
