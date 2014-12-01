package sql;

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
	
	public FollowDAO() {
		em = factory.createEntityManager();
	}
	
	public void CreateFollow (Follow follow) {	
		if(UserDAO.getInstance().findUser(follow.getUserfollowed()) == null) {
			System.out.println("The user you are trying to follow does not exist!");	
		}
		else if(follow.getUserfollowed().equals(follow.getUserfollowing())) {
			System.out.println("User cannot follow himself!");
		}
		else {
			em.getTransaction().begin();
			em.persist(follow);
			em.getTransaction().commit();
		}
	}
	
	public List<Follow> RecentFollows(String username) {
		List<Follow> follows = new ArrayList<Follow>();
		
		Integer limiter = 5;
		
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Follow f WHERE f.userfollowing=:username ORDER BY f.datefollowed DESC").setMaxResults(limiter);
		query.setParameter("username", username);
		try {
			follows = query.getResultList();
			return follows;
		}
		catch (NoResultException e){
			return null;
		}
	}

	public static void main(String[] args) {
		FollowDAO dao = new FollowDAO();
		

		//Follow follow1 = new Follow("username1","username10",new java.sql.Timestamp(System.currentTimeMillis()));
		//dao.CreateFollow(follow1);
		List<Follow> listOfResult = dao.RecentFollows("username1");
		for (Follow f : listOfResult) {
			System.out.println(f.getUserfollowed());
			System.out.println(f.getDatefollowed());
		}

	}

}