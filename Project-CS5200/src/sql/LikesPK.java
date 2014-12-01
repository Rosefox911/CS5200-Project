package sql;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Likes
 *
 */ 
public class LikesPK  implements Serializable {   
   
	         
	private String username;         
	private String sku;
	private static final long serialVersionUID = 1L;

	public LikesPK() {}

	

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof LikesPK)) {
			return false;
		}
		LikesPK other = (LikesPK) o;
		return true
			&& (getUsername() == null ? other.getUsername() == null : getUsername().equals(other.getUsername()))
			&& (getSku() == null ? other.getSku() == null : getSku().equals(other.getSku()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getUsername() == null ? 0 : getUsername().hashCode());
		result = prime * result + (getSku() == null ? 0 : getSku().hashCode());
		return result;
	}
   
   
}
