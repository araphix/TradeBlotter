package chat.personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tradeBlotter.jpa.PersonalChat;

@Remote
public interface ChatPersonalRemote {

	public List<PersonalChat> getMessages(String userID, String receiverID);
	public void postMessage(String userID ,String message, String receiverID);
	public List<HashMap<String, String>> getMyMessages(String userID);
}
