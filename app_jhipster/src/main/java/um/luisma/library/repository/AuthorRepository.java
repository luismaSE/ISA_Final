package um.luisma.library.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import um.luisma.library.domain.Author;

/**
 * Spring Data JPA repository for the Author entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {}
