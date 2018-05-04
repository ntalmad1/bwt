package com.talmadge.bwt.installer.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.talmadge.bwt.installer.lib.resource.Resource;
import com.talmadge.bwt.installer.lib.resource.local.CssResource;
import com.talmadge.bwt.installer.lib.resource.local.DirResource;
import com.talmadge.bwt.installer.lib.resource.local.JsResource;
import com.talmadge.bwt.installer.lib.resource.remote.RemoteCssResource;
import com.talmadge.bwt.installer.lib.resource.remote.RemoteJsResource;

/**
 * 
 *
 */
public class InstallHandler
{
	/**
	 */
	public enum Mode {
	
		/**
		 */
		COPY,
		
		/**
		 */
		LINK;
	}


	/**
	 */
	private List<String> cssIncludeLines;
	
	/**
	 */
	private List<String> jsIncludeLines;
	
	/**
	 */
	private File installToDir;
	
	/**
	 */
	private Mode mode;
	
	/**
	 */
	private ResourceDictionary resources;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param installToDir File
	 * @param mode Mode
	 */
	public InstallHandler (File installToDir, Mode mode)
	{
		this.installToDir = installToDir;
		this.mode = mode;
		
		this.cssIncludeLines = new ArrayList<String>();
		this.jsIncludeLines = new ArrayList<String>();
		
		this.resources = new ResourceDictionary();
		
		//-- Copy Directories --//
		// bwt fonts
		this.resources.add(new DirResource("/fonts/", "/bwt/fonts/"));
		
		// datatables
		this.resources.add(new DirResource("/datatables/", "/bwt/datatables/"));
		
		// jquery-ui
		this.resources.add(new DirResource("/jquery-ui/", "/bwt/jquery-ui/"));
		
		// thems - tooltips
		this.resources.add(new DirResource("/css/themes/tooltips/", "/bwt/css/themes/tooltips/"));
		
		
		//-- CSS --//
		// css - core
		this.resources.add(new CssResource("/css/", "/bwt/css/", 
				"bootstrap.min.css",
				"bootstrap-datetimepicker.min.css"
		));	
		
		// css - bootstrap theme
		this.resources.add(new CssResource("/css/themes/", "/bwt/css/themes/", "bootstrap-theme.min.css"));	
		
		// css - tooltips
		this.resources.add(new CssResource("/css/", "/bwt/css/", "tooltipster.bundle.min.css"));	
		
		// css - loading mask
		this.resources.add(new CssResource("/css/", "/bwt/css/", "loading.css"));
		
		// css - tooltips themes
		this.resources.addIncludeOnly(new CssResource("/css/themes/tooltips/", "/bwt/css/themes/tooltips/", "tooltips-theme.css"));
		
		// css - datatables
		this.resources.addIncludeOnly(new CssResource("/datatables/", "/bwt/datatables/", "datatables.min.css"));
		
		// css - jquery-ui
		this.resources.addIncludeOnly(new CssResource("/jquery-ui/", "/bwt/jquery-ui/", "jquery-ui.min.css"));
		
		// css - core
		this.resources.add(new CssResource("/css/", "/bwt/css/", "bwt.css")); 
		
		
		//-- JS --//
		// jquery
		this.resources.add(
			new RemoteJsResource("https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js")
		); 
		
		// js - core
		this.resources.add(new JsResource("/js/", "/bwt/js/",
				"bootstrap.min.js",
				"moment.js",
				"bootstrap-datetimepicker.min.js",
			    "bootstrap-hover-dropdown.min.js",
			    "handlebars.js",
			    "jquery.scrollTo.min.js",			    
			    "tooltipster.bundle.min.js",
			    "loading.js",
			    "bootbox.min.js"
		));
		
		// js - plugins - tooltips - follower
		this.resources.add(new JsResource("/js/plugins/tooltipster/", "/bwt/js/plugins/tooltipster/", "follower.min.js"));
				
		// js - datatables
		this.resources.addIncludeOnly(new JsResource("/datatables/", "/bwt/datatables/", "datatables.min.js"));
		
		// js - jquery-ui
		this.resources.addIncludeOnly(new JsResource("/jquery-ui/", "/bwt/jquery-ui/", "jquery-ui.min.js"));
		
		// js - bwt
		this.resources.add(new JsResource("/js/", "/bwt/js/", "bwt.js"));
	}
	
	
	
	
//  /**
//   */
//  private final String[] themeFiles = new String[]{
//           "bootstrap-theme.min.css"
//  };
//  
	
	/**
	 * 
	 * @return List<String>
	 */
	public List<String> getCssIncludeLines ()
	{
		return this.cssIncludeLines;
	}
	
	
	
	/**
	 * 
	 * @return List<String>
	 */
	public List<String> getJsIncludeLines ()
	{
		return this.jsIncludeLines;
	}
	
	
	/**
	 * 
	 * @return File
	 */
	public File getInstallToDir ()
	{
		return this.installToDir;
	}
	
	
	/**
	 * 
	 * @return Mode
	 */
	public Mode getMode ()
	{
		return this.mode;
	}
	
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void install () throws IOException
	{
		 List<Resource> resources = this.resources.getResources();
         
         for (Resource resource : resources)
         {
         	switch (resource.getType()) {
         		case CSS:
         			this.processCssResource((CssResource) resource);
         			break;
         		case DIR:
         			this.processDirResource((DirResource) resource);
         			break;
         		case JS:
         			this.processJsResource((JsResource) resource);
         			break;
         		case REMOTE_CSS:
         			this.processRemoteCssResource((RemoteCssResource) resource);
         			break;
         		case REMOTE_JS:
         			this.processRemoteJsResource((RemoteJsResource) resource);
         			break;
         		default:
         			break;
         	}
         }

//         
//         this.linkFile(new File("war" + File.separator + "datatables"), datatablesDir);
//         this.linkFile(new File("war" + File.separator + "jquery-ui"), jqueryUiDir);
//         this.linkFiles(bootstrapCssFiles, new File("war" + File.separator + "css"), cssDir);
//         this.linkFiles(bwtCssFiles, new File("war" + File.separator + "css"), cssDir);
//         this.linkFiles(bootstrapJsFiles,  new File("war" + File.separator + "js"), jsDir);
//         this.linkFiles(bwtJsFiles,  new File("war" + File.separator + "js"), jsDir);
//         this.linkFiles(themeFiles,  new File("war" + File.separator + "css" + File.separator + "themes"), themesDir);
//         
//         
           
//         
//         List<String> lines = new ArrayList<String>();
//         
//         this.createCssIncludes(lines, bootstrapCssFiles, "bwt/css/");
//         this.createCssIncludes(lines, themeFiles, "bwt/css/themes/");
//         lines.add("<link href=\"bwt/jquery-ui/jquery-ui.min.css\" rel=\"stylesheet\">");  
//         lines.add("<link href=\"bwt/bwtgallery/jquery.bwtgallery.css\" rel=\"stylesheet\">");  
//         this.createCssIncludes(lines, bwtCssFiles, "bwt/css/");
//         
//         
//         this.createJsIncludes(lines, bootstrapJsFiles, "bwt/js/");
//         lines.add("<script src=\"bwt/jquery-ui/jquery-ui.min.js\"></script>");
//         this.createJsIncludes(lines, bwtJsFiles, "bwt/js/");
//         

           
           File bwtIncludesFile = new File(this.getInstallToDir() + File.separator + "bwtIncludes.html");
           
           List<String> includeLines = new ArrayList<String>();
           
           includeLines.addAll(this.getCssIncludeLines());
           includeLines.add("");
           includeLines.addAll(this.getJsIncludeLines());
           
           Files.write(Paths.get(bwtIncludesFile.getAbsolutePath()), includeLines, Charset.forName("UTF-8"));
	}


	/**
	 * 
	 * @param srcDir File
	 * @param destDir File
	 * @param mode Mode
	 * @throws IOException 
	 */
	private void copyAll (File srcDir, File destDir) throws IOException
	{
		if (!destDir.exists())
		{
			destDir.mkdirs();
		}
		
		File[] srcFiles = srcDir.listFiles();
		
		for (int i = 0; i < srcFiles.length; ++i)
		{
			File srcFile = srcFiles[i];
			
			if (srcFile.isFile())
			{
				this.copyFile(srcFile, new File(destDir.getAbsolutePath() + File.separator + srcFile.getName()));
			}
			else
			{
				this.copyAll(srcFile, new File(destDir.getAbsolutePath() + File.separator + srcFile.getName()));
			}
		}
		
	}


	/**
	 * 
	 * @param srcFile File
	 * @param destFile File
	 * @throws IOException 
	 */
	private void copyFile (File srcFile, File destFile) throws IOException
	{
		 String command = null;
		 
		 switch (mode)
		 {
			case LINK:
				command = "cmd /c mklink \"" + destFile.getAbsolutePath() + "\" \"" + srcFile.getAbsolutePath() + "\"";
				break;
			
			case COPY:
				command = "cmd /c copy \"" + srcFile.getAbsolutePath() + "\" \"" + destFile.getAbsolutePath() + "\"";
				break;
				
			default:
				break;
		 }
		 
		    
	     Process process = Runtime.getRuntime().exec(command);
	
	     // Get input streams
	     BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
	     BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	
	     // Read command standard output
	     String s;
	     while ((s = stdInput.readLine()) != null)
	     {
	         System.out.println(s);
	     }
	
	     // Read command errors
	     while ((s = stdError.readLine()) != null)
	     {
	     	System.err.println("Error running command: " + command);
	        System.err.println(s);
	     }
	}


	/**
	 * 
	 * @param names List<String>
	 * @param targetDir String
	 */
	private void createCssIncludes (List<String> names, String targetDir)
	{
		if (targetDir.startsWith("/"))
		{
			targetDir = targetDir.substring(1);
		}
		
		targetDir = "<?= $appUrl; ?>" + targetDir; 
		
	    for (String name : names)
	    {
	        this.cssIncludeLines.add("<link href=\"" + targetDir + name + "\" rel=\"stylesheet\">");
	    }
	}


	/**
	 * 
	 * @param names List<String>
	 * @param targetDir String
	 */
	private void createJsIncludes (List<String> names, String targetDir)
	{
		if (targetDir.startsWith("/"))
		{
			targetDir = targetDir.substring(1);
		}
		
		targetDir = "<?= $appUrl; ?>" + targetDir; 
		
	    for (String name : names)
	    {
	        this.jsIncludeLines.add("<script src=\"" + targetDir + name + "\"></script>");
	    }
	}

	
	/**
	 * 
	 * @param resource CssResource
	 * @throws IOException 
	 */
	private void processCssResource (CssResource resource) throws IOException
	{
		if (!resource.isIncludeOnly())
		{
			File srcDir = new File("war" + resource.getSrc());
			File destDir = new File(installToDir.getAbsolutePath() + resource.getDest());
			
			if (!destDir.exists())
			{
				destDir.mkdirs();
			}
			
			for (String name : resource.getNames())
			{
				File srcFile = new File(srcDir.getAbsolutePath() + File.separator + name);
				File destFile = new File(destDir.getAbsolutePath() + File.separator + name);
				
				this.copyFile(srcFile, destFile);
			}
		}
		
		this.createCssIncludes(resource.getNames(), resource.getDest());
	}
	
	
	/**
	 * 
	 * @param resource CssResource
	 * @throws IOException 
	 */
	private void processJsResource (JsResource resource) throws IOException
	{
		if (!resource.isIncludeOnly())
		{
			File srcDir = new File("war" + resource.getSrc());
			File destDir = new File(installToDir.getAbsolutePath() + resource.getDest());
			
			if (!destDir.exists())
			{
				destDir.mkdirs();
			}
			
			for (String name : resource.getNames())
			{
				File srcFile = new File(srcDir.getAbsolutePath() + File.separator + name);
				File destFile = new File(destDir.getAbsolutePath() + File.separator + name);
				
				this.copyFile(srcFile, destFile);
			}
		}
		
		this.createJsIncludes(resource.getNames(), resource.getDest());
	}
	
	
	/**
	 * 
	 * @param resource RemoteJsResource
	 */
	private void processRemoteCssResource (RemoteCssResource resource)
	{
		this.jsIncludeLines.add("<link href=\"" + resource.getSrc() + " rel=\"stylesheet\">");
	}
	

	/**
	 * 
	 * @param resource RemoteJsResource
	 */
	private void processRemoteJsResource (RemoteJsResource resource)
	{
		this.jsIncludeLines.add("<script src=\"" + resource.getSrc() + "\"></script>");
	}


	/**
	 * 
	 * @param resource DirResource
	 * @param installToDir File
	 * @throws IOException 
	 */
	private void processDirResource (DirResource resource) throws IOException
	{
		File src = new File("war" + resource.getSrc());
		File dest = new File(installToDir.getAbsolutePath() + resource.getDest());
		
		this.copyAll(src, dest);
	}
}
