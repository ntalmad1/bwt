package com.talmadge.bwt.installer.lib.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 *
 */
public final class InstallerUtils
{
    /**
     * 
     * @param frame JFrame
     * @param width int
     * @param height int
     */
    public static void centerFrame (JFrame frame, int width, int height)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        
        frame.setSize(width, height);
        
        int x = (int) (screenWidth / 2) - (width / 2);
        int y = (int) (screenHeight / 2) - (height / 2);
                
        frame.setLocation(x, y);        
    }
    
    
    /**
     * Hidden Constructor 
     * 
     */
    private InstallerUtils ()
    {
        
    }
}
