import static org.junit.Assert.*;

import org.junit.Test;

public class HttpURLMainTest {

	@Test
	public void testTradeInfo() {
		
		String testString = HttpURLMain.TradeInfo();
		
		assertNotEquals(testString.length(),0);
		
	}
	
	
	@Test
	public void TestUserInfo(){
		String testString = HttpURLMain.UserInfo("http://localhost:8080/TradeBlotterWeb/rest/user/userInfo?userID=BN41252");
	
		assertNotEquals(testString.length(),0);
	
	}
	
	@Test
	public void TestOnlineGroup(){
		String testString = HttpURLMain.onlineGroup("http://localhost:8080/TradeBlotterWeb/rest/chat/onlineUsers?traderID=BN41252");
		
		System.out.println(testString);
		
		assertEquals(testString,"[{\"userName\":\"Ankur\",\"department\":\"BN\",\"userID\":\"BN41272\"}]");
		
	}
	
	
	
	
	
	
	

}
