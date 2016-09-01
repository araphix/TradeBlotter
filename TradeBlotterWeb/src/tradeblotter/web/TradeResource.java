package tradeblotter.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import tradeBlotter.ejb.UserInfoRemote;
import tradeBlotter.jpa.*;

@Path("/user")
public class TradeResource {
	


		private TradeBlotterRemote bean; 
		private LoginRemote beanLogin;
		private static boolean loginConfirmation = true;
		
		private UserInfoRemote beanUserInfo;


		public TradeResource() {
	        try {
	        	InitialContext context = new InitialContext();
	            bean = (TradeBlotterRemote) context.lookup("java:app/TradeBlotterEJB/TradeBlotter!tradeBlotter.ejb.TradeBlotterRemote");
	        // JNDI LOOK UP
	            beanLogin = (LoginRemote) context.lookup("java:app/TradeBlotterEJB/Login!tradeBlotter.ejb.LoginRemote");
	            beanUserInfo = (UserInfoRemote) context.lookup("java:app/TradeBlotterEJB/UserInfo!tradeBlotter.ejb.UserInfoRemote");
	    		
	        
	        }
			catch (NamingException ex) {}
		}
		
		
		//
		//The function below displays the trade information only if the trader is logged in
		// path is /rest/user?traderID=
		//
		
		
		@GET
		@Produces("application/json")
		public List<TradeInfo> displayTradeInfo(@QueryParam("traderID") String userID) {
			
			if (bean == null) {
				return null;
				}
			
			else if((beanLogin.getConfirmation(userID)).equals("1")) {
				return bean.displayTradeInformation(userID);
			}
			else{
				TradeInfo tInfo = new TradeInfo();
				tInfo.setStatus("User not logged in!");
				List<TradeInfo> listTradeInfo = new ArrayList<TradeInfo>();
				listTradeInfo.add(tInfo);
				return listTradeInfo;
			}
		}
		
		
		/*
		 * 
		 * ----------------------------------------
		 * The function below logs out the logged in trader
		 * THe post method takes traerID as the form parameter.
		 * Returns 1 for a successful logout.
		 * Returns 0 for unsuccessful logout.
		 * 
		 * 
		 */
		
		@POST
		@Produces("application/json")
		@Path("/logout")
		public String logout(@FormParam("traderID") String userID) {
			
			if (bean == null) {
				return null;
				}
			
			else if((beanLogin.getConfirmation(userID)).equals("1")) {
				beanLogin.setConfirmation("0", userID);
				return "1";
				
				
				
			}
			else{
				
				return "0";
			}
		}
		
		
		/*
		 * 
		 * ------------------------------------------
		 * The function below makes changes in the database for the logged in trader. Just to keep track
		 * of the logged in traders.
		 * 
		 * Form parameters are userID and password
		 * 
		 * 
		 */
		
		
		
		@POST
	    @Consumes("application/x-www-form-urlencoded") 
	    @Produces("text/plain")
		@Path("/login")
	    public String login(@FormParam("userID")String userID,
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
		
		
		/*
		 * ------------------------------------------------------------------------ 
		 * 
		 * 		The function below get the trader information for the logged in trader.
		 * 		Trader's name and trader's ID
		 * 
		 * 			/rest/user/userInfo?userID=
		 * 
		 */
		
		@GET
		@Produces("application/json")
	    @Path("/userInfo")
		public HashMap<String,String> getUserDetails(@QueryParam("userID")String userID) {

			if (beanLogin == null) 
				return null;
			else {
				return beanLogin.getUserInfo(userID);
			}				
		}


}
