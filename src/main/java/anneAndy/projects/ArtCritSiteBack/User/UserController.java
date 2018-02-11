package anneAndy.projects.ArtCritSiteBack.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import anneAndy.projects.ArtCritSiteBack.User.UserRepository;

@Controller  
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}





//package SpringBootTutorial.SpringBootTutorial;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import SpringBootTutorial.SpringBootTutorial.Greeting;
//import SpringBootTutorial.SpringBootTutorial.GreetingRepository;
//
//@Controller  
//@RequestMapping(path="/greeting")
//public class GreetingController {
//	
//	@Autowired
//	private GreetingRepository greetingRepository;
//
//    @GetMapping(path="/add")
//    public @ResponseBody String addGreeting(@RequestParam String content) {
//    	
//    	Greeting greeting = new Greeting();
//    	greeting.setContent(content);
//    	//greeting.setId(1);
//    	greetingRepository.save(greeting);
//    	System.out.println(greeting);
//    	return "Saved new greeting!";
//    	
//    }
//    
//    @GetMapping(path="/all")
//	public @ResponseBody Iterable<Greeting> getAllUsers() {
//		// This returns a JSON or XML with the users
//		return greetingRepository.findAll();
//	}
//    
//}

