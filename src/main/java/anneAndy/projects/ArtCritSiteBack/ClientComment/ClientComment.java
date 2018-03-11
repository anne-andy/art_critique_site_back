package anneAndy.projects.ArtCritSiteBack.ClientComment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import anneAndy.projects.ArtCritSiteBack.Image.Image;
import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "ClientComment")
public class ClientComment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idClientComment;
	
	private String commentText;
	
	private Integer commentScore;
	
	private Integer idUser; //this will be hateous link?
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name="imageKey", nullable = false)
	private Image image;
	
	public ClientComment() {
		//
	}
	
	public ClientComment(Integer idClientComment, String commentText, Integer commentScore, Integer idUser) {
		this.setIdClientComment(idClientComment);
		this.setCommentText(commentText);
		this.setCommentScore(commentScore);
		this.setIdUser(idUser);
	}
	
	public ClientComment(Integer idClientComment, String commentText, Integer commentScore, Integer idUser, Image image) {
		this.setIdClientComment(idClientComment);
		this.setCommentText(commentText);
		this.setCommentScore(commentScore);
		this.setIdUser(idUser);
		this.setImage(image);
	}
	
	public void setIdClientComment(Integer idClientComment) {
		this.idClientComment = idClientComment;
	}
		
	public Integer getIdClientComment() {
		return this.idClientComment;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(Integer commentScore) {
		this.commentScore = commentScore;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return idClientComment + " : " + commentScore + " : " + commentText + " : " + idUser +
				image.getImageKey(); 
	}

	
}
