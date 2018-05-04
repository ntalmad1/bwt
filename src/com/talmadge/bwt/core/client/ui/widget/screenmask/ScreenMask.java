package com.talmadge.bwt.core.client.ui.widget.screenmask;

import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 *
 */
public class ScreenMask extends BwtWidget
{
    /**
     * Constructor
     * 
     */
    public ScreenMask ()
    {
        this(new DefaultScreenMaskAppearance());
    }
    
    
    /**
     * Hidden Constructor
     * 
     * @param appearance ScreenMaskAppearance
     */
    protected ScreenMask (ScreenMaskAppearance appearance)
    {
        super(appearance);
        
        this.setVisible(false);
    }
    

    /**
     * 
     */
    public void hide ()
    {
        super.hide();
        BwtElementUtils.hide(this.getElement());
    }
    
    
    
    /**
     * 
     * @param message String
     */
    public void setText (String message)
    {
        this.getAppearance().setText(message);
    }


    /**
     * 
     */
    public void show ()
    {
        this.show();
    }
    
    
    /**
     * 
     * @param message String
     */
    public void show (String message)
    {
        if (!this.isVisible())
        {
            this.setText(message);
            
            RootPanel.get().getElement().appendChild(this.getElement());
            BwtWidgetUtils.attachWidget(this);
            
            this.getAppearance().layout();
            
            super.show();
            BwtElementUtils.show(this.getElement());
        }
    }
    
    
    /**
     * 
     * @return ScreenMaskAppearance
     */
    protected ScreenMaskAppearance getAppearance ()
    {
        return (ScreenMaskAppearance) super.getAppearance();
    }
}
