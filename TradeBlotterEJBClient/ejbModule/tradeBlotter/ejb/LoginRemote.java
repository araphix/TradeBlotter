package tradeBlotter.ejb;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LoginRemote {

	public boolean userLogin(String userID, String password);
	public void setConfirmation(String loginConfirmation, String userID);
	public String getConfirmation(String userID);

	public HashMap<String,String> getUserInfo(String userID);
	public void logOutUser(String userID);

}
