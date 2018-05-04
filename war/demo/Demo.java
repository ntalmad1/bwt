package com.talmadge.bwt.demo.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.Endpoint;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.router.Router.MatchMethod;
import com.talmadge.bwt.core.client.ui.Bwt;

/**
 * 
 *
 */
public class Demo extends BwtApplication
{
	@Override
	protected void setup () throws Exception
	{
		Bwt.setDebugMode(true);
		
		this.getRouter().setTarget(RootPanel.get());
		
//		this.getRouter().add("/foo/", new EndpointProvider(){
//			public Endpoint getEndpoint ()	{
//				return new com.talmadge.helloworld.client.FooController();
//			}			
//		});
				
		this.addRoute(MatchMethod.BEGINS_WITH, "/", new EndpointProvider(){
			public Endpoint getEndpoint ()	{
				return new com.talmadge.bwt.demo.client.modules.main.MainModule();
			}			
		});
		
		
		this.set404EndpointProvider(new EndpointProvider() {
			public Endpoint getEndpoint () {
				return new com.talmadge.bwt.demo.client.controllers.notfound.NotFoundController();
			}
		});
		
//   	 Router router = this.getRouter();
//     
//     router.setDefaultControllerProvider(new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.notfound.NotFoundController();
//         }
//     });
//     
//     
//     router.add("/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.main.MainController();
//         }
//     });
//     
//     
//     router.add("/components/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.components.ComponentsController();
//         }
//     });
//     
//     router.add("/layouts/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.layouts.LayoutsController();
//         }
//     });
//     
//     
//     router.add("/tables/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.tables.TablesController();
//         }
//     });
//     
//     
//     router.add("/demo/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.components.ComponentsController();
//         }
//     });
//     
//     
//     router.add("/effects/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.effects.EffectsController();
//         }
//     });
//     
//     
//     router.add("/forms/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.forms.FormsController();
//         }
//     });
//     
//     router.add("/interactions/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.interactions.InteractionsController();
//         }
//     });
//     
//     router.add("/test/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//             return new com.talmadge.bwt.demo.client.controllers.test.TestController();
//         }
//     });
//     
//     router.add("/templates/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//         	           
//             return new com.talmadge.bwt.demo.client.controllers.templates.TemplatesController(); 
//         }
//     });
//     
//     router.add("/tooltips/", new ControllerProvider()
//     {
//         public ControllerInterface getController ()
//         {
//            return new com.talmadge.bwt.demo.client.controllers.tooltips.TooltipsController(); 
//         }
//     });
		
	}


	/**
	     *
	     */
	    protected void doSandbox ()
	    {
	//        JSONArray dataSet = JSONParser.parseStrict("[[\"Foo\", \"Bar\"]]").isArray();
	//        
	//        LayoutColumn column = new LayoutColumn();
	//
	//        BwtSimpleTable table = new BwtSimpleTable();
	//        table.addColumnConfig(new SimpleColumnConfig("Test Col1"));
	//      
	//        SimpleColumnConfig col2 = new SimpleColumnConfig("Test Col2");
	//        col2.setRenderer(new ColumnRenderer<JavaScriptObject>()
	//        {
	//            public String render (String data, String type, JavaScriptObject row)
	//            {
	//                return data + " is now car";
	//            }
	//            
	//        });
	//        
	//        table.addColumnConfig(col2);
	//        
	//        table.setData(dataSet);
	//        
	//        column.add(table);
	//
	//        LayoutRow row = new LayoutRow();
	//        row.add(column, new ColumnSize(Size.MD, 12));
	//
	//        LayoutContainer container = new LayoutContainer();
	//        container.add(row);
	//
	//        RootPanel.get().add(container);
	    }
}
