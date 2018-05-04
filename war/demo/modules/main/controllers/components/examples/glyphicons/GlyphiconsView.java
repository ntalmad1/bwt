package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.glyphicons;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.HTML;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;
import com.talmadge.bwt.core.client.ui.widget.tile.Tile;
import com.talmadge.bwt.core.client.ui.widget.tile.group.TileGroup;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroupView;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.glyphicons.resources.GlyphiconsResources;


/**
 * 
 * @author Noah
 *
 */
public class GlyphiconsView extends BwtExampleGroupView
{
	/**
	 * Constructor 
	 *
	 * @param presenter GlyphiconsPresenter
	 */
	public GlyphiconsView (GlyphiconsExamples component)
	{
		super(component, "Glyphicons");
		
		this.add(new HTML(GlyphiconsResources.INSTANCE.blurb().getText()), new Margins(0, 0, 15, 0));
		
		TileGroup tileGroup = new TileGroup();        
		Glyphicon[] glyphs = Glyphicon.values();
        for (int i = 0; i < glyphs.length; ++i)
        {
        	Tile tile = new Tile(glyphs[i], glyphs[i].toString().replace("_", " "));
        	tileGroup.add(tile);
        }
        
        BwtFlowPanel panel = new BwtFlowPanel();
        panel.add(tileGroup);
        panel.setHeight(900);
        panel.getElement().getStyle().setOverflowY(Overflow.SCROLL);
       
        
        this.add(panel); 
	}

}
