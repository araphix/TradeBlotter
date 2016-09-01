package tradeBlotter.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LoginLocal {
	public void logOutUser(String userID);

	public List<String> getUserInfo(String userID);
}
