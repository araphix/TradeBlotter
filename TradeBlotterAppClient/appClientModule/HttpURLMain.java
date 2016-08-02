import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tradeBlotter.jpa.User;

public class HttpURLMain {

	private final String USER_AGENT = "Mozilla/5.0";
	@PersistenceContext(name = "TradeBlotterJPA-PU")
	public static EntityManager em;
	public static String TradeInfo() {

		HttpURLMain http = new HttpURLMain();
String returnedString = null;
		System.out.println("Testing 1 - Send Http GET request");
		 
		try {
			returnedString = http.sendGet("http://localhost:8080/TradeBlotterWeb/rest/user?traderID=BN41252");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnedString;

//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();

	}
	
	
	public static String UserInfo(String url){
		
		HttpURLMain http = new HttpURLMain();
		String returnedString = null;
				System.out.println("Testing 1 - Send Http GET request");
				 
				try {
					returnedString = http.sendGet(url);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return returnedString;
		
	}
	
public static String onlineGroup(String url){
		
		HttpURLMain http = new HttpURLMain();
		String returnedString = null;
				System.out.println("Testing 1 - Send Http GET request");
				 
				try {
					returnedString = http.sendGet(url);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return returnedString;
		
	}
	
	
	
	
	public static String getConfirmation(String userID) {

		TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		User LoginUser = userData.get(0);
		if(LoginUser.getLoginConfirmation()=="1") return "1";
		else return "0";

	}
	
	
	public static void loginUser(String url,String urlParameter){
		
		HttpURLMain http = new HttpURLMain();
		String returnedString = null;
				System.out.println("Testing 1 - Send Http GET request");
				 
				try {
					returnedString = http.sendPost(url,urlParameter);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
	}
	

	// HTTP GET request
	private String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return response.toString();

	}

	// HTTP POST request
	private String sendPost(String url,String urlParameters) throws Exception {

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return response.toString();

	}

}
