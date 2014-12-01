package sql;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Follows
 *
 */
@Entity
@Table(name="Follows")
@IdClass(FollowsPK.class)
public class Follow implements Serializable {

	   
	@Id
	private String userfollowing;   
	@Id
	private String userfollowed;
	private Timestamp datefollowed;
	private static final long serialVersionUID = 1L;
	
	
	public String getUserfollowing() {
		return userfollowing;
	}
	public void setUserfollowing(String userfollowing) {
		this.userfollowing = userfollowing;
	}
	public String getUserfollowed() {
		return userfollowed;
	}
	public void setUserfollowed(String userfollowed) {
		this.userfollowed = userfollowed;
	}
	public Timestamp getDatefollowed() {
		return datefollowed;
	}
	public void setDatefollowed(Timestamp datefollowed) {
		this.datefollowed = datefollowed;
	}
	public Follow() {
		super();
	}
	public Follow(String userfollowing, String userfollowed,
			Timestamp datefollowed) {
		super();
		this.userfollowing = userfollowing;
		this.userfollowed = userfollowed;
		this.datefollowed = datefollowed;
	}
}
