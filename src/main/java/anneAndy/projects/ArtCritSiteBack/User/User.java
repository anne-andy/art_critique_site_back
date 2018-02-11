package anneAndy.projects.ArtCritSiteBack.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUser;
	private String userName;
	private String password;
	private String dateJoined;
	
	public Integer getId() {
		return idUser;
	};
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDateJoined() {
		return dateJoined;
	}
	
	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

}
