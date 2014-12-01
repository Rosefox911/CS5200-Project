package sql;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Likes
 *
 */
@Entity
@Table(name="Likes")
@IdClass(LikesPK.class)
public class Like implements Serializable {

	   
	@Id
	private String username;   
	@Id
	private String sku;
	private Timestamp dateliked;
	private static final long serialVersionUID = 1L;

	public Like() {
		super();
	}   
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
	public Timestamp getDateliked() {
		return this.dateliked;
	}

	public void setDateliked(Timestamp dateliked) {
		this.dateliked = dateliked;
	}
	public Like(String username, String sku, Timestamp dateliked) {
		super();
		this.username = username;
		this.sku = sku;
		this.dateliked = dateliked;
	} 
}
