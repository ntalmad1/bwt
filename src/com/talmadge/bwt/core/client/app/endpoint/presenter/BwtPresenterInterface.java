package com.talmadge.bwt.core.client.app.endpoint.presenter;

import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.Endpoint;

/**

 *
 */
public interface BwtPresenterInterface extends Endpoint
{
	/**
	 * 
	 * @return BwtApplication
	 */
	BwtApplication getApp ();
}
