package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CommentDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project");
	EntityManager em = null;
	static CommentDAO instance = null;
	
	public static CommentDAO getInstance() {
		if(instance == null) {
			instance = new CommentDAO();
		}
		return instance;
	}
	
	private CommentDAO() {
		em = factory.createEntityManager();
	}
	
	public void CreateComment (Comment comment) {	
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> RecentComments(String username) {
		List<Comment> comments = new ArrayList<Comment>();
		
		Integer limiter = 5;
		
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Comment c WHERE c.commenter=:username ORDER BY c.date DESC").setMaxResults(limiter);
		query.setParameter("username", username);
		try {
			comments = (List<Comment>)query.getResultList();
			return comments;
		}
		catch (NoResultException e){
			return null;
		}
	}

	public static void main(String[] args) {
		CommentDAO dao = new CommentDAO();
	
		Comment comment1 = new Comment("username1","123456",new java.sql.Timestamp(System.currentTimeMillis()), "Test comment");
		dao.CreateComment(comment1);
		List<Comment> listOfResult = dao.RecentComments("username1");
		for (Comment c : listOfResult) {
			System.out.println(c.getSku());
			System.out.println(c.getContent());
			System.out.println(c.getDate());
		}	
	}
}
