package com.talmadge.bwt.installer.lib;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.talmadge.bwt.installer.lib.InstallHandler.Mode;
import com.talmadge.bwt.installer.lib.util.FolderFileFilter;


/**
 * 
 *
 */
@SuppressWarnings("serial")
public class InstallerFrame extends JFrame
{
    /**
     */
    private JFileChooser fileChooser;

	private JRadioButton symlinks;
    

    
    /**
	 */
	private JTextField textField;



	/**
     * Create the application.
     */
    public InstallerFrame ()
    {
        super();
        initialize();
    }

    /**
     * 
     */
    protected void onInstall ()
    {
        if (this.textField.getText() == null || this.textField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please select a folder to install to.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        try
        {
            File installToDir = this.fileChooser.getSelectedFile();
            
            
            Mode mode = Mode.LINK;
            
            if (!this.symlinks.isSelected())
            {
            	mode = Mode.COPY;
            }
            
            
            InstallHandler installHandler = new InstallHandler(installToDir, mode);
            installHandler.install();
            
            JOptionPane.showMessageDialog(this, "BWT successfully installed.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            
            this.setVisible(false);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    

    /**
     */
    protected void onSelect ()
    {
        if (this.fileChooser == null) 
        {
            this.fileChooser = new JFileChooser();
            this.fileChooser.setFileFilter(new FolderFileFilter());
            this.fileChooser.setDialogTitle("Select Path...");
            this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            this.fileChooser.setAcceptAllFileFilterUsed(false);
        }
        
        if (this.fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        { 
            this.textField.setText(this.fileChooser.getSelectedFile().getAbsolutePath());
        }       
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize ()
    {
        this.setTitle("Install BWT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 4, 0, 0));
        
        JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblPath = new JLabel("Path");
        panel_2.add(lblPath);
        lblPath.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPath.setHorizontalAlignment(SwingConstants.CENTER);
        
        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(25);
        textField.setEditable(false);
        
        JButton btnSelect = new JButton("select...");
        btnSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                InstallerFrame.this.onSelect();
                
            }
        });
        panel_2.add(btnSelect);
        
        
        
        this.symlinks = new JRadioButton("Symlinks");
        symlinks.setSelected(true);
        
        JRadioButton copy = new JRadioButton("Copy");
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(symlinks);
        group.add(copy);
        
        
        panel_2.add(symlinks);
        panel_2.add(copy);
        
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        
        JButton btnInstall = new JButton("Install");
        btnInstall.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                InstallerFrame.this.onInstall();
                
            }
        });
        panel.add(btnInstall);
        
       
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                InstallerFrame.this.setVisible(false);
            }
        });
        panel.add(btnCancel);
    }

//    /**
//     * 
//     * @param fontsDir File
//     */
//    private void linkFonts (File fontsDir)
//    {
//        File fromDir = new File("war" + File.separator + "fonts");
//        
//        File[] fontFiles = fromDir.listFiles();
//        
//        for (int i = 0; i < fontFiles.length; ++i)
//        {
//            File fontToLink = fontFiles[i];
//            
//            this.linkFile(fontToLink, fontsDir);
//        } 
//    }

}

