package chat.personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import tradeBlotter.jpa.PersonalChat;

@Local
public interface ChatPersonalLocal {
	public List<PersonalChat> getMessages(String userID, String receiverID);
	public void postMessage(String userID ,String message, String receiverID);
	 public List<HashMap<String, String>> getMyMessages(String userID);
}
