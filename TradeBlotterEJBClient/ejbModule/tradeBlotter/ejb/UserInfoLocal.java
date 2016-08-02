package tradeBlotter.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserInfoLocal {
	
	public List<String> getUserInfo(String userID);
	
}

