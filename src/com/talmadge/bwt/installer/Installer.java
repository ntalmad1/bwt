package com.talmadge.bwt.installer;

import com.talmadge.bwt.installer.lib.InstallerFrame;
import com.talmadge.bwt.installer.lib.util.InstallerUtils;

/**
 * 
 *
 */
public final class Installer
{

    /**
     * 
     * @param args String[
     */
    public static void main (String[] args)
    {
        InstallerFrame dialog = new InstallerFrame();
        
        InstallerUtils.centerFrame(dialog, 460, 150);
        
        dialog.setVisible(true);
    }
    
    
    /**
     * Hidden Constructor
     * 
     */
    private Installer ()
    {
        
    }
    
}
