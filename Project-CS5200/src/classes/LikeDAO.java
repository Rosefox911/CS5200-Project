package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LikeDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project");
	EntityManager em = null;
	
	static LikeDAO instance = null;
	
	public static LikeDAO getInstance() {
		if(instance == null) {
			instance = new LikeDAO();
		}
		return instance;
	}
	
	private LikeDAO() {
		em = factory.createEntityManager();
	}
	
	public void CreateLike (Like like) {	
		em.getTransaction().begin();
		em.persist(like);
		em.getTransaction().commit();
	}
	
	public List<Like> RecentLikes(String username) {
		List<Like> likes = new ArrayList<Like>();
		
		Integer limiter = 5;
		
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT l FROM Like l WHERE l.username=:username ORDER BY l.dateliked DESC").setMaxResults(limiter);
		query.setParameter("username", username);
		try {
			likes = query.getResultList();
			return likes;
		}
		catch (NoResultException e){
			return null;
		}
	}

	public void unLike(String username, String sku) {
		
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("DELETE l FROM Like l WHERE l.username=:username AND l.sku=:sku");
			query.setParameter("username", username);
			query.setParameter("sku", sku);
			em.getTransaction().commit();
		}
		catch (IllegalArgumentException e) {
			System.out.println("System trying to delete an invalid like!");
		}
	}
	
	public static void main(String[] args) {
		
		LikeDAO dao = new LikeDAO();
		UserDAO userDao = UserDAO.getInstance();
		
		Like like1 = new Like(new LikePK("username1","ljhlkuh"), 
				new java.sql.Timestamp(System.currentTimeMillis()), userDao.findUser("username1"));

		List<Like> listOfResult = dao.RecentLikes("username1");
		for (Like l : listOfResult) {
			System.out.println(l.getId().getSku());
			System.out.println(l.getDateliked());
		}

	}
	
}
