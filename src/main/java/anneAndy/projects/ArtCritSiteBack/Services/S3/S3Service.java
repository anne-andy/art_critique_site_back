package anneAndy.projects.ArtCritSiteBack.Services.S3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

	public ResponseEntity<?>  uploadFile(String keyName, MultipartFile file);
	
}
