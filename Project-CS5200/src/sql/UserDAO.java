package sql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project");
	EntityManager em = null;
	static UserDAO instance = null;
	
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	private UserDAO() {
		em = factory.createEntityManager();
	}
	
	public void CreateUser (User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public User findUser(String username) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username=:username");
		query.setParameter("username", username);
		try {
		User user = (User) query.getSingleResult();
		return user;
		}
		catch (NoResultException e){
			return null;
		}
	}
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		User user1 = new User("username1","pass","John","Doe","johndoe@hotmail.com","someurl","just my simple bio" );
		User user2 = new User("username10", "pass2","Josh","Joshson", "josh@thatguy.com", "imgur.com/stuff", "just some stuf");
				//dao.CreateUser(user2);
	
	}

}
