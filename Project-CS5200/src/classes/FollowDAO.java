package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FollowDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project");
	EntityManager em = null;
	
	static FollowDAO instance = null;
	
	public static FollowDAO getInstance() {
		if(instance == null) {
			instance = new FollowDAO();
		}
		return instance;
	}
	
	private FollowDAO() {
		em = factory.createEntityManager();
	}
	
	public void CreateFollow (Follow follow) {	
		if (UserDAO.getInstance().findUser(follow.getId().getUserfollowed()) == null) {
			System.out.println("The user you are trying to follow does not exist!");	
		}
		else if (follow.getId().getUserfollowed().equals(follow.getId().getUserfollowing())) {
			System.out.println("User cannot follow himself!");
		}
		else {
			try {
				em.getTransaction().begin();
				em.persist(follow);
				em.getTransaction().commit();
			}
			catch (Exception e) {
				System.out.println("Unable to add follow, may result by duplicated pk");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Follow> RecentFollows(String username) {
		List<Follow> follows = new ArrayList<Follow>();
		
		Integer limiter = 5;
		
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Follow f WHERE f.userfollowing=:username ORDER BY f.datefollowed DESC").setMaxResults(limiter);
		query.setParameter("username", username);
		em.getTransaction().commit();
		try {
			follows = (List<Follow>)query.getResultList();
			return follows;
		}
		catch (NoResultException e){
			return null;
		}
	}
	
	public void unFollow(String curUsername, String followedUsername) {
		
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("DELETE f FROM Follow f WHERE f.userfollowing=:username AND f.userfollowed=:followedUsername");
			query.setParameter("username", curUsername);
			query.setParameter("followedUsername", followedUsername);
			em.getTransaction().commit();
		}
		catch (IllegalArgumentException e) {
			System.out.println("System trying to delete an invalid follow!");
		}
	}

	public static void main(String[] args) {
		FollowDAO dao = new FollowDAO();
		UserDAO userDao = UserDAO.getInstance();
		User user1 = userDao.findUser("username1");
		User user2 = userDao.findUser("username10");

		Follow follow1 = new Follow(new FollowPK("username1","username10"),
				new java.sql.Timestamp(System.currentTimeMillis()), user1, user2);
		//dao.CreateFollow(follow1);
		List<Follow> listOfResult = dao.RecentFollows("username1");
		for (Follow f : listOfResult) {
			System.out.println(f.getId().getUserfollowed());
			System.out.println(f.getDatefollowed());
		}
		dao.unFollow("username1", "username10");
	}
}