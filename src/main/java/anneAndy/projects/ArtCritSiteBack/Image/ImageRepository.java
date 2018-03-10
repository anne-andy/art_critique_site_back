package anneAndy.projects.ArtCritSiteBack.Image;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import anneAndy.projects.ArtCritSiteBack.User.User;

public interface ImageRepository extends CrudRepository<Image, String> {
	Image findByImageKey(String imageKey);
	Image save(Image image);
	Iterable<Image> findAll();
	Iterable<Image> findTop50ByOrderByDateSubmittedDesc();
}