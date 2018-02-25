package anneAndy.projects.ArtCritSiteBack.Image;

import org.springframework.data.repository.CrudRepository;

import anneAndy.projects.ArtCritSiteBack.User.User;

public interface ImageRepository extends CrudRepository<Image, String> {
	Image findByKeyName(String keyName);
	Image save(Image image);
}