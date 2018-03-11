package anneAndy.projects.ArtCritSiteBack.Image;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientComment;
import anneAndy.projects.ArtCritSiteBack.UploaderComment.UploaderComment;
import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "Image")
//@NamedQuery(name = "Image.findAll", query="select i from Image i order by i.dateSubmitted")
public class Image  {
	
	@Id
	private String imageKey;
	
	private String type; //TO DO: this needs to be an enum in the future
	
	private String title;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "dateSubmitted", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSubmitted;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "image")
	private UploaderComment uploaderComment;
	
	@OneToMany(fetch = FetchType.LAZY,
            cascade =  {CascadeType.PERSIST},
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
		return imageKey + " : " + title + " : " + type +
			   " : " + user.getId() + " : " + 
			   clientComments;
	}

	public String getDateSubmitted() {
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return newFormat.format(dateSubmitted);
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

}
