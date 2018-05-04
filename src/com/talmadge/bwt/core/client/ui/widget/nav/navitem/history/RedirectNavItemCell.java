package com.talmadge.bwt.core.client.ui.widget.nav.navitem.history;

import com.talmadge.bwt.core.client.history.BwtHistory;

/**
 *
 */
public class RedirectNavItemCell extends HistoryNavItemCell
{
    /**
     * 
     */
	protected void onSelect ()
	{
		BwtHistory.getInstance().redirect(RedirectNavItemCell.this.getHistoryToken());   
	}
}
