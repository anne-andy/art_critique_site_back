package anneAndy.projects.ArtCritSiteBack.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "Image")

public class Image {
	
	private String imageKey;
	private String type; //needs to be an enum in the future
	private String title;
	private User user;
	
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
	
	@ManyToOne
	@JoinColumn(name= "imageKey")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
