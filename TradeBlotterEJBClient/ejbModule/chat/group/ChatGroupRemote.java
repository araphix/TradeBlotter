package chat.group;

import java.util.List;

import javax.ejb.Remote;

import tradeBlotter.jpa.GroupChat;

@Remote
public interface ChatGroupRemote {

	
	public void postMessage(String userID, String message);
	public List<GroupChat> getMessages(String userID);
	
	
}
