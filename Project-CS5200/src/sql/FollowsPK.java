package sql;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Follows
 *
 */ 
public class FollowsPK  implements Serializable {   
   
	         
	private String userfollowing;         
	private String userfollowed;
	private static final long serialVersionUID = 1L;

	public FollowsPK() {}

	

	public String getUserfollowing() {
		return this.userfollowing;
	}

	public void setUserfollowing(String userfollowing) {
		this.userfollowing = userfollowing;
	}
	

	public String getUserfollowed() {
		return this.userfollowed;
	}

	public void setUserfollowed(String userfollowed) {
		this.userfollowed = userfollowed;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof FollowsPK)) {
			return false;
		}
		FollowsPK other = (FollowsPK) o;
		return true
			&& (getUserfollowing() == null ? other.getUserfollowing() == null : getUserfollowing().equals(other.getUserfollowing()))
			&& (getUserfollowed() == null ? other.getUserfollowed() == null : getUserfollowed().equals(other.getUserfollowed()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getUserfollowing() == null ? 0 : getUserfollowing().hashCode());
		result = prime * result + (getUserfollowed() == null ? 0 : getUserfollowed().hashCode());
		return result;
	}
   
   
}
