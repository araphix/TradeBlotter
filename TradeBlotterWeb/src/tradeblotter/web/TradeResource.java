package tradeblotter.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import tradeBlotter.ejb.LoginRemote;
import tradeBlotter.ejb.TradeBlotterRemote;
import tradeBlotter.jpa.*;

@Path("/user")
public class TradeResource {
	


		private TradeBlotterRemote bean; 
		private LoginRemote beanLogin;
		private static boolean loginConfirmation = true;
		public TradeResource() {
	        try {
	        	InitialContext context = new InitialContext();
	            bean = (TradeBlotterRemote) context.lookup("java:app/TradeBlotterEJB/TradeBlotter!tradeBlotter.ejb.TradeBlotterRemote");
	        // JNDI LOOK UP
	            beanLogin = (LoginRemote) context.lookup("java:app/TradeBlotterEJB/Login!tradeBlotter.ejb.LoginRemote");
	        }
			catch (NamingException ex) {}
		}
		
		@GET
		@Produces("application/json")
		public List<TradeInfo> displayTradeInfo(@QueryParam("traderID") String userID) {
			
			if (bean == null) {
				return null;
				}
			
			else if((beanLogin.getConfirmation(userID)).equals("1")) {
				return bean.displayTradeInformation();
			}
			else{
				TradeInfo tInfo = new TradeInfo();
				tInfo.setStatus("User not logged in!");
				List<TradeInfo> listTradeInfo = new ArrayList<TradeInfo>();
				listTradeInfo.add(tInfo);
				return listTradeInfo;
			}
		}
		
		@POST
	    @Consumes("application/x-www-form-urlencoded") 
	    @Produces("text/plain")
		@Path("/login")
	    public String addPlayer(@FormParam("userID")String userID,
	                            @FormParam("password") String password) {

			boolean login = beanLogin.userLogin(userID,password);
			
			if(login==true){
				beanLogin.setConfirmation("1", userID);
				//loginConfirmation = true;
	        return "1";
	    } else{
	    	return "0";
	    }
		}

//		@GET
//		@Produces("application/json")
//	    @Path("/{categoryName}")
//		public List<Product> getProductsInCategory(@PathParam("categoryName")String categoryName) {
//
//			if (bean == null) 
//				return null;
//			
//			return bean.getProductsInCategory(categoryName);	
//		}
//	}
////
}
