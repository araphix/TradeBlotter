package chat.group;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import tradeBlotter.jpa.GroupChat;
import tradeBlotter.jpa.User;

@Remote
public interface ChatGroupRemote {

	
	public void postMessage(String userID, String message);
	public List<GroupChat> getMessages(String userID);
	public List<HashMap<String,String>> getOnlineUsers(String userID);
	
}
