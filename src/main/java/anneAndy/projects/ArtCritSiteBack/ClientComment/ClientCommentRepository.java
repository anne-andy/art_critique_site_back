package anneAndy.projects.ArtCritSiteBack.ClientComment;

import org.springframework.data.repository.CrudRepository;

public interface ClientCommentRepository extends CrudRepository<ClientComment, Long> {
	ClientComment save(ClientComment clientComment);
}