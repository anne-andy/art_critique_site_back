package anneAndy.projects.ArtCritSiteBack.UploaderComment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import anneAndy.projects.ArtCritSiteBack.Image.Image;
import anneAndy.projects.ArtCritSiteBack.User.User;

@Entity
@Table(name = "UploaderComment")
public class UploaderComment {

	@Id
	private String imageKey;

	private String goalComment;

	private String needComment;

	private String otherComment;

	@JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn(name="imageKey", referencedColumnName="imageKey")
	private Image image;

	public UploaderComment() {
		this.setGoalComment("nothing");
	}

	public UploaderComment(String goalComment, String needComment, String otherComment, Image image) {
		this.imageKey = image.getImageKey();
		this.setGoalComment(goalComment);
		this.setNeedComment(needComment);
		this.setOtherComment(otherComment);
		this.setImage(image);
	}

	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	public String getImageKey() {
		return this.imageKey;
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

}
