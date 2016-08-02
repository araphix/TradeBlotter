package chat.group;

import java.util.List;

import javax.ejb.Local;

import tradeBlotter.jpa.GroupChat;

@Local
public interface ChatGroupLocal {
	public void postMessage(String userID, String message);
	public List<GroupChat> getMessages(String userID);
}
