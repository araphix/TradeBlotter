package tradeBlotter.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tradeBlotter.jpa.TradeInfo;
import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class Login
 */
@Stateful
@LocalBean
public class Login implements LoginRemote, LoginLocal {

	/**
	 * Default constructor.
	 */

	// Add the persistence context for the login bean

	@Resource
	private SessionContext sessionContext;

	@PersistenceContext(name = "TradeBlotterJPA-PU")
	public EntityManager em;

	// Check if the user name and password matches

	public void setConfirmation(String loginConfirmation, String userID) {

		
		Query query = em.createQuery("UPDATE User AS u SET u.loginConfirmation = :userConf where u.userID= :userLog");
		query.setParameter("userLog", userID);
		query.setParameter("userConf", loginConfirmation);
		query.executeUpdate();


	}

	public String getConfirmation(String userID) {
		
		
		TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		User LoginUser = userData.get(0);
		return LoginUser.getLoginConfirmation();
		

	}

	public boolean userLogin(String userID, String password) {

		boolean loginBool;

		TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.
		List<User> userData = query.getResultList();
		System.out.println(userData.get(0));
		User LoginUser = userData.get(0);
		String userPassword = LoginUser.getPassword();
		if (password.equals(userPassword)) {
			loginBool = true;
			System.out.println("password match");
		} else {
			loginBool = false;
			System.out.println("password no match");
		}
		return loginBool;

	}

	// return the boolean value for the checkCredentials function

	public Login() {
		// TODO Auto-generated constructor stub
	}

}
