package anneAndy.projects.ArtCritSiteBack.Image;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.annotation.JsonFormat;

import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientComment;
import anneAndy.projects.ArtCritSiteBack.ClientComment.ClientCommentRepository;
import anneAndy.projects.ArtCritSiteBack.Services.S3.S3Service;
import anneAndy.projects.ArtCritSiteBack.Services.S3.S3ServiceImpl;
import anneAndy.projects.ArtCritSiteBack.User.User;
import anneAndy.projects.ArtCritSiteBack.User.UserRepository;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@Controller
@RequestMapping(path="/images")
public class ImageController {
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientCommentRepository clientCommentRepository;
	
	S3Service s3Service;
	
	@RequestMapping(value= "/{imageKey:.+}", method = RequestMethod.PUT, consumes = {"application/json"})
	public @ResponseBody Image updateUserImage(@PathVariable("imageKey") String imageKey, @RequestBody Image editedImage) {
		
		Image originalImage = imageRepository.findByImageKey(imageKey);
	
		editedImage.setUser(originalImage.getUser());
		Set<ClientComment> comments = editedImage.getClientComments();
		
		for(ClientComment comment : comments) {
			comment.setImage(editedImage);
		    clientCommentRepository.save(comment);
		}

		imageRepository.save(editedImage);
		
		return imageRepository.findByImageKey(imageKey);
		
	}
	
	@RequestMapping(path="/new", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody Image saveImageMetadata(@RequestBody Image image) {
		System.out.println(image);
		return new Image("asd","asd");
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
        s3Service = new S3ServiceImpl();

        if (!file.isEmpty()) {
             bytes = file.getBytes();
             System.out.println(file);
             System.out.println(imageKey);
             s3Service.uploadFile(imageKey, file);
        }

        System.out.println(String.format("received %s for %s", file.getOriginalFilename(), imageKey));
    }
	
	@RequestMapping(value= "/recent", method = RequestMethod.GET)
    public @ResponseBody Iterable<Image> getLatestImages() {
		return imageRepository.findTop50ByOrderByDateSubmittedDesc(); 
    }
	
}
