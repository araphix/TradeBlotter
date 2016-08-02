package chat.personal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tradeBlotter.jpa.PersonalChat;
import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class ChatPersonal
 */
@Stateful
@Local(ChatPersonalLocal.class)
@Remote(ChatPersonalRemote.class)
public class ChatPersonal implements ChatPersonalRemote, ChatPersonalLocal {

	@Resource
	private SessionContext sessionContext;
	
	@PersistenceContext(name="TradeBlotterJPA-PU")
	public EntityManager em; 
	
	
	
	/*
	 * (non-Javadoc)
	 * @see chat.personal.ChatPersonalRemote#getMessages(java.lang.String, java.lang.String)
	 * 
	 * 
	 * 
	 * This functions gets the messages sent to th trader by a specific userID
	 */
	
	
    public List<PersonalChat> getMessages(String userID, String receiverID) {
    	
    	System.out.println("\n\n---------------------\n\n"+userID+"\n\n-----------------\n\n");
    	TypedQuery<PersonalChat> query = em.createQuery("SELECT p FROM PersonalChat AS p WHERE (p.userID ='"+userID+"' or p.userID ='"+receiverID+"') and (p.receiverID ='"+receiverID+"' or p.receiverID ='"+userID+"')" , PersonalChat.class);
        // Execute the query, and get a collection of entities back.
    	
        List<PersonalChat> chats = query.getResultList();
        return chats;
    }
    
    
    /*
     * (non-Javadoc)
     * @see chat.personal.ChatPersonalRemote#postMessage(java.lang.String, java.lang.String, java.lang.String)
     * 
     * 
     * THis function sends a specific message from the logged in trader to the specified other trader
     * 
     */
    
    public void postMessage(String userID ,String message, String receiverID){
    	PersonalChat PersonalChat = new PersonalChat();
    	
    	TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		
		TypedQuery<User> receiverQuery = em.createQuery("SELECT p FROM User AS p Where p.userID = :receiverIDParam", User.class);
		receiverQuery.setParameter("receiverIDParam", receiverID);
		// Execute the query, and get a collection of entities back.
		List<User> receiverData = receiverQuery.getResultList();
		
		User LoginUser = userData.get(0);
		User ReceiverUser = receiverData.get(0);
		String userName = LoginUser.getUserName();
		String receiverName = ReceiverUser.getUserName();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String timestamp = time.toString();
		
		TypedQuery<PersonalChat> messageIdQuery = em.createQuery("SELECT p FROM PersonalChat AS p ORDER BY p.messageID DESC", PersonalChat.class);
		// Execute the query, and get a collection of entities back.
	    List<PersonalChat> messageData = messageIdQuery.getResultList();
	    int counter = 0;
	    int prevMessageId = 0;
		
		//To position the cursor to the resultset starting columns.
		for(PersonalChat t : messageData){
			if(counter==0){	
			prevMessageId = t.getMessageID();
			counter=1;
			}
		}
	    
//		int messageId = "" + (Integer.parseInt(prevMessageId)+1);
	    
		PersonalChat.setMessageID(prevMessageId + 1);
		PersonalChat.setUserID(userID);
		PersonalChat.setReceiverID(receiverID);
    	PersonalChat.setTimeStamp(timestamp);
    	PersonalChat.setMessage(message);
    	PersonalChat.setSender(userName);
    	PersonalChat.setReceiver(receiverName);
    	em.persist(PersonalChat);	
    	
    }
    
    
    
    /*
     * 
     * (non-Javadoc)
     * @see chat.personal.ChatPersonalRemote#getMyMessages(java.lang.String)
     * 
     * 
     * This function returns the list of all the traders who have sent messages to the logged in trader
     * 
     * 
     */
    
    public List<HashMap<String, String>> getMyMessages(String userID) {
    
    	System.out.println("\n\n---------------------\n\n"+userID+"\n\n-----------------\n\n");
    	TypedQuery<PersonalChat> query = em.createQuery("SELECT p FROM PersonalChat AS p Where p.receiverID = :userIDParam", PersonalChat.class);
		query.setParameter("userIDParam", userID);
		HashMap<String, String> senderInfo = new HashMap<String,String>();
		List<HashMap<String,String>> hashList = new ArrayList<HashMap<String,String>>();
        // Execute the query, and get a collection of entities back.
    	
		String prev = "temp";
		String curr = null;
		
        List<PersonalChat> senderDetails = query.getResultList();
        for (PersonalChat info : senderDetails) {
        	senderInfo = new HashMap<String,String>();
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	String senderName = info.getSender();
        	System.out.println(senderName);
            String senderID  = info.getUserID();
            System.out.println(senderID);
            
            curr = senderID;
            
            if(prev.equals(curr)){
            	
            }
            
            else{
            
            senderInfo.put("senderName", senderName);
            senderInfo.put("senderID", senderID);
            System.out.println(senderInfo);
            hashList.add(senderInfo);
            prev = curr;
            }
        }
        
        
        for(HashMap<String,String> h : hashList){
        	System.out.println(h);
        }
        
        
        return hashList;
    } 
    public ChatPersonal() {
        // TODO Auto-generated constructor stub
    }
}