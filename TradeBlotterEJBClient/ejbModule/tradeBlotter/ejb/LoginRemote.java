package tradeBlotter.ejb;

import javax.ejb.Remote;

@Remote
public interface LoginRemote {

	public boolean userLogin(String userID, String password);
	public void setConfirmation(String loginConfirmation, String userID);
	public String getConfirmation(String userID);
	
	

}
