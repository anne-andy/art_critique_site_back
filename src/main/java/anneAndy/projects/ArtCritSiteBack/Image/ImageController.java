package anneAndy.projects.ArtCritSiteBack.Image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import anneAndy.projects.ArtCritSiteBack.User.User;

@Controller
@RequestMapping(path="/images")
public class ImageController {
	
	ImageRepository imageRepository;
	
	@RequestMapping(path="/new", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody Image uploadUserImage(@RequestBody Image image) {
		System.out.println(image);
		//User user = userRepository.findById(image.idUser);
		//return imageRepository.save(image);
		return new Image("asd","asd");
	}

}
