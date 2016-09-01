package tradeBlotter.ejb;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

@Local
public interface LoginLocal {
	public void logOutUser(String userID);
	public HashMap<String,String> getUserInfo(String userID);
}
