package tradeblotter.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import chat.group.*;
import tradeBlotter.ejb.LoginRemote;
import tradeBlotter.jpa.GroupChat;
import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

@Path("/chat")
public class ChatResource {
	


		private ChatGroupRemote bean;
		private LoginRemote beanLogin;
		private static boolean loginConfirmation = true;
		public ChatResource() {
	        try {
	        	InitialContext context = new InitialContext();
	            bean = (ChatGroupRemote) context.lookup("java:app/TradeBlotterEJB/ChatGroup!chat.group.ChatGroupRemote");
	            beanLogin = (LoginRemote) context.lookup("java:app/TradeBlotterEJB/Login!tradeBlotter.ejb.LoginRemote");
		         }
			catch (NamingException ex) {}
		}
		
		@GET
		@Produces("application/json")
		public List<GroupChat> displayChats(@QueryParam("traderID") String userID) {
			if((beanLogin.getConfirmation(userID)).equals("1")){
			return bean.getMessages(userID);
			}
			else{
				return null;
			}
		}
		
		
		
		
		//
		//The function below reurns the lsit of online users belonging to a particular department
		//
		
		@GET
		@Produces("application/json")
		@Path("/onlineUsers")
		public HashMap<String,String> displayOnlineUsers(@QueryParam("traderID") String userID){
			
			if((beanLogin.getConfirmation(userID)).equals("1")){
				return bean.getOnlineUsers(userID);
			}
			else{
				return null;
			}
			
			
		}
		
		
		
		
		@POST
	    @Consumes("application/x-www-form-urlencoded") 
	    @Produces("text/plain")
	    public void sendMessage(@FormParam("userID")String userID,
	                            @FormParam("message") String message) {

			bean.postMessage(userID, message);
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
