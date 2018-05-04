package com.talmadge.bwt.core.client.ui.widget.gallery.filmstrip;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;
import com.talmadge.bwt.core.client.ui.widget.gallery.thumbpanel.ThumbPanel;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;

/**
 * 
 *
 */
public class BwtFilmStripCell extends BwtWidgetContainer
{
    /**
     */
    private List<BwtGalleryItem> items;
    
	/**
     */
    private LayoutColumn middleCol;
    
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
	 * Constructor
	 * 
	 */
	public BwtFilmStripCell ()
	{
		this(new DefaultBwtFilmStripAppearance());
	}
	
	
	/**
	 * 
	 * @param appearance BwtFilmStripAppearance
	 */
	protected BwtFilmStripCell (BwtFilmStripAppearance appearance)
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
        this.items.add(item);
        
        this.createThumbs();
    }
	
	
	/**
	 * 
	 * @return List<BwtGalleryItem>
	 */
	public List<BwtGalleryItem> getItems ()
	{
	    return this.items;
	}

	
	/**
	 * 
	 * @param viewerHeight int
	 */
    public void layout (int viewerHeight)
    {
        this.layoutLeftRightButtons();
    }


    /**
     * 
     */
    protected void build ()
    {
        LayoutRow layout = new LayoutRow();
        
        LayoutColumn left = this.createLeft();
        LayoutColumn right = this.createRight(); 
        
        this.middleCol = new LayoutColumn(); 
        this.middleCol.setContentAlign(ContentAlign.CENTER);
        BwtWidgetUtils.ensureCssName(this.middleCol, "bwt-filmstrip-middle-col");
        
        layout.add(left, Size.XS, 1);
        layout.add(this.middleCol, Size.XS, 10);
        layout.add(right, Size.XS, 1);
        
        this.add(layout);
    }
	
	
	/**
	 * 
	 * @return BwtFilmStripAppearance
	 */
	protected BwtFilmStripAppearance getAppearance ()
	{
		return (BwtFilmStripAppearance) super.getAppearance();
	}

	
	/**
     * 
     */
    protected void layoutLeftRightButtons ()
    {
        int height = this.getHeight();
        
        this.left.getElement().getStyle().setPaddingTop((height / 2) - 20, Unit.PX);
        this.right.getElement().getStyle().setPaddingTop((height / 2) - 20, Unit.PX);
    }
	
	
	/**
	 * 
	 */
    private void createThumbs ()
    {
        ThumbPanel thumbPanel = new ThumbPanel();
        
        for (int i = 0; i < this.getItems().size() && i < 3; ++i)
        {
            thumbPanel.add(this.getItems().get(i));
        }
        
        
        this.middleCol.clear();
        
        this.middleCol.add(thumbPanel);
    }


    /**
     * 
     * @return LayoutColoumn
     */
    private LayoutColumn createLeft ()
    {
        this.left = new LayoutColumn();
        BwtWidgetUtils.ensureCssName(this.left, "bwt-filmstrip-left-col");
        
        this.leftButton = new A();
        
        Html arrow = Html.span();
        arrow.ensureCssName("glyphicon").ensureCssName("glyphicon-backward");
        
        
        this.leftButton.add(arrow);
        
        this.left.add(this.leftButton);
        
        return this.left;
    }


    /**
     * 
     * @return LayoutColumn
     */
    private LayoutColumn createRight ()
    {
        this.right = new LayoutColumn();
        BwtWidgetUtils.ensureCssName(this.right, "bwt-filmstrip-right-col");
        
        this.rightButton = new A();
    
        Html arrow = Html.span();
        arrow.ensureCssName("glyphicon").ensureCssName("glyphicon-forward");
        
        this.rightButton.add(arrow);
        
        this.right.add(this.rightButton);
        
        return this.right;
    }
}
