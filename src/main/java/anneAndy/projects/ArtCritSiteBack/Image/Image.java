package anneAndy.projects.ArtCritSiteBack.Image;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientComment;
import anneAndy.projects.ArtCritSiteBack.UploaderComment.UploaderComment;
import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "Image")
public class Image implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String imageKey;
	
	private String type; //TO DO: this needs to be an enum in the future
	
	private String title;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "image")
	private UploaderComment uploaderComment;
	
	@OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "image")
	private Set<ClientComment> clientComments;
	
	public Image() {
		
	}	
	
	public Image(String imageKey, String title) {
		this.setImageKey(imageKey);
		this.setTitle(title);
	}
	
	public Image(String imageKey, String title, User user) {
		this.setImageKey(imageKey);
		this.setTitle(title);
		this.setUser(user);
	}

	public String getImageKey() {
		return imageKey;
	}

	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setUploaderComment(UploaderComment uploaderComment) {
		this.uploaderComment = uploaderComment;
		System.out.println(uploaderComment);
	}
	
	public UploaderComment getUploaderComment() {
		return this.uploaderComment;
	}
	
	public void setClientComments(Set<ClientComment> clientComments) {
		this.clientComments = clientComments;
	}
	
	public Set<ClientComment> getClientComments() {
		return this.clientComments;
	}
	
	@Override
	public String toString() {
		return imageKey + " : " + 
	title + " : " + 
				type + " : " + 
//	user.getId() + " : " + 
//				user.getUserName() + " : " +
				uploaderComment.getGoalComment();
	}

}
