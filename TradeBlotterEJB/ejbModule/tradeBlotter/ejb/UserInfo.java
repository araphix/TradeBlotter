package tradeBlotter.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tradeBlotter.jpa.User;

/**
 * Session Bean implementation class UserInfo
 */
@Stateful
@Local(UserInfoLocal.class)
@Remote(UserInfoRemote.class)

public class UserInfo implements UserInfoRemote, UserInfoLocal {

	private EntityManager em;

	public List<String> getUserInfo(String userID) {

		List<String> userDetails = new ArrayList<String>();

		TypedQuery<User> query = em.createQuery("SELECT p FROM User AS p Where p.userID = :userIDParam", User.class);
		query.setParameter("userIDParam", userID);
		// Execute the query, and get a collection of entities back.

		List<User> userData = query.getResultList();
		userDetails.add(userData.get(0).getUserID());
		userDetails.add(userData.get(0).getUserName());
		userDetails.add(userData.get(0).getDepartment());
		System.out.println(userData.get(0).getUserID());

		return userDetails;

		// return the user data for displaying

	}

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

}