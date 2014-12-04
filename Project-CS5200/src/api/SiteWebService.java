package api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import sql.*;

// api/site
@Path("/site")
public class SiteWebService {
	
	CommentDAO commentdao = CommentDAO.getInstance();
	FollowDAO followdao = FollowDAO.getInstance();
	LikeDAO likedao = LikeDAO.getInstance();
	UserDAO userdao = UserDAO.getInstance();
	//uh	
	
	@GET
	@Produces("application/json")
	@Path("/{username}")
	public User getUserbyUsername(@PathParam("username") String username) {
		return userdao.findUser(username);
	}

	

}