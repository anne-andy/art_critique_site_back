package anneAndy.projects.ArtCritSiteBack.repositories;

import org.springframework.data.repository.CrudRepository;

import anneAndy.projects.ArtCritSiteBack.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
