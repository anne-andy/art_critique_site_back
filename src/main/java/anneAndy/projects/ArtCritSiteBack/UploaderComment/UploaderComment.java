package anneAndy.projects.ArtCritSiteBack.UploaderComment;

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
@Table(name = "UploaderComment")
public class UploaderComment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUploaderComment;
	
	private String goalComment;
	
	private String needComment;
	
	private String otherComment;
	
	//private String imageKey;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="imageKey", nullable = false)
	private Image image;
	
	public UploaderComment() {
		this.setGoalComment("nothing");
	}
	
	public UploaderComment(Integer idUploaderComment, String goalComment, String needComment, String otherComment) {
		this.setId(idUploaderComment);
		this.setGoalComment(goalComment);
		this.setNeedComment(needComment);
		this.setOtherComment(otherComment);
	}
	
	public UploaderComment(Integer idUploaderComment, String goalComment, String needComment, String otherComment, Image image) {
		this.setId(idUploaderComment);
		this.setGoalComment(goalComment);
		this.setNeedComment(needComment);
		this.setOtherComment(otherComment);
		this.setImage(image);
	}
	
	public void setId(Integer idUploaderComment) {
		this.idUploaderComment = idUploaderComment;
	}
		
	public Integer getId() {
		return this.idUploaderComment;
	}

	public String getGoalComment() {
		return goalComment;
	}

	public void setGoalComment(String goalComment) {
		this.goalComment = goalComment;
	}

	public String getNeedComment() {
		return needComment;
	}

	public void setNeedComment(String needComment) {
		this.needComment = needComment;
	}

	public String getOtherComment() {
		return otherComment;
	}

	public void setOtherComment(String otherComment) {
		this.otherComment = otherComment;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

//	public String getImageKey() {
//		return imageKey;
//	}
//
//	public void setImageKey(String imageKey) {
//		this.imageKey = imageKey;
//	}
	
	
}
