package anneAndy.projects.ArtCritSiteBack.User;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

import anneAndy.projects.ArtCritSiteBack.Image.Image;
import anneAndy.projects.ArtCritSiteBack.Image.ImageRepository;
import anneAndy.projects.ArtCritSiteBack.User.UserRepository;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@Controller  
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody User findOne(@PathVariable("id") int id) {
        return userRepository.findByIdUser(id);
    }
	
	@RequestMapping(value= "/{id}/image", method = RequestMethod.POST)
	public @ResponseBody Image uploadUserImage(@PathVariable("id") int id, @RequestBody Image image) {

		User user = userRepository.findByIdUser(id);
		
		image.setUser(user);
		image.getUploaderComment().setImageKey(image.getImageKey());
		image.setDateSubmitted(new Date());
		
		//TODO: generate unique keyname here?
		
		return imageRepository.save(image);
		
	}
	
}


