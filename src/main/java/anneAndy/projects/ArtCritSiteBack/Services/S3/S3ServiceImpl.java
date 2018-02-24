package anneAndy.projects.ArtCritSiteBack.Services.S3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;

@Service
public class S3ServiceImpl implements S3Service {
	
	private AmazonS3 s3Client;

	public ResponseEntity<?> uploadFile(String imageKey, MultipartFile file) {
		
		s3Client = S3Config.generateS3Client();
		
		try {
			if (file.isEmpty()) {
	            return new ResponseEntity("please select a file!", HttpStatus.OK);
	        } else {
	        	s3Client.putObject("anneandycdn", imageKey, convertMultiPartToFile(file));
	        }
			//.withCannedAcl(CannedAccessControlList.PublicRead)); this doesn't work for some reason
		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SdkClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity("Successfully uploaded file: ", new HttpHeaders(), HttpStatus.OK);
	
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
	
}
