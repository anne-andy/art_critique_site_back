package anneAndy.projects.ArtCritSiteBack.UploaderComment;

import org.springframework.data.repository.CrudRepository;

import anneAndy.projects.ArtCritSiteBack.User.User;

public interface UploaderCommentRepository extends CrudRepository<UploaderComment, Long> {
	// save(Image image);
}