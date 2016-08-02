package tradeBlotter.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserInfoRemote {
	
	public List<String> getUserInfo(String userID);

}