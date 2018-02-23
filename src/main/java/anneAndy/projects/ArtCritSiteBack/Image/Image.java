package anneAndy.projects.ArtCritSiteBack.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "Image")

public class Image {
	
	@Id
	private String imageKey;
	private String type; //TO DO: this needs to be an enum in the future
	private String title;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	public Image() {
		
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
	

}
