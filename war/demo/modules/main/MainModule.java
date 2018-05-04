package com.talmadge.bwt.demo.client.modules.main;

import com.talmadge.bwt.core.client.app.endpoint.Endpoint;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.endpoint.module.BwtModule;
import com.talmadge.bwt.core.client.app.router.Router.MatchMethod;

/**
 * 
 *
 */
public class MainModule extends BwtModule
{
	/**
	 * 
	 */
	@Override
	protected void setup ()
	{
		this.addRoute(MatchMethod.BEGINS_WITH, "/", new EndpointProvider(){
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.main.MainController();
			}			
		});
		
		
		this.getRouter().addSubRoute("/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.about.AboutController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/index.html", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.about.AboutController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/components/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.components.ComponentsController();
			}
		}, "mainContentContainer");		
		
		this.getRouter().addSubRoute("/layouts/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.layouts.LayoutsController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/tables/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.tables.TablesController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/forms/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.forms.FormsController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/templates/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.templates.TemplatesController();
			}
		}, "mainContentContainer");
				
		this.getRouter().addSubRoute("/tooltips/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.TooltipsController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/interactions/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.interactions.InteractionsController();
			}
		}, "mainContentContainer");
		
		this.getRouter().addSubRoute("/effects/", new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.modules.main.controllers.effects.EffectsController();
			}
		}, "mainContentContainer");
	}
}
