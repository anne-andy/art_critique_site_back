package anneAndy.projects.ArtCritSiteBack.Services.S3;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {

	public static AmazonS3 generateS3Client() {
		 return AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .build();
	}

}


//future improvements, ie. exception handling
//http://javasampleapproach.com/aws/amazon-s3/amazon-s3-uploaddownload-large-files-s3-springboot-amazon-s3-multipartfile-application
//https://medium.com/oril/uploading-files-to-aws-s3-bucket-using-spring-boot-483fcb6f8646