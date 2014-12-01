package sql;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Comments
 *
 */
@Entity
@Table(name="Comments")
public class Comment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commentid;
	private String commenter;
	private String sku;
	private Timestamp date;
	private String content;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}   
	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}   
	public String getCommenter() {
		return this.commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}   
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}   
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Comment(String commenter, String sku, Timestamp date, String content) {
		super();
		this.commenter = commenter;
		this.sku = sku;
		this.date = date;
		this.content = content;
	}
	
}
