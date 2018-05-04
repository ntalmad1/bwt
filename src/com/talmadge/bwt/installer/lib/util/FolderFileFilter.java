package com.talmadge.bwt.installer.lib.util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * 
 */
public class FolderFileFilter extends FileFilter
{
    @Override
    public boolean accept (File file)
    {
        return (file.isDirectory());
    }

    @Override
    public String getDescription ()
    {
       return "Folder";
    }
}
