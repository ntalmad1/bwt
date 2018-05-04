package com.talmadge.bwt.core.client.ui.widget.gallery;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.MarginBottom;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.event.resize.BwtResizeEvent;
import com.talmadge.bwt.core.client.ui.widget.event.resize.BwtResizeHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.LeftEvent;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.LeftHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.RightEvent;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.RightHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.filmstrip.BwtFilmStrip;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;
import com.talmadge.bwt.core.client.ui.widget.gallery.viewer.BwtGalleryViewer;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 * 
 *
 */
public class BwtGalleryCell extends BwtWidgetContainer
{
    /**
     */
    private List<BwtGalleryItem> items;
    
    /**
     */
    private BwtGalleryViewer viewer;
    
    /**
     */
    private BwtFilmStrip filmStrip;
    
    
    /**
     * Constructor
     * 
     */
    protected BwtGalleryCell ()
    {
        this(new DefaultBwtGalleryAppearance());
    }
    
    
    /**
     * 
     * @param appearance BwtGalleryAppearance
     */
    protected BwtGalleryCell (BwtGalleryAppearance appearance)
    {
        super(appearance);
        
        this.items = new ArrayList<BwtGalleryItem>();
        
        this.build();
    }
    
    
    /**
     * 
     * @param item BwtGalleryItem
     */
    public void add (BwtGalleryItem item)
    {
        BwtImage img = new BwtImage(item.getUrl());
        img.setResponsive(true);
        img.setCenterBlock(true);
        item.setImg(img);
        
        this.getItems().add(item);
        this.getFilmStrip().add(item);
    }
    
    
    /**
     * 
     * @return BwtFilmStrip
     */
    public BwtFilmStrip getFilmStrip ()
    {
        return this.filmStrip;
    }


    /**
     * 
     * @return BwtGalleryViewer
     */
    public BwtGalleryViewer getViewer ()
    {
        return this.viewer;
    }
    
    
    /**
     * 
     */
    protected void bind ()
    {
        this.addBwtResizeHandler(new BwtResizeHandler()
        {
            public void onResize (BwtResizeEvent event)
            {
                BwtGalleryCell.this.layout();
            }           
        });
        
        
        this.viewer.addLeftHandler(new LeftHandler()
        {
            public void onLeft (LeftEvent event)
            {
                Window.alert("LEFT");
                
            }
        });
        
        
        this.viewer.addRightHandler(new RightHandler()
        {
            public void onRight (RightEvent event) 
            {
                Window.alert("RIGHT");
            }
        });
    }

    
    /**
     * 
     */
    protected void build ()
    {
        this.viewer = new BwtGalleryViewer();
        this.filmStrip = new BwtFilmStrip();
        
        this.add(this.viewer, new MarginBottom(10));
        this.add(this.filmStrip);
        
        this.bind();
    }


    /**
     * 
     * @return List<BwtGalleryItem>
     */
    protected List<BwtGalleryItem> getItems ()
    {
        return this.items;
    }
    
    
    /**
     * 
     * @param index int
     */
    protected void gotoIndex (int index)
    {
        BwtGalleryItem item = this.getItems().get(index);
        
        this.getViewer().update(item);
    }


    /**
     * 
     */
    protected void layout ()
    {
        this.getViewer().layout();       
        this.getFilmStrip().layout(this.getViewer().getHeight());
    }


    /**
     * 
     */
    protected void onAttach ()
    {
        super.onAttach();
        
        Scheduler.get().scheduleDeferred(new ScheduledCommand()
        {
            public void execute ()
            {
                BwtGalleryCell.this.layout();
            }
        });
        
        this.gotoIndex(0);
    }
}
