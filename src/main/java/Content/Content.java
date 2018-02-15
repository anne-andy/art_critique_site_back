//package Content;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import anneAndy.projects.ArtCritSiteBack.Image.Image;
//
//public class Content {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer idContent;
//	private String idUser;
//	private String contentTitle;
//	private String genre;
//
//	public Integer getIdContent() {
//		return idContent;
//	}
//	
//	public String getIdUser() {
//		return idUser;
//	}
//	
//	public void setIdUser(String idUser) {
//		this.idUser = idUser;
//	}
//	
//	public String getContentTitle() {
//		return contentTitle;
//	}
//	
//	public void setContentTitle(String contentTitle) {
//		this.contentTitle = contentTitle;
//	}
//	
//	public String getGenre() {
//		return genre;
//	}
//	
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//	
//	public void addImage(Image image) {
//		image.setContent(this);
//	}
//	
////	public Image getImage() {
////		
////	}
//	
//
//	
//}
