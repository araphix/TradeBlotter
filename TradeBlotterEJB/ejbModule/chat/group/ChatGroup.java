package chat.group;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import tradeBlotter.jpa.GroupChat;
import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class ChatGroup
 */
@Stateful
@Local(ChatGroupLocal.class)
@Remote(ChatGroupRemote.class)
public class ChatGroup implements ChatGroupRemote, ChatGroupLocal {

    /**
     * Default constructor. 
     */
	
	

	@Resource
	private SessionContext sessionContext;
	
	@PersistenceContext(name="TradeBlotterJPA-PU")
	public EntityManager em; 
	
	
    public ChatGroup() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    /*
     * 
     * 
     *This function gets all the group messages for the trader's department
     *
     *
     */
    
    
    
    public List<GroupChat> getMessages(String userID) {
    	TypedQuery<User> userQuery = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		userQuery.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = userQuery.getResultList();
		
		User LoginUser = userData.get(0);
		String department = LoginUser.getDepartment();
    	System.out.println("\n\n---------------------\n\n"+department+"\n\n-----------------\n\n");
    	TypedQuery<GroupChat> query = em.createQuery("SELECT p FROM GroupChat AS p WHERE p.department ='"+department+"'", GroupChat.class);
//    	userQuery.setParameter("userDepartment", department);
        // Execute the query, and get a collection of entities back.
        List<GroupChat> chats = query.getResultList();
        return chats;
    }
    
    
    
    //This function gets the list of the online users within a department
    
    public List<HashMap<String,String>> getOnlineUsers(String userID){
    	TypedQuery<User> userQuery = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		userQuery.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = userQuery.getResultList();
		
		User LoginUser = userData.get(0);
		String department = LoginUser.getDepartment();
		String userName = LoginUser.getUserName();
    	HashMap<String,String> onlineUserDetails = new HashMap<String,String>(); 
    	List<HashMap<String,String>> listHash = new ArrayList<HashMap<String,String>>();
    	userQuery = em.createQuery("SELECT u FROM User AS u WHERE u.loginConfirmation = '1' AND u.department = :dept AND u.userName <> :nameUser",User.class);
    	userQuery.setParameter("dept", department);
    	userQuery.setParameter("nameUser", userName);
    	
    	userData = userQuery.getResultList();
    	
    	for(User u: userData){
    		
    		onlineUserDetails.put("userID", u.getUserID());
    		onlineUserDetails.put("userName", u.getUserName());
    		onlineUserDetails.put("department", u.getDepartment());
    		
    		listHash.add(onlineUserDetails);

    		 onlineUserDetails = new HashMap<String,String>(); 
    	}
    	
    	return listHash;
    	
    
    
    }
    
    
    /*This function let's the logged in user to post the message to the group hat for the department
     * 
     * 
     * 
     * (non-Javadoc)
     * @see chat.group.ChatGroupRemote#postMessage(java.lang.String, java.lang.String)
     */
    
    public void postMessage(String userID ,String message){
    	GroupChat groupChat = new GroupChat();
    	
    	TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		
		User LoginUser = userData.get(0);
		String department = LoginUser.getDepartment();
		String userName = LoginUser.getUserName();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String timestamp = time.toString();
		
		TypedQuery<GroupChat> messageIdQuery = em.createQuery("SELECT p FROM GroupChat AS p ORDER BY p.messageID DESC", GroupChat.class);

	    // Execute the query, and get a collection of entities back.
	    List<GroupChat> messageData = messageIdQuery.getResultList();
	    int counter = 0;
	    int prevMessageId = 0;
		
		//To position the cursor to the resultset starting columns.
		for(GroupChat t : messageData){
			if(counter==0){	
			//System.out.println(t.getTradeID() + t.getTradeType() + t.getSubmissionDate() + t.getStatus() + t.getIsin() + t.getProduct() + t.getQuantity() + t.getPrice() + t.getQuoteVolume() + t.getTerms() + t.getTraderID() + t.getFirmName() );
			
			prevMessageId = t.getMessageID();
			counter=1;
			}
		}
	    
	    
		groupChat.setMessageID(prevMessageId+1);
		groupChat.setUserID(userID);
    	groupChat.setTimeStamp(timestamp);
    	groupChat.setDepartment(department);
    	groupChat.setMessage(message);
    	groupChat.setUserName(userName);
    	

    	em.persist(groupChat);	

    }
}
