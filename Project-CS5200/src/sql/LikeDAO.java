package sql;

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
	
	public LikeDAO() {
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

	public static void main(String[] args) {
		
		LikeDAO dao = new LikeDAO();
		
		Like like1 = new Like("username1","ljhlkuh",new java.sql.Timestamp(System.currentTimeMillis()));

		List<Like> listOfResult = dao.RecentLikes("username1");
		for (Like l : listOfResult) {
			System.out.println(l.getSku());
			System.out.println(l.getDateliked());
		}

	}
	
}
