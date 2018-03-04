package anneAndy.projects.ArtCritSiteBack.Image;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientComment;
import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientCommentRepository;
import anneAndy.projects.ArtCritSiteBack.Services.S3.S3Service;
import anneAndy.projects.ArtCritSiteBack.User.IOException;
import anneAndy.projects.ArtCritSiteBack.User.User;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@Controller
@RequestMapping(path="/images")
public class ImageController {
	
	ImageRepository imageRepository;
	ClientCommentRepository clientCommentRepository;
	
	S3Service s3Service;
	
	@RequestMapping(path="/new", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody Image saveImageMetadata(@RequestBody Image image) {
		System.out.println(image);
		//User user = userRepository.findById(image.idUser);
		//return imageRepository.save(image);
		return new Image("asd","asd");
	}
	
	@RequestMapping(path="/{keyName}/upload", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<?> uploadImageFile(@RequestParam String keyName, MultipartFile file) {
        return s3Service.uploadFile(keyName, file);
	}
	
	@RequestMapping(path="/{keyName}/clientComment", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody ClientComment addClientComment(@PathVariable("keyname") String keyName, @RequestBody ClientComment clientComment) {
		
		Image image = imageRepository.findByImageKey(keyName);
		clientComment.setImage(image);
		return clientCommentRepository.save(clientComment);
	}
	
	@RequestMapping(value= "/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file, @RequestParam("imageKey") String imageKey ) throws java.io.IOException {

        byte[] bytes;

        if (!file.isEmpty()) {
             bytes = file.getBytes();
             System.out.println(file);
             System.out.println(imageKey);
             s3Service.uploadFile();
        }

        System.out.println(String.format("received %s for %s", file.getOriginalFilename(), imageKey));
    }

}
