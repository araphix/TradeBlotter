package tradeblotter.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import chat.personal.ChatPersonalRemote;
import tradeBlotter.ejb.LoginRemote;
import tradeBlotter.jpa.GroupChat;
import tradeBlotter.jpa.PersonalChat;
import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

@Path("/chat")
public class ChatResource {

	private ChatGroupRemote bean;
	private LoginRemote beanLogin;
	private static boolean loginConfirmation = true;

	private ChatPersonalRemote beanPersonal;

	public ChatResource() {
		try {
			InitialContext context = new InitialContext();
			bean = (ChatGroupRemote) context.lookup("java:app/TradeBlotterEJB/ChatGroup!chat.group.ChatGroupRemote");
			beanLogin = (LoginRemote) context.lookup("java:app/TradeBlotterEJB/Login!tradeBlotter.ejb.LoginRemote");
			beanPersonal = (ChatPersonalRemote) context
					.lookup("java:app/TradeBlotterEJB/ChatPersonal!chat.personal.ChatPersonalRemote");

		} catch (NamingException ex) {
		}
	}

	/*
	 * --------------------------- Displays the message history for the trader's
	 * group
	 * 
	 */

	@GET
	@Produces("application/json")
	public List<GroupChat> displayChats(@QueryParam("traderID") String userID) {
		if ((beanLogin.getConfirmation(userID)).equals("1")) {
			return bean.getMessages(userID);
		} else {
			return null;
		}
	}

	//
	// The function below returns the list of online users belonging to a
	// particular department
	//

	@GET
	@Produces("application/json")
	@Path("/onlineUsers")
	public List<HashMap<String, String>> getOnlineUsers(@QueryParam("traderID") String userID) {

		if ((beanLogin.getConfirmation(userID)).equals("1")) {
			return bean.getOnlineUsers(userID);
		} else {
			return null;
		}

	}
	
	/*
	 * ------------------------------------------
	 * This function sends the message to the group from the trader's id
	 * 
	 * form parameters are userID and message
	 */

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	public void sendMessage(@FormParam("userID") String userID, @FormParam("message") String message) {

		bean.postMessage(userID, message);
	}

	// GET AND POST REQUESTS FOR PERSONAL CHAT
	
	@GET
	@Produces("application/json")
	@Path("/personal")
	public List<PersonalChat> displayPersonalChats(@QueryParam("userID") String userID,
			@QueryParam("receiverID") String receiverID) {
		if ((beanLogin.getConfirmation(userID)).equals("1")) {
			return beanPersonal.getMessages(userID, receiverID);
		} else {
			return null;
		}
	}

	/*
	 * 
	 *  -------------------------
	 *  This function sends personal message to a specified traderID
	 *  
	 *  Form parameters are userID, message, receiverID
	 * 
	 */
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	@Path("/postPersonal")
	public String sendPersonalMessage(@FormParam("userID") String userID, @FormParam("message") String message,
			@FormParam("receiverID") String receiverID) {

		beanPersonal.postMessage(userID, message, receiverID);
		return "Message entered";
	}
	
	
	/*
	 * --------------------------------
	 * This function displays all the personal messages sent to the logged in trader 
	 * 
	 * form parameters 
	 * 
	 */
	
	

	@GET
	@Produces("application/json")
	@Path("/myMessages")
	public List<HashMap<String, String>> displayMyMessages(@QueryParam("userID") String userID) {
		if ((beanLogin.getConfirmation(userID)).equals("1")) {
			return beanPersonal.getMyMessages(userID);
		} else {
			return null;
		}
	}

	
}
