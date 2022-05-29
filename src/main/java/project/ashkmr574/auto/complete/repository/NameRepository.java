package project.ashkmr574.auto.complete.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.ashkmr574.auto.complete.domain.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, String> {

}
