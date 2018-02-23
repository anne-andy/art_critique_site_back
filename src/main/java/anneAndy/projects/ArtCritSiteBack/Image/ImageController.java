package anneAndy.projects.ArtCritSiteBack.Image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import anneAndy.projects.ArtCritSiteBack.User.User;

@Controller
@RequestMapping(path="/images")
public class ImageController {
	
	ImageRepository imageRepository;
	
	@RequestMapping(path="/new", method = RequestMethod.POST)
	public @ResponseBody Image uploadUserImage(Image image) {
		System.out.println(image.toString());
		return imageRepository.save(image);
	}

}
