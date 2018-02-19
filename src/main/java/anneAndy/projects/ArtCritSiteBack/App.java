package anneAndy.projects.ArtCritSiteBack;

import java.io.File;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import anneAndy.projects.ArtCritSiteBack.Services.S3.S3ServiceImpl;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	new S3ServiceImpl().uploadFile("a.jpg", "C:\\Users\\shiny\\Pictures\\Cyberpunk\\a.jpg");
    }
}
