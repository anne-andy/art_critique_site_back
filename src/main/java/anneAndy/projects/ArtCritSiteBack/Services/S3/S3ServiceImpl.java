package anneAndy.projects.ArtCritSiteBack.Services.S3;

import java.io.File;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;

@Service
public class S3ServiceImpl implements S3Service {
	
	private AmazonS3 s3Client;

	public void uploadFile(String keyName, String filePath) {
		s3Client = S3Config.generateS3Client();
		s3Client.putObject("anneandycdn", keyName, new File(filePath));
	}
	
}
