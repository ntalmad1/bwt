package com.talmadge.bwt.demo.client.modules.sandbox;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.container.dialog.BwtDialog;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;

/**
 * 
 *
 */
public class SandboxView extends BwtView
{
	
	/**
	 * Constructor
	 * 
	 * @param presenter SandboxPresenter
	 */
	public SandboxView (SandboxController controller)
	{
		super(controller);
		
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void init ()
	{
				
	}


	/**
	 * 
	 */
	@Override
	public void go ()
	{
		final BwtDialog dialog = new BwtDialog();
		dialog.setIcon(Glyphicon.COG); 
		dialog.setDialogStyle(BwtStyle.DialogStyle.PRIMARY);
		dialog.setTitle("Hello World!");
		//dialog.getCloseButton().setText("Close");
		
		
		Button button = new Button("Show Dialog");
		
		button.addSelectHandler(new SelectHandler<Button>()
		{
			public void onSelect (SelectEvent<Button> event)
			{
				dialog.show();				
			}
		});
		
		
		this.add(button);
		
		
//		
//		dialog.addShowHandler(new ShowHandler<BwtDialog>()
//		{
//			public void onShow (ShowEvent<BwtDialog> event) {
//				Window.alert("Show");
//			}
//		});
//		
//		
//		dialog.addAfterShowHandler(new AfterShowHandler<BwtDialog>()
//		{
//			public void onAfterShow (AfterShowEvent<BwtDialog> event) {
//				Window.alert("AfterShow");
//			}
//		});
//		
//		
//		dialog.addHideHandler(new HideHandler<BwtDialog>()
//		{
//			public void onHide (HideEvent<BwtDialog> event) {
//				Window.alert("Hide");
//			}
//		});
//		
//		
//		dialog.addAfterHideHandler(new AfterHideHandler<BwtDialog>()
//		{
//			public void onAfterHide (AfterHideEvent<BwtDialog> event) {
//				Window.alert("AfterHide");
//			}
//		});
		
		//BwtGalleryViewer gallery = new BwtGalleryViewer();
		//
		//BwtGalleryItem item1 = new BwtGalleryItem(
//		       Demo.getAppUrl() + "images/gallery/1.jpg"
//		     , Demo.getAppUrl() + "images/gallery/thumbs/t1.jpg"
		//);
		//
		//BwtGalleryItem item2 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/2.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t2.jpg"
		//);
		//
		//BwtGalleryItem item3 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/3.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t3.jpg"
		//);
		//
		//BwtGalleryItem item4 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/4.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t4.jpg"
		//);
		//
		//BwtGalleryItem item5 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/5.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t5.jpg"
		//);
		//
		//BwtGalleryItem item6 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/6.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t6.jpg"
		//);
		//
		//
		//BwtGalleryItem item7 = new BwtGalleryItem(
//		      Demo.getAppUrl() + "images/gallery/7.jpg"
//		    , Demo.getAppUrl() + "images/gallery/thumbs/t7.jpg"
		//);
		//
		//
		//gallery.add(item1);
		//gallery.add(item2);
		//gallery.add(item3);
		//gallery.add(item4);
		//gallery.add(item5);
		//gallery.add(item6);
		//gallery.add(item7);
		//
		////carousel.add(Demo.getAppUrl() + "images/carousel/exp01.jpg");
		////carousel.add(Demo.getAppUrl() + "images/carousel/exp02.jpg");
		////carousel.add(Demo.getAppUrl() + "images/carousel/exp03.jpg");
		////carousel.add(Demo.getAppUrl() + "images/carousel/exp04.jpg");
		////carousel.add(Demo.getAppUrl() + "images/carousel/exp05.jpg");
		//
		////carousel.setWidth(640);
		//
		//RootPanel.get().add(gallery);
		
	}

}


